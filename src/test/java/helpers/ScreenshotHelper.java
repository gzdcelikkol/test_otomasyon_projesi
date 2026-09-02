package helpers;

import driverManager.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHelper {


    @Attachment(value = "Hata Ekran Goruntusu", type = "image/png")
    public static byte[] takeScreenshot() {
        if (Driver.getDriver() != null) {
            return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}