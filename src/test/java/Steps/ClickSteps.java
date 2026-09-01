package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ElementHelper;


public class ClickSteps {

    @Step("User clicks <elementName> on <pageName> page.")
    public static void clickElement(String elementName, String pageName){
        ElementHelper.click(pageName,elementName);
    }
}
