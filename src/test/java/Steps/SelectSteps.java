package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ElementHelper;

public class SelectSteps {

    @Step("User selects <text> from <elementName> dropdown on <pageName> page.")
    public void selectFromDropdown(String text, String elementName, String pageName){
        ElementHelper.selectByVisibleText(pageName,elementName,text);
    }

}
