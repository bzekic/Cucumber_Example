package com.sparta.bz.BbcSite.BbcPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BbcSignInPage {
    // Set up driver
    private WebDriver driver;
    // Set up page path
    private String signInPageURL = "https://account.bbc.com/signin";
    // Page object identifier
    private By usernameFieldId = By.id("user-identifier-input");
    private By passwordFieldId = By.id("password-input");
    private By submitButtonId = By.id("submit-button");
    private By incorrectPasswordErrorId = By.id("form-message-password");

    public BbcSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSignInPage(){
        driver.navigate().to(signInPageURL);
    }

    public void inputUserName(String name){
        driver.findElement(usernameFieldId).sendKeys(name);
    }

    public void inputPassword(String password){
        driver.findElement(passwordFieldId).sendKeys(password);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonId).click();
    }

    public String getPasswordErrorText(){
        return driver.findElement(incorrectPasswordErrorId).getText();
    }

    //page assertion

    public void AssertCurrentURLIsSignInPage(){
        Assert.assertEquals(driver.getCurrentUrl(), signInPageURL);
    }
}
