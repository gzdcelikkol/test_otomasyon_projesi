package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ElementHelper;
import helpers.TestDataHelper;
import locators.LocatorManager;

public class WriteSteps {

    @Step("User enters <text> into <elementName> on <pageName> page.")
    public static void write(String text, String elementName, String pageName){
        String resolvedText = TestDataHelper.resolveData(text);
        ElementHelper.sendKeys(pageName, elementName, resolvedText);

    }


}
