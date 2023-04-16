package yandex.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
    private WebDriver driver;
    private final By accountHeaderButton = By.xpath(".//p[text()='Личный Кабинет']");
    public By getAccountHeaderButton() {
        return accountHeaderButton;
    }
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    public By getCreateOrderButton() {
        return createOrderButton;
    }
    private final By accountPageButton = By.xpath(".//button[text()='Войти в аккаунт']");
    public By getAccountPageButton() {
        return accountPageButton;
    }
    private final By bunTab = By.xpath(".//div/span[text()='Булки']");
    public By getBunTab() {
        return bunTab;
    }
    private final By sauceTab = By.xpath(".//div/span[text()='Соусы']");
    public By getSauceTab() {
        return sauceTab;
    }
    private final By fillingTab = By.xpath(".//div/span[text()='Начинки']");
    public By getFillingTab() {
        return fillingTab;
    }
    private final By currentTab = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    public By getCurrentTab() {
        return currentTab;
    }
    public HomePage(WebDriver driver){
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
