package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ChosenToyPage extends BasePage {
    public ChosenToyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='See All Buying Options']")
    private WebElement seeAllBuyingOptions;

    @FindBy(xpath = "//span[@id='a-autoid-2-offer-2']//input[@name='submit.addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement openCart;

    public ChosenToyPage seeAllBuyingOptions() {
        seeAllBuyingOptions.click();
        return this;
    }

    public ChosenToyPage addToCart() {

        WebElement webElement = (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[@id='a-autoid-2-offer-2']//input[@name='submit.addToCart']")));
        webElement.click();
        Actions actions = new Actions(getDriver());
        actions.pause(100).moveToElement(addToCart).pause(5000).perform();

        return this;
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public CartPage openCart() {
        WebElement webElement = (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[@id='nav-cart']")));
        webElement.click();

        return new CartPage(getDriver());
    }


}
