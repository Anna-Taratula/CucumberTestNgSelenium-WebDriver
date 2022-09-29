package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "ap_email")
    private WebElement inputEmail;

    @FindBy(id = "continue")
    private WebElement clickContinue;

    @FindBy(id = "ap_password")
    private WebElement inputPassword;

    @FindBy(id = "signInSubmit")
    private WebElement clickSignIn;

    @FindBy(xpath = "//div[@class='a-box-inner a-alert-container']")
    private WebElement errorMessage;

    public LoginPage inputEmail() {
        WebElement webElement = (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.id("ap_email")));
        inputEmail.sendKeys("testSignIn@gmail.com");

        return this;
    }


    public LoginPage clickContinue() {
        clickContinue.click();

        return this;
    }

    public LoginPage inputPassword() {
        inputPassword.sendKeys("12345678");
        return this;
    }

    public LoginPage clickSignIn() {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(clickSignIn).pause(2000).click().pause(2000).perform();

        return this;
    }

    public void errorMessage() {

        Assert.assertTrue(errorMessage.isDisplayed());
    }


}
