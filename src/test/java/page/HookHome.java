package page;

import base.HookBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HookHome extends HookBase {
    @FindBy (id="username")
    WebElement username;
    @FindBy (id ="password")
    WebElement password;
    @FindBy (css = ".fa.fa-2x.fa-sign-in")
    WebElement login;
    @FindBy (linkText = "Elemental Selenium")
    WebElement selenium;
    @FindBy (css = "[alt=\"Fork me on GitHub\"]")
    WebElement github;
    @FindBy (css=".flash.error")
    WebElement banner;
    @FindBy (css=".flash.success")
    WebElement greenBanner;
    @FindBy (css =".close")
    WebElement redX;
    @FindBy (id="flash-messages")
    WebElement flash;
    @FindBy (css = "[style=\"text-align: center;\"]")
    WebElement power;
    @FindBy (xpath = "//*[@id=\"content\"]/div/h2")
    WebElement loginText;
    @FindBy (xpath="//*[contains(text(),\"This is where you can log into the secure area. Enter \")]")
    WebElement subheader;

    public HookHome () {
        PageFactory.initElements(driver, this);
    }
    public void clickLogin () {
        wdWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
    }
    public boolean bannerDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(banner));
        return banner.isDisplayed();
        }
       public HookHome fillUsername(String x) {
        wdWait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(x); return this;
       }
    public HookHome fillPassword(String x) {
        wdWait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(x); return this;
    }
    public boolean greenDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(greenBanner));
        return greenBanner.isDisplayed();
    }
    public void redRemove () {
        wdWait.until(ExpectedConditions.elementToBeClickable(redX));
        redX.click();
    }
    public void clickGitHub() {
        wdWait.until(ExpectedConditions.elementToBeClickable(github));
        github.click();
    }
    public void clickSelenium() {
        wdWait.until(ExpectedConditions.elementToBeClickable(selenium));
        selenium.click();
    }
    public String powerText() {
        wdWait.until(ExpectedConditions.visibilityOf(power));
        return power.getText();
    }
    public String loginText() {
        wdWait.until(ExpectedConditions.visibilityOf(loginText));
        return loginText.getText();
    }
    public String subText() {
        wdWait.until(ExpectedConditions.visibilityOf(subheader));
        return subheader.getText();
    }
    public String logButtonText() {
        wdWait.until(ExpectedConditions.visibilityOf(login));
        return login.getText();
    }




}
