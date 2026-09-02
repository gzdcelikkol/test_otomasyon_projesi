package utils;

import helpers.ScreenshotHelper;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

import java.util.UUID;

public class AllureStepRunner {

    public static void run(String stepName, Runnable stepCode) {
        String uuid = UUID.randomUUID().toString();
        // Allure üzerinde yeni bir step
        Allure.getLifecycle().startStep(uuid, new StepResult().setName(stepName).setStatus(Status.PASSED));

        try {
            // Asıl test çalışıyor
            stepCode.run();
            // Başarılıysa Allure u kapatıyoruz
            Allure.getLifecycle().stopStep(uuid);

        } catch (Throwable t) {
            // Hata alırsak durumu başarısız olarak işaretliyoruz
            AllureStatusHolder.setPassed(false);
            Allure.getLifecycle().updateStep(uuid, s -> s.setStatus(Status.FAILED));
            // Ekran görüntüsü alıyoruz ve adımı kapatıyoruz
            ScreenshotHelper.takeScreenshot();
            Allure.getLifecycle().stopStep(uuid);
            // Testi durdurmak için hatayı throwluyoruz ki sistem catch'leyip terminalde failed olsun.
            throw t;
        }
    }
}