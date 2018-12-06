package com.sparta.bz.BbcSite.seleniumConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SeleniumProperties {
    private String chromeDriverPath;
    private String firefoxDriverPath;
    private String edgeDriverPath;
    private Long implicitWaitTime;

    public SeleniumProperties(String browser){
        Properties seleniumProperties = new Properties();
        try {
            seleniumProperties.load(new FileReader("C:\\Users\\TECH-W91\\engineering18\\cucumberExample\\src\\test\\java\\com\\sparta\\bz\\BbcSite\\seleniumConfig\\selenium.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chromeDriverPath = seleniumProperties.getProperty("chromeDriverPath");
        firefoxDriverPath = seleniumProperties.getProperty("firefoxDriverPath");
        edgeDriverPath = seleniumProperties.getProperty("edgeDriverPath");
        implicitWaitTime = Long.parseLong(seleniumProperties.getProperty("implicitWaitTime"));
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
    public String getFirefoxDriverPath() {
        return firefoxDriverPath;
    }
    public String getEdgeDriverPath() {
        return edgeDriverPath;
    }
    public Long getImplicitWaitTime() {
        return implicitWaitTime;
    }
}