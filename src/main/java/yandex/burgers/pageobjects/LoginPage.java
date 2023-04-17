package yandex.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private final By emailField = By.xpath(".//div/input[@name='name']");
    private final By passwordField = By.xpath(".//div/input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerLink = By.xpath(".//a[@href = '/register']");
    public By getRegisterLink() {
        return registerLink;
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSimpleInputField(By elementLocator, String textValue) {
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(textValue);
    }

    public void clickButton(By elementLocator) { driver.findElement(elementLocator).click();}

    public void fillLoginForm(String email, String password){
        setSimpleInputField(emailField, email);
        setSimpleInputField(passwordField, password);
        clickButton(loginButton);
    }

    public void waitForElementLoading(By elementLocator) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(elementLocator).getText() != null
                && !driver.findElement(elementLocator).getText().isEmpty()
        ));
    }
}
