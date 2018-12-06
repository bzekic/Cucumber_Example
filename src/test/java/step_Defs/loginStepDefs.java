package step_Defs;

import com.sparta.bz.BbcSite.seleniumConfig.SeleniumDriverConfig;
import com.sparta.bz.BbcSite.seleniumConfig.SeleniumProperties;
import cucumber.api.PendingException;
import com.sparta.bz.BbcSite.BbcPages.BbcHomePage;
import com.sparta.bz.BbcSite.BbcSite;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStepDefs {

    private ChromeDriver chromeDriver;
    private BbcSite bbcSite;

    public loginStepDefs() {
        SeleniumDriverConfig config = new SeleniumDriverConfig("firefox");
        bbcSite = new BbcSite(config.getDriver());
    }

    @Before
    public void beforeHook(){
        System.out.println("this wins");
    }

    /*testing scenario without scenario outlines*/

    @Given("^I am able to access the sign in page$")
    public void i_am_able_to_access_the_sign_in_page() throws Throwable {
        bbcSite.bbcSignInPage().goToSignInPage();
        Assert.assertEquals(bbcSite.bbcSignInPage().getSignInPageURL(), bbcSite.getCurrentURL());
    }

    @When("^I use incorrect credentials to login$")
    public void i_use_incorrect_credentials_to_login() throws Throwable {
        bbcSite.bbcSignInPage().inputUserName("email@email.com");
        bbcSite.bbcSignInPage().inputPassword("123456789");
        bbcSite.bbcSignInPage().clickSubmitButton();
    }

    @Then("^I receive a viable error$")
    public void i_receive_a_viable_error() throws Throwable {
        Assert.assertEquals(bbcSite.bbcSignInPage().getErrorText(),bbcSite.bbcSignInPage().getPasswordErrorText());
        bbcSite.quit();
    }

    /*testing scenario outlines*/

    @Given("^I am on the BBC sign in page$")
    public void i_am_on_the_BBC_sign_in_page() throws Throwable {
        bbcSite.bbcSignInPage().goToSignInPage();
        Assert.assertEquals(bbcSite.bbcSignInPage().getSignInPageURL(), bbcSite.getCurrentURL());
    }

    @When("^I input a valid email address$")
    public void i_input_a_valid_email_address() throws Throwable {
        bbcSite.bbcSignInPage().inputUserName("email@email.com");
    }

    @And("^I input an invalid (.*) that will generate an error message$")
    public void i_input_an_invalid_a_that_will_generate_an_error_message(String password) throws Throwable {
        bbcSite.bbcSignInPage().inputPassword(password);
        bbcSite.bbcSignInPage().clickSubmitButton();
    }

    @Then("^I receive the corresponding error (.*)$")
    public void i_receive_the_corresponding_error(String error) throws Throwable {
        Assert.assertEquals(error,bbcSite.bbcSignInPage().getPasswordErrorText());
        bbcSite.quit();
    }
}