package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'Pokemon 3 Booster Packs (30 Cards) – 100% Authenti')]")
    private WebElement isChosenToyPresent;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//img[@alt='Pokemon 3 Booster Packs (30 Cards) – 100% Authentic Sealed Pokemon – 1 in 4 Orders Includes Bonus Celebrations Holofoil Card – Bonus: Pokemon Sticker, Hard Protective Sleeve, Opens in a new tab']")
    private WebElement deleteItem;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement qtyButton;

    @FindBy(xpath = "//a[@id='quantity_2']")
    private WebElement addItemInQty;

    @FindBy(xpath = "//span[text() = '2'][@class='a-dropdown-prompt']")
    private WebElement equalAddItemValue;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement homeLogo;

    public void IsChosenToyPresent() {

        Assert.assertEquals(isChosenToyPresent.getText(), ChooseToysPage.expectedString);
    }

    public CartPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    public void isItemDelete() {
        Assert.assertFalse(deleteItem.isDisplayed());
    }

    public CartPage clickQtyButton() {
        qtyButton.click();
        return this;
    }

    public CartPage clickAddItemInQty() {
        addItemInQty.click();
        return this;
    }

    public void isItemAdded() {
        Assert.assertEquals(equalAddItemValue.getText(), "2");
    }

    public HomePage clickHomeLogo() {
        homeLogo.click();
        return new HomePage(getDriver());
    }


}
