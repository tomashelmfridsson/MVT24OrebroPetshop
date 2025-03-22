package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasketStepdefs {
    WebDriver driver = new ChromeDriver();
    
    @Given("I am at webpage {string}")
    public void iAmAtWebpage(String url) {
        driver.get(url);
    }
    
    @When("I register a user")
    public void iRegisterAUser() {
        driver.findElement(By.cssSelector("input.custom-date")).sendKeys("2000/01/01");
        driver.findElement(By.cssSelector("input#member_firstname")).sendKeys("Kalle");
        driver.findElement(By.cssSelector("input#member_lastname")).sendKeys("Testsson");
        driver.findElement(By.cssSelector("input#member_emailaddress")).sendKeys("tomastestgubbe@gmail.com");
        driver.findElement(By.cssSelector("input#member_confirmemailaddress")).sendKeys("tomastestgubbe@gmail.com");
        driver.findElement(By.cssSelector("input#signupunlicenced_password")).sendKeys("abc123");
        driver.findElement(By.cssSelector("input#signupunlicenced_confirmpassword")).sendKeys("abc123");
        driver.findElement(By.id("signup_basketballrole_19")).click();
        driver.findElement(By.cssSelector("[name='TermsAccept']")).click();

    }


    @Then("it confirms Ok")
    public void itConfirmsOk() {
    }
}
