package com.sparta.bz.BbcSite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format ={"pretty","html:src/reports"},
        features ={"C:\\Users\\TECH-W91\\engineering18\\cucumberExample\\src\\test\\resources\\features\\login.feature"},
        glue ={"step_Defs"},
        tags = {"@Test"}
)

public class TestCukesJunitRunner {
}