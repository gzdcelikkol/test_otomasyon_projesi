package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class TestDataHelper {

    public static String resolveData(String rawData) {
        // Gelen metin "login.standardUser" formatındaysa JSON'dan okur
        if (rawData != null && rawData.contains(".")) {
            String[] parts = rawData.split("\\.");
            String fileName = parts[0];
            String key = parts[1];

            String filePath = "src/test/resources/testdata/" + fileName + ".json";
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(new File(filePath));
                if (rootNode.has(key)) { // verdiğimiz json dosyasında key'imiz örn. login.standardUser daki standardUser'ın olduğu yeri arar
                    return rootNode.get(key).asText(); // value'yu (texti) verir.
                }
            } catch (Exception e) {
                throw new RuntimeException("Test verisi okunamadı: " + filePath, e);
            }
        }
        // Eğer nokta yoksa (düz metinse) olduğu gibi döndürür
        return rawData;
    }
}