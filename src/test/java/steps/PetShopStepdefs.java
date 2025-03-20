package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetShopStepdefs{
    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='sqs-add-to-cart-button-inner']")));
        addButton.click();
    }

    @Then("The cart includes {int} {string}")
    public void theCartIncludes(int arg0, String arg1) {
    }


}
