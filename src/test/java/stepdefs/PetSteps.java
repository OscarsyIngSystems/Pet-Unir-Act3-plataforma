package stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class PetSteps {
    private WebDriver driver;

    @Given("I am viewing owner {Miguel Ortiz}")
    public void navigateToOwnerDetails(String ownerName) {
        driver = DriverManager.getDriver();
        driver.findElement(By.linkText(ownerName)).click();
    }

    @When("I fill the pet form with:")
    public void fillPetForm(Map<String, String> data) {
        driver.findElement(By.id("name")).sendKeys(data.get("Name"));
        driver.findElement(By.id("birthDate")).sendKeys(data.get("Birth Date"));
        Select typeDropdown = new Select(driver.findElement(By.id("type")));
        typeDropdown.selectByVisibleText(data.get("Type"));
    }

    @Then("I should see {Krypto} in the pets list")
    public void verifyPetInList(String petName) {
        assertTrue(driver.getPageSource().contains(petName));
    }
}
