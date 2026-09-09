package helpers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class VerifyHelper {

    public static void verifyElementIsDisplayed(String pageName, String elementName) {

        WebElement element = ElementHelper.findElement(pageName, elementName); // elementi bulduk

        Assertions.assertThat(element.isDisplayed())// elementi kontrol etmek için
                .as(pageName + " sayfasındaki " + elementName + " elementi görünür olmalı.")
                .isTrue();
    }
}

// displayed visible presence farkı nedir
