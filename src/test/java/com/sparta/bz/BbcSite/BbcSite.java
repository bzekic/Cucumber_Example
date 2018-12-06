package com.sparta.bz.BbcSite;

import com.sparta.bz.BbcSite.BbcPages.BbcHomePage;
import com.sparta.bz.BbcSite.BbcPages.BbcSignInPage;
import org.openqa.selenium.WebDriver;

public class BbcSite {

    private WebDriver driver;
    BbcHomePage bbcHomePage;
    BbcSignInPage bbcSignInPage;

    public BbcSite(WebDriver driver) {
        this.driver = driver;
        bbcHomePage = new BbcHomePage(driver);
        bbcSignInPage = new BbcSignInPage(driver);
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public void quit(){
        driver.quit();
    }
    //page accessors

    public BbcHomePage bbcHomePage(){
        return bbcHomePage;
    }

    public BbcSignInPage bbcSignInPage(){
        return bbcSignInPage;
    }
}