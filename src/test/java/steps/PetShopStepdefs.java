package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PetShopStepdefs{
    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am at this webpage {string}")
    public void iAmAtThisWebpage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }


    @And("I close all Popups for necessity")
    public void iCloseAllPopupsForNecessity() {
        driver.findElement(By.cssSelector(".accept")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".sqs-popup-overlay-close")))).click();
    }

    @And("I am at the {string} startpage")
    public void iAmAtTheStartpage(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @When("I add item {string} go to cart")
    public void iAddItemGoToCart(String itemName) {
        String newID = "#thumb-"+itemName.toLowerCase().replace(" ","-");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(newID))).click();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                (".ProductItem-details-checkout .sqs-add-to-cart-button-wrapper .sqs-add-to-cart-button-inner")));
        addButton.click();
    }

    @Then("The cart includes {int} {string}")
    public void theCartIncludes(int itemQuantity, String itemName) {
        // wait for an iframe to slide out and change to that iframe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".slide-out .slide-out-wrapper .slide-out-container")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("cartFrame")));

        // Compare product name
        WebElement elementName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"cart-table-row\"] .cart-row-title")));
        String text = elementName.getText();
        assertEquals(itemName,text);

        // compare number of items
        WebElement elementQuantity = driver.findElement(By.cssSelector("[data-testid=\"cart-table-row\"] .cart-row-qty > div [data-test=\"quantity-input\"]"));
        int quantity = Integer.parseInt(Objects.requireNonNull(elementQuantity.getDomAttribute("value")));
        assertEquals(itemQuantity,quantity);
    }


}
