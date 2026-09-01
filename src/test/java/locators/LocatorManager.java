package locators;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

public class LocatorManager {
    public static By getLocator(String pageName, String elementName){
        ObjectMapper mapper = new ObjectMapper();
        //pagename ex. login, cart gibi böylece gerekli id'lerin olduğu locator json'unu çeksin.
        String filePath = "src/test/resources/locators/" + pageName + "locators.json";

        try {
            // JSON dosyasını okuma
            JsonNode rootNode = mapper.readTree(new File(filePath));
            JsonNode elementNode = rootNode.get(elementName);

            if (elementNode == null) {
                throw new RuntimeException("Element bulunamadı: " + elementName + " (Dosya: " + filePath + ")");
            }

            String type = elementNode.get("type").asText();
            String value = elementNode.get("value").asText();

            switch (type.toLowerCase()) { // json'dan type çekiyoruz, bu type'ı selenium'daki By.** metotlarıyla eşleştirdik.
                case "id":
                    return By.id(value);
                case "xpath":
                    return By.xpath(value);
                case "css":
                    return By.cssSelector(value);
                case "name":
                    return By.name(value);
                case "class":
                    return By.className(value);
                default:
                    throw new RuntimeException("Desteklenmeyen locator tipi: " + type);
            }
        } catch (IOException e) {
            throw new RuntimeException("JSON dosyası okunamadı: " + filePath, e);
        }
    }
}
