package stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class OwnerSteps {
    private WebDriver driver;

    @Given("I am on the New Owner page")
    public void navigateToOwnersPage() {
        driver = DriverManager.getDriver();
        driver.get("http://localhost:4200/petclinic/owners/add");
    }

    @When("I click on {Add Owner}")
    public void clickButton(String buttonText) {
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
    }

    @When("I fill the form with:")
    public void fillForm(Map<String, String> data) {
        driver.findElement(By.id("firstName")).sendKeys(data.get("First Name"));
        driver.findElement(By.id("lastName")).sendKeys(data.get("Last Name"));
        driver.findElement(By.id("address")).sendKeys(data.get("Address"));
        driver.findElement(By.id("city")).sendKeys(data.get("City"));
        driver.findElement(By.id("telephone")).sendKeys(data.get("Telephone"));
    }

    @Then("I should see {Ortiz} in the owners list")
    public void verifyOwnerInList(String ownerName) {
        assertTrue(driver.getPageSource().contains(ownerName));
    }
}
