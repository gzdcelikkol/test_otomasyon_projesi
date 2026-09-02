package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.qameta.allure.model.Status;
import driverManager.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.model.TestResult;
import utils.AllureStatusHolder;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class BaseTest {
    private String testUuid;

    @BeforeScenario
    public void setUp(ExecutionContext context){

        // Allure senaryosunu başlatıyoruz ki testi izlesin
        testUuid = UUID.randomUUID().toString();
        String scenarioName = context.getCurrentScenario().getName();
        Allure.getLifecycle().scheduleTestCase(new TestResult().setUuid(testUuid).setName(scenarioName));
        Allure.getLifecycle().startTestCase(testUuid);
        AllureStatusHolder.setPassed(true);
        // başarılı olmazsa ss alacak ve senaryo ismi ile kaydedecek

        WebDriver driver = Driver.getDriver(); // driver.java'da yazdığımız metot
        String url = ConfigReader.getProperty("url");
        driver.get(url); // böylece biz her test öncesi siteyi de aç demek zorunda değiliz.




    }

    @AfterScenario
    public void tearDown(){
        Driver.quitDriver();
        //bitince browser'ı kapat.

        if (AllureStatusHolder.isPassed()) {
            Allure.getLifecycle().updateTestCase(testUuid, tr -> tr.setStatus(Status.PASSED));
        } else {
            Allure.getLifecycle().updateTestCase(testUuid, tr -> tr.setStatus(Status.FAILED));
        }

        Allure.getLifecycle().stopTestCase(testUuid);
        Allure.getLifecycle().writeTestCase(testUuid);

        AllureStatusHolder.clear();
    }

    }

