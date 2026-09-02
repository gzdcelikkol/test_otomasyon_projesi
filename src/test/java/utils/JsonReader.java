package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {
    private static final ObjectMapper mapper = new ObjectMapper();
    // çıktısı json node olduğu için
    public static JsonNode readJson(String filePath){
        try {
            return mapper.readTree(new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException("JSON dosyası okunamadı: " + filePath, e);
        }
    }
}
