package helpers;

import driverManager.Driver;
import locators.LocatorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import java.time.Duration;
public class ElementHelper {

    public static void selectByVisibleText(String pageName, String elementName, String text){

        WebElement element = WaitHelper.waitForElementVisible(pageName,elementName);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static WebElement findElement(String pageName, String elementName){ // elementi buluyor
        return WaitHelper.waitForElementVisible(pageName, elementName);
  // elementi bulup görünür olması için bekler
    }

    // bulunan elemente tıklayabilmek için
    public static void click(String pageName, String elementName){
        WebElement element = WaitHelper.waitForElementClickable(pageName, elementName);
        element.click();
    }

    // elemente bir veri girişi yapmak için örn. login page'de username, password
    public static void sendKeys(String pageName, String elementName, String text){
        WebElement element = WaitHelper.waitForElementVisible(pageName, elementName);
        element.clear();
        element.sendKeys(text);
    }

    public static void sendKeysAndEnter(String pageName, String elementName, String text) {
        WebElement element = WaitHelper.waitForElementVisible(pageName, elementName);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER); // Butona basmak yerine klavyeden Enter'a basıyoruz
    }

}
