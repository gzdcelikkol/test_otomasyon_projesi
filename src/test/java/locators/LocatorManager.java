package locators;

import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.By;
import utils.JsonReader;

import java.io.IOException;

public class LocatorManager {
    public static By getLocator(String pageName, String elementName){
        //pagename ex. login, cart gibi böylece gerekli id'lerin olduğu locator json'unu çeksin.
        String filePath = "src/test/resources/locators/" + pageName + "locators.json";
        JsonNode rootNode = JsonReader.readJson(filePath);
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
        }
    }

