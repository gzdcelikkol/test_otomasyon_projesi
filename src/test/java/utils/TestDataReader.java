package utils;

import com.fasterxml.jackson.databind.JsonNode;

public class TestDataReader {

    public static String getTestData(String fileName, String key) {
        String filePath = "src/test/resources/testdata/" + fileName + ".json";

        // Merkezi JsonReader'ı kullanıyoruz
        JsonNode rootNode = JsonReader.readJson(filePath); // readJson bizim yazdığımız json'u veren fonksiyon

        if (rootNode != null && rootNode.has(key)) {
            return rootNode.get(key).asText();
        }

        throw new RuntimeException(fileName + ".json içinde '" + key + "' anahtarı bulunamadı.");
    }
}