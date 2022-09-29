package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;


public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement inputRePassword;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;


    public RegisterPage inputName() {

        inputName.sendKeys("Ivan");
        return this;
    }

    public RegisterPage inputEmail(String randomEmail) {

        inputEmail.sendKeys(randomEmail + "@gmail.com");
        return this;
    }

    public RegisterPage inputPassword() {

        inputPassword.sendKeys("123456");
        return this;
    }

    public RegisterPage inputRePassword() {

        inputRePassword.sendKeys("123456");
        return this;
    }

    public void enableContinueButton() {

        Assert.assertTrue(continueButton.isEnabled());
    }


}
