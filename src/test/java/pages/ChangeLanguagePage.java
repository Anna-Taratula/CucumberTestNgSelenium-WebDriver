package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;

public class ChangeLanguagePage extends BasePage {
    public ChangeLanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement loginIconText;

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 icp-link-style-2']")
    private WebElement languageIcon;


    String[] arrLanguages = new String[]{"//span[normalize-space()='ES']"
            , "//span[normalize-space()='AR']"
            , "//span[normalize-space()='DE']"
            , "//span[normalize-space()='HE']"
            , "//span[normalize-space()='KO']"
            , "//span[normalize-space()='PT']"
            , "//span[contains(text(),'中文 (简体) -')]//span[@dir='ltr'][normalize-space()='ZH']"
            , "//span[contains(text(),'中文 (繁體) -')]//span[@dir='ltr'][normalize-space()='ZH']"
            , "//span[@dir='ltr']//span[@dir='ltr'][normalize-space()='EN']"};

    String[] arrResChangeLanguage = new String[9];
    String[] arrExpected = new String[]{"Hola, Identifícate"
            , "مرحباً. تسجيل الدخول"
            , "Hallo, anmelden"
            , "שלום, היכנס"
            , "안녕하세요, 로그인"
            , "Olá, faça seu login"
            , "您好, 登录"
            , "您好，登入"
            , "Hello, sign in"};

    public HomePage changeLanguage() {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < arrLanguages.length; i++) {
            actions.moveToElement(getDriver().findElement(By.xpath(arrLanguages[i]))).click().pause(1000).perform();
            actions.moveToElement(saveButton).click().pause(1000).perform();
            arrResChangeLanguage[i] = loginIconText.getText();
            actions.pause(1000).perform();
            clickLanguageIconCLP();
        }

        return new HomePage(getDriver());
    }

    public ChangeLanguagePage clickLanguageIconCLP() {
        languageIcon.click();
        return this;
    }

    public void isLanguageChange() {

        Assert.assertEquals(arrResChangeLanguage, arrExpected);

    }
}
