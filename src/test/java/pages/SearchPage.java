package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends BasePage {
    private static final String inputStr = "smartwatch";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='1-16 of over 8,000 results for']")
    private WebElement informationResult;

    @FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span[1]")
    private WebElement searchProduct;

    public void informationResult() {
        String res = searchProduct.getText();
        Assert.assertTrue(searchProduct.getText().toLowerCase().contains(inputStr));
        System.out.println(res);
    }
}
