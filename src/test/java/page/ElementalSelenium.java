package page;

import base.HookBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class ElementalSelenium extends HookBase {
    @FindBy (xpath = "/html/body/header/div/div/h1")
    WebElement selenium2;

    public ElementalSelenium () {
        PageFactory.initElements(driver, this);
    }
    public boolean elementalSeleniumDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(selenium2));
        return selenium2.isDisplayed();
    }
    public String elementalSeleniumText () {
        wdWait.until(ExpectedConditions.visibilityOf(selenium2));
        return selenium2.getText();
    }

    public void returnToFirstTab () {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
    public void moveToNewTab () {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }
}
