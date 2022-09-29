package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.CartPage;

import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class HomePageStep {
    CartPage cartPage;

    HomePage homePage;

    @Given("I open Cart page")
    public void i_open_Cart_page() {
        cartPage = new HomePage(getDriver()).goToSite().clickCartIcon();
    }


    @When("I click logo")
    public void i_click_logo() {
        homePage = cartPage.clickHomeLogo();
    }

    @Then("I am at home page")
    public void i_am_at_home_page() {
        homePage.isHomePageOpen();
    }

    HomePage homePage1;


    @Given("I click the location icon")
    public void i_click_the_location_icon() {
        homePage1 = new HomePage(getDriver()).goToSite().clickChooseLocationIcon();
    }


    @When("I choose a necessary country")
    public void i_choose_a_necessary_country() {
        homePage1.clickDropDown();
    }

    @Then("I got changed location")
    public void i_got_changed_location() {
        homePage1.isLocationChange();
    }
}
