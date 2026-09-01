package helpers;

import driverManager.Driver;
import locators.LocatorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ElementHelper {

    public static WebElement findElement(String pageName, String elementName){ // elementi buluyor
        By locator = LocatorManager.getLocator(pageName, elementName);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  // elementi bulup görünür olması için bekler
    }

    // bulunan elemente tıklayabilmek için
    public static void click(String pageName, String elementName){
        WebElement element = findElement(pageName, elementName);
        element.click();
    }

    // elemente bir veri girişi yapmak için örn. login page'de username, password
    public static void sendKeys(String pageName, String elementName, String text){
        WebElement element = findElement(pageName, elementName);
        element.clear();
        element.sendKeys(text);
    }
}
