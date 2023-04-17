package yandex.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private WebDriver driver;

    private final By pageLogo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']/a");
    public By getPageLogo() {
        return pageLogo;
    }
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    public By getLogoutButton() {
        return logoutButton;
    }
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    public By getConstructorButton() {
        return constructorButton;
    }

    private final By profileSection = By.xpath(".//a[@href='/account/profile']");
    public By getProfileSection() {
        return profileSection;
    }

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickButton(By elementLocator) { driver.findElement(elementLocator).click();}

    public String getElementText(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }

    public void waitForElementLoading(By elementLocator) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(elementLocator).getText() != null
                && !driver.findElement(elementLocator).getText().isEmpty()
        ));
    }
}
