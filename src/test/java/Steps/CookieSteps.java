package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import org.openqa.selenium.JavascriptExecutor;
import utils.AllureStepRunner;

public class CookieSteps {

    @Step("User accepts cookies.")
    public void acceptCookies() {
        AllureStepRunner.run("Çerez Pop-up'ı Kapatılıyor", () -> {
            try {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

                String jsCommand = "document.querySelector('efilli-layout-dynamic').shadowRoot.querySelector('div[data-name=\"Accept Button\"]').click();";
                js.executeScript(jsCommand);

            } catch (Exception e) {
                System.out.println("Çerez pop-up'ı bulunamadı veya kapatılamadı: " + e.getMessage());
            }
        });
    }
}