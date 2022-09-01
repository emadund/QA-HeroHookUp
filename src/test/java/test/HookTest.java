package test;

import base.HookBase;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.ElementalSelenium;
import page.GitHub;
import page.HeroSecure;
import page.HookHome;

import java.util.concurrent.TimeUnit;

public class HookTest extends HookBase {
    private HookHome hookHome;
    private HeroSecure heroSecure;
    private GitHub gitHub;
    private ElementalSelenium elementalSelenium;
    private final String user="tomsmith";
    private final String pass="SuperSecretPassword!";

    @Before

    public void setupTest () {
        hookHome = new HookHome();
        heroSecure = new HeroSecure();
        gitHub = new GitHub();
        elementalSelenium = new ElementalSelenium();
    }
    @Test

    public void negativeTestCase1 () {
        hookHome.clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test

    public void negativeTestCase2 () {
        hookHome.fillUsername(user)
                .clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test

    public void negativeTestCase3 () {
        hookHome.fillPassword(pass)
                .clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test
    public void negativeTestCase4 () {
        hookHome.fillUsername("wrongOnPurpose")
                .fillPassword(pass)
                .clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test
    public void negativeTestCase5 () {
        hookHome.fillUsername(user)
                .fillPassword("wrongOnPurpose")
                .clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test
    public void negativeTestCase6 () {
        hookHome.fillUsername("wrongToo")
                .fillPassword("wrongOnPurpose")
                .clickLogin();
        Assert.assertTrue(hookHome.bannerDisplayed());
    }
    @Test
    public void positiveTestCase1 () {
        hookHome.fillPassword(pass)
                .fillUsername(user)
                .clickLogin();
        Assert.assertTrue(heroSecure.secureIsDisplayed());
    }
    @Test
    public void positiveTestCase2 () {
        this.positiveTestCase1();
        heroSecure.clickLogOut();
        Assert.assertTrue(hookHome.greenDisplayed());

    }
    @Test
    public void positiveTestCase3 () {
       this.positiveTestCase1();
        hookHome.redRemove();
    }
    @Test
    public void positiveTestCase4 () {
        this.positiveTestCase1();
        heroSecure.closeGreen();
    }
    @Test
    public void positiveTestCase5 () {
        this.positiveTestCase2();
        hookHome.redRemove();
    }
    @Test
    public void positiveTestCase6() {
        hookHome.clickGitHub();
        Assert.assertTrue(gitHub.isGitHubDisplayed());
    }
    @Test
    public void positiveTestCase7 () {
        this.positiveTestCase1();
        hookHome.clickGitHub();
        Assert.assertTrue(gitHub.isGitHubDisplayed());
    }
    @Test
    public void positiveTestCase8() {
        hookHome.clickSelenium();
        elementalSelenium.moveToNewTab();
        Assert.assertTrue(elementalSelenium.elementalSeleniumDisplayed());
        Assert.assertEquals("Elemental Selenium", elementalSelenium.elementalSeleniumText());
    }
    @Test
    public void positiveTestCase9() {
        this.positiveTestCase1();
        hookHome.clickSelenium();
        elementalSelenium.moveToNewTab();
        Assert.assertTrue(elementalSelenium.elementalSeleniumDisplayed());
        Assert.assertEquals("Elemental Selenium", elementalSelenium.elementalSeleniumText());
        elementalSelenium.returnToFirstTab();
        Assert.assertTrue(heroSecure.secureIsDisplayed());
    }
    @Test
    public void positiveTestCase10 () {
        Assert.assertEquals("Powered by Elemental Selenium",hookHome.powerText());
    }
    @Test
    public void positiveTestCase11 () {
        Assert.assertEquals("Login Page",hookHome.loginText());
    }
    @Test
    public void positiveTestCase12 () {
        Assert.assertEquals("This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.",hookHome.subText());
    }
    @Test
    public void positiveTestCase13 () {
        Assert.assertEquals("Login",hookHome.logButtonText());
    }
    @Test
    public void positiveTestCase14 () {
        this.positiveTestCase1();
        Assert.assertEquals("Secure Area",heroSecure.secureText());
    }
    @Test
    public void positiveTestCase15() {
        this.positiveTestCase14();
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.",heroSecure.longGetText());
    }
    @Test
    public void positiveTestCase16() {
        this.positiveTestCase15();
        Assert.assertEquals("Logout", heroSecure.logOutText());
    }
}
