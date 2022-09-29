package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CurrencySettingsPage;
import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class CurrencyChangeStep {

    CurrencySettingsPage currencySettingsPage;

    @Given("I open Currency Settings")
    public void i_open_Currency_Settings() {
        currencySettingsPage = new HomePage(getDriver()).goToSite().clickCurrencyChange();
    }


    @When("I change currency")
    public void i_change_currency() {
        currencySettingsPage.clickCurrencyDropDown()
                .clickAudDollar()
                .clickSaveChangesButton()
                .clickCurrencyChange();
    }

    @Then("Chosen currency is dispeyed")
    public void chosen_currency_is_dispeyed() {
        currencySettingsPage.isChosenCurrencyDispay();
    }
}
