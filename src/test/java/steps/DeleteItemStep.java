package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ChosenToyPage;
import pages.HomePage;

import static pages.CucumberDriver.getDriver;

public class DeleteItemStep {

    CartPage cartPage;
    ChosenToyPage chosenToyPage;

    @Given("I choose item and add it to the cart")
    public void i_choose_item_and_add_it_to_the_cart() {
        chosenToyPage = new HomePage(getDriver()).goToSite().chooseToysPage().chosenToyPage();
        chosenToyPage.seeAllBuyingOptions().addToCart().refreshPage();
        cartPage = chosenToyPage.openCart();
    }


    @When("I delete item")
    public void i_delete_item() {
        cartPage.clickDeleteButton();
    }

    @Then("The item is deleted")
    public void the_item_is_deleted() {
        cartPage.isItemDelete();
    }
}
