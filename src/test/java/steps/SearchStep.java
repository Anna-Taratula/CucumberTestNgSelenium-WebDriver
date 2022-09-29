package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

import static pages.CucumberDriver.getDriver;

public class SearchStep {

    SearchPage searchPage;
    HomePage homePage;
    private static final String inputStr = "smartwatch";

    @Given("I input to the search field")
    public void i_input_to_the_search_field() {
        homePage = new HomePage(getDriver()).goToSite().inputSearch(inputStr);
    }

    @When("I click search")
    public void i_click_search() {
        searchPage = homePage.clickEnterSearch();
    }

    @Then("I got the correct result")
    public void i_got_the_correct_result() {


        searchPage.informationResult();
    }


}
