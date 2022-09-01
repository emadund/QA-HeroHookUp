package page;

import base.HookBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeroSecure extends HookBase {
    @FindBy (id="flash")
    WebElement secureSuccess;
    @FindBy (css=".button.secondary.radius")
    WebElement logOut;
    @FindBy (css=".close")
    WebElement greenClose;
    @FindBy (xpath = " //*[contains(text(),\"Secure Area\")][1]")
    WebElement secureArea;
    @FindBy (xpath = "//*[contains(text(),\"Welcome to the Secure Area. When you are done click logout below.\")]")
    WebElement longText;

public HeroSecure () {
    PageFactory.initElements(driver, this);
}
public boolean secureIsDisplayed () {
    wdWait.until(ExpectedConditions.visibilityOf(secureSuccess));
    return secureSuccess.isDisplayed();
}
public void clickLogOut () {
    wdWait.until(ExpectedConditions.elementToBeClickable(logOut));
    logOut.click();
}
public void closeGreen () {
    wdWait.until(ExpectedConditions.elementToBeClickable(greenClose));
    greenClose.click();
}
public String secureText() {
    wdWait.until(ExpectedConditions.visibilityOf(secureArea));
    return secureArea.getText();
}
    public String longGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(longText));
        return longText.getText();
    }
    public String logOutText () {
    wdWait.until(ExpectedConditions.elementToBeClickable(logOut));
    return logOut.getText();
    }


}
