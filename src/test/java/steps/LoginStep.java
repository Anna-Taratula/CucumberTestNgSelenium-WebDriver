package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;
import pages.LoginPage;

import static pages.CucumberDriver.getDriver;

public class LoginStep {
    LoginPage loginPage;

    @Given("I click login icon")
    public void i_click_login_icon() {
        loginPage = new HomePage(getDriver()).goToSite().clickSignInIcon();

    }

    @When("I input valid value")
    public void i_input_valid_value() {
        loginPage.inputEmail().clickContinue().inputPassword().clickSignIn();

    }

    @Then("I got error message")
    public void i_got_error_message() {
        loginPage.errorMessage();

    }


}
