package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import pages.HomePage;

import pages.RegisterPage;

import static pages.CucumberDriver.getDriver;

public class RegisterStep {

    RegisterPage registerPage;

    @Given("I click login as a new customer")
    public void i_click_login_as_a_new_customer() {
        registerPage = new HomePage(getDriver()).goToSite().clickSignAsNewCustomer();
    }

    @When("I  input valid value")
    public void i_input_valid_value() {
        String randomEmail = RandomStringUtils.randomAlphabetic(10);
        registerPage.inputName().inputEmail(randomEmail).inputPassword().inputRePassword();
    }

    @Then("I got to solve a puzzle")
    public void i_got_to_solve_a_puzzle() {
        registerPage.enableContinueButton();
    }
}
