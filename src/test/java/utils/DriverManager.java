package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    // Inicializa el WebDriver (Chrome en este caso)
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "ruta/a/chromedriver.exe"); // Configura la ruta de tu
                                                                                      // chromedriver
            driver = new ChromeDriver();
        }
        return driver;
    }

    // Cierra el driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
