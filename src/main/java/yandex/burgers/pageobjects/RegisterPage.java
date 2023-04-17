package yandex.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;
    private final By nameField = By.xpath(".//label[text() = 'Имя']//following-sibling::input");
    private final By emailField = By.xpath(".//label[text() = 'Email']//following-sibling::input");
    private final By passwordField = By.xpath(".//div/input[@name='Пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginLink = By.className("Auth_link__1fOlj");
    public By getLoginLink() {
        return loginLink;
    }
    private final By incorrectPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public By getIncorrectPasswordError() {
        return incorrectPasswordError;
    }

    public void setSimpleInputField(By elementLocator, String textValue) {
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(textValue);
    }

    public void clickButton(By elementLocator) { driver.findElement(elementLocator).click();}

    public String getElementText(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }

    public void fillRegistrationForm(String name, String email, String password){
        setSimpleInputField(nameField, name);
        setSimpleInputField(emailField, email);
        setSimpleInputField(passwordField, password);
        clickButton(registerButton);
    }

    public void waitForElementLoading(By elementLocator) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(elementLocator).getText() != null
                && !driver.findElement(elementLocator).getText().isEmpty()
        ));
    }
}
