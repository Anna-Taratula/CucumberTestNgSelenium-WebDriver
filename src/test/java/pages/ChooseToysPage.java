package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ChooseToysPage extends BasePage {
    public ChooseToysPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Pokemon 3 Booster Packs (30 Cards) – 100% Authentic Sealed Pokemon – 1 in 4 Orders Includes Bonus Celebrations Holofoil Ca...']")
    private WebElement chosenToy;

    @FindBy(xpath = "//div[3]//div[1]//div[1]//div[3]//div[1]//h2[1]")
    private static WebElement chosenToyStr;


    public static String expectedString;

    public ChosenToyPage chosenToyPage() {
        WebElement webElement = (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Pokemon 3 Booster Packs (30 Cards) – 100% Authenti')]")));
        expectedString = webElement.getText();

        webElement.click();

        return new ChosenToyPage(getDriver());
    }

}
