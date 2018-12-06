package com.sparta.bz.BbcSite.BbcPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BbcHomePage {

    private WebDriver driver;

    private String homePageURL = "http://www.bbc.co.uk/";
    private By signInLinkId = By.id("idcta-username");

    public BbcHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePsge(){
        driver.navigate().to(homePageURL);
    }

    public void clickSignIn(){
        driver.findElement(signInLinkId).click();
    }
}

