package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

import pages.ChosenToyPage;
import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class AddItemToCartStep {
    CartPage cartPage;
    ChosenToyPage chosenToyPage;

    @Given("I choose toys")
    public void i_choose_toys() {
        chosenToyPage = new HomePage(getDriver()).goToSite().chooseToysPage().chosenToyPage();
    }

    @When("I click add to cart")
    public void i_click_add_to_cart() {
        chosenToyPage.seeAllBuyingOptions().addToCart().refreshPage();
    }

    @Then("I have an item in the basket")
    public void i_have_an_item_in_the_basket() {
        cartPage = chosenToyPage.openCart();
        cartPage.IsChosenToyPresent();
    }
}
