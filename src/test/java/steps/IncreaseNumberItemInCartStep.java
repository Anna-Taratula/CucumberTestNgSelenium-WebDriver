package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ChosenToyPage;
import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class IncreaseNumberItemInCartStep {

    CartPage cartPage;
    ChosenToyPage chosenToyPage;

    @Given("I choose item and add it to the cart.")
    public void i_choose_item_and_add_it_to_the_cart() {
        chosenToyPage = new HomePage(getDriver()).goToSite().chooseToysPage().chosenToyPage();
        chosenToyPage.seeAllBuyingOptions().addToCart().refreshPage();
        cartPage = chosenToyPage.openCart();
    }


    @When("I add the same item")
    public void i_add_the_same_item() {
        cartPage.clickQtyButton().clickAddItemInQty();
    }

    @Then("The item is added")
    public void the_item_is_deleted() {
        cartPage.isItemAdded();
    }
}
