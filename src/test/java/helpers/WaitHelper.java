package helpers;
import driverManager.Driver;
import locators.LocatorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class WaitHelper {

        // Maksimum bekleme süresi. Element daha erken yüklenirse hemen işleme geçer.
        private static final int DEFAULT_TIMEOUT = 10;

        // Elementin ekranda görünür olmasını bekler

        public static WebElement waitForElementVisible(String pageName, String elementName) {

            By locator = LocatorManager.getLocator(pageName, elementName);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Elementin tıklanabilir olmasını bekler

        public static WebElement waitForElementClickable(String pageName, String elementName) {

            By locator = LocatorManager.getLocator(pageName, elementName);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

    // JavaScript Alert (Uyarı) penceresinin ekranda belirmesini bekler
    public static void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    }






