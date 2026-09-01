package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Tarayıcı tipini ortam değişkeninden okuyoruz[cite: 1]
            String browser = System.getenv("BROWSER") != null //browser null ise -> default chrome olsun
                    ? System.getenv("BROWSER").toLowerCase() // değilse hepsini küçük harflere çevirsin
                    : "chrome";

            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private"); // Gizli mod
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito"); // Gizli mod
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }

            driver.manage().window().maximize(); // açılan sayfayı full ekran yapıyor
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Bir sonraki test için driver'ı sıfırlıyoruz
        }
    }
}