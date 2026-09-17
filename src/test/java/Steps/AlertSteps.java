package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import helpers.WaitHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import utils.AllureStepRunner;

public class AlertSteps {

    @Step("User verifies alert message is <expectedMessage> and accepts it")
    public void verifyAndAcceptAlert(String expectedMessage) {
        AllureStepRunner.run("Kullanıcı alert pop-up'ını doğruluyor ve kapatıyor", () -> {

            WaitHelper.waitForAlert();
            Alert alert = Driver.getDriver().switchTo().alert();

            String actualMessage = alert.getText();
            Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);

            alert.accept();
        });
    }


}