package com.sparta.bz.BbcSite.seleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriverConfig {

    private WebDriver driver;

    public SeleniumDriverConfig(String browser) {
        SeleniumProperties seleniumProperties = new SeleniumProperties(browser);

        if (browser.equalsIgnoreCase( "chrome" )) {
            System.setProperty("webdriver.chrome.driver", seleniumProperties.getChromeDriverPath());
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase( "firefox" )) {
            System.setProperty("webdriver.gecko.driver", seleniumProperties.getFirefoxDriverPath());
            this.driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase( "edge")){
            System.setProperty("webdriver.edge.driver", seleniumProperties.getEdgeDriverPath());
            this.driver = new EdgeDriver();
        }
        this.driver.manage().timeouts().implicitlyWait(seleniumProperties.getImplicitWaitTime(), TimeUnit.SECONDS);
    }
    public WebDriver getDriver() {
        return driver;
    }
}