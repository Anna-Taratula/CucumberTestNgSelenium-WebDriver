package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CurrencySettingsPage extends BasePage {
    public CurrencySettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement currencyDropDown;

    @FindBy(xpath = "//a[@id='icp-currency-dropdown_16']//span[@dir='ltr'][contains(text(),'-')]")
    private WebElement audDollar;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement actualValueInSelectField;

    String expectedValueInSelectField;


    public CurrencySettingsPage clickCurrencyDropDown() {
        currencyDropDown.click();
        return this;
    }

    public CurrencySettingsPage clickAudDollar() {
        audDollar.click();
        return this;
    }

    public HomePage clickSaveChangesButton() {
        expectedValueInSelectField = actualValueInSelectField.getText();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(saveChangesButton).click().pause(2000).perform();

        return new HomePage(getDriver());
    }


    public void isChosenCurrencyDispay() {

        System.out.println(actualValueInSelectField.getText());
        System.out.println(expectedValueInSelectField);
        Assert.assertEquals(actualValueInSelectField.getText(), expectedValueInSelectField);
    }


}
