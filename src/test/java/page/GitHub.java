package page;

import base.HookBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitHub extends HookBase {
    @FindBy (xpath="//*[@class=\"d-flex flex-justify-between flex-items-center\"]")
    WebElement cat;

    public GitHub () {
        PageFactory.initElements(driver, this);
    }
    public boolean isGitHubDisplayed () {
        wdWait.until(ExpectedConditions.elementToBeClickable(cat));
        return cat.isDisplayed();
    }
}
