package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement inputSearch;

    @FindBy(xpath = "//a[@aria-label='Toys & Games']")
    private WebElement chooseToysPage;

    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@id='glow-ingress-block']")
    private WebElement locationIcon;

    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement locationIconText;

    @FindBy(xpath = "//span[@id='GLUXCountryValue']")
    private WebElement countryValue;

    @FindBy(xpath = "//span[@role='radiogroup']")
    private WebElement dropDown;

    @FindBy(xpath = "//div[@class='a-popover-inner a-lgtbox-vertical-scroll']//a[@id='GLUXCountryList_233']")
    private WebElement chooseAnotherCountry;

    @FindBy(xpath = "//button[@name='glowDoneButton']")
    private WebElement doneButton;

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 icp-link-style-2']")
    private WebElement languageIcon;

    String expectedValue;


    public HomePage goToSite() {
        getDriver().get("https://www.amazon.com/");
        getDriver().navigate().refresh();
        return this;
    }

    public LoginPage clickSignInIcon() {
        WebElement chooseLoginIcon = getDriver().findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        chooseLoginIcon.click();

        return new LoginPage(getDriver());
    }

    public RegisterPage clickSignAsNewCustomer() {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//span[normalize-space()='Account & Lists']")))
                .pause(2000).click(getDriver().findElement(By.xpath("//a[@class='nav-a']"))).perform();

        return new RegisterPage(getDriver());
    }

    public HomePage inputSearch(String inputStr) {
        inputSearch.sendKeys(inputStr);

        return this;
    }

    public SearchPage clickEnterSearch() {
        inputSearch.sendKeys(Keys.ENTER);

        return new SearchPage(getDriver());
    }

    public ChooseToysPage chooseToysPage() {
        chooseToysPage.click();
        return new ChooseToysPage(getDriver());
    }

    public CartPage clickCartIcon() {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(cartIcon).pause(2000).click().perform();

        return new CartPage(getDriver());
    }

    public void isHomePageOpen() {

        Assert.assertEquals(HomePage.this.getDriver().getCurrentUrl(), "https://www.amazon.com/ref=nav_logo");
    }

    public CurrencySettingsPage clickCurrencyChange() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-line-2']")))
                .pause(2000).click().perform();

        return new CurrencySettingsPage(getDriver());
    }

    public HomePage clickChooseLocationIcon() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(locationIcon).pause(1000).click().pause(1000).perform();

        return this;
    }

    public HomePage clickDropDown() {
        dropDown.click();
        Actions actions = new Actions(getDriver());
        actions.pause(500).moveToElement(chooseAnotherCountry).click().pause(2000).perform();
        expectedValue = countryValue.getText();
        actions.moveToElement(doneButton).click().pause(1000).perform();

        return this;
    }

    public void isLocationChange() {
        String actualValue = locationIconText.getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public ChangeLanguagePage clickLanguageIcon() {

        WebElement languageIcon = (new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[@class='nav-a nav-a-2 icp-link-style-2']")));
        languageIcon.click();

        return new ChangeLanguagePage(getDriver());
    }

}
