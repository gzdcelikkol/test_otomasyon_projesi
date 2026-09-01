package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import driverManager.Driver;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    @BeforeScenario
    public void setUp(){
        WebDriver driver = Driver.getDriver(); // driver.java'da yazdığımız metot
        String url = ConfigReader.getProperty("url");
        driver.get(url); // böylece biz her test öncesi siteyi de aç demek zorunda değiliz.
    }

    @AfterScenario
    public void tearDown(){
        Driver.quitDriver();
        //bitince browser'ı kapat.
    }
}
