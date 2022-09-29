package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangeLanguagePage;

import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class LanguageChangeStep {

    ChangeLanguagePage changeLanguagePage;


    @Given("I click the language icon")
    public void i_click_the_language_icon() {
        changeLanguagePage = new HomePage(getDriver()).goToSite().clickLanguageIcon();
    }


    @When("I choose a necessary language")
    public void i_choose_a_necessary_language() {
        changeLanguagePage.changeLanguage();
    }

    @Then("I got changed language")
    public void i_got_changed_language() {

        changeLanguagePage.isLanguageChange();
    }
}
