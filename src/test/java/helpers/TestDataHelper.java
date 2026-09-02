package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.TestDataReader;

import java.io.File;

public class TestDataHelper {

    public static String resolveData(String rawData) {
        // Gelen metin "login.standardUser" formatındaysa JSON'dan okur
        if (rawData != null && rawData.contains(".")) {
            String[] parts = rawData.split("\\.");
            return TestDataReader.getTestData(parts[0], parts[1]);
            // json'u direkt bizim getTestData metodumuzla okuyor.
        }

        // Eğer nokta yoksa (düz metinse) olduğu gibi döndürür
        return rawData;
    }
}