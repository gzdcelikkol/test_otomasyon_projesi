package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try { // bu ilk iki satırla config properties'ten url'yi input olarak çekiyor
            String path = "config.properties";
            FileInputStream input = new FileInputStream(path);

            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (IOException e) { // eğer config properties yoksa hata vermemesi için
            e.printStackTrace();
            throw new RuntimeException("config.properties dosyası bulunamadı veya okunamadı!");
        }
    }

    // Diğer sınıflardan veri çekerken kullanılacak metot
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}