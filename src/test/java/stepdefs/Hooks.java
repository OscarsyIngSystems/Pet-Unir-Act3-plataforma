package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManager;

public class Hooks {

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        // 1. Verifica si el escenario falló
        if (scenario.isFailed()) {
            // 2. Toma screenshot si hay error
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "error_screenshot");
        } else {
            // 3. Opcional: Tomar screenshot en todos los pasos (incluso si no hay error)
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "step_screenshot");
        }
    }
}
