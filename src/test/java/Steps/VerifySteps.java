package Steps;

import com.thoughtworks.gauge.Step;
import helpers.VerifyHelper;

public class VerifySteps {

    @Step("User should see <elementName> on <pageName> page.")
    public void verifyElement(String elementName, String pageName) {
        VerifyHelper.verifyElementIsDisplayed(pageName, elementName);
    }
}
