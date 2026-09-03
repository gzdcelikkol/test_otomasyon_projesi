package Steps;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.AllureStepRunner;

public class WaitSteps {

    private static final Logger logger = LogManager.getLogger(WaitSteps.class);

    @Step("User waits for <seconds> seconds")
    public void waitBySeconds(int seconds) {
        AllureStepRunner.run("Kullanıcı " + seconds + " saniye bekliyor", () -> {
            try {
                Thread.sleep(seconds * 1000L);
                logger.info(seconds + " saniye statik bekleme yapıldı.");
            } catch (InterruptedException e) {
                logger.error("Bekleme sırasında hata: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        });
    }
}