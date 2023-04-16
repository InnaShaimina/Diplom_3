import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import yandex.burgers.pageobjects.AccountPage;
import yandex.burgers.pageobjects.HomePage;
import yandex.burgers.pageobjects.LoginPage;
import yandex.burgers.pageobjects.RegisterPage;

import static org.hamcrest.CoreMatchers.is;

public class LoginTest extends TestBaseChrome{
    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @After
    public void logoutAfterEachTest()
    {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getLogoutButton());
        accountPage.clickButton(accountPage.getLogoutButton());
        loginPage.waitForElementLoading(loginPage.getRegisterLink());
    }

    @Test
    @DisplayName("Проверка успешного входа в аккаунт через кнопку 'Войти в аккаунт' на Главной странице")
    public void loginMainPageViaEnterAccCheck() {
        homePage.clickButton(homePage.getAccountHeaderButton());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCreateOrderButton()), is("Оформить заказ"));
    }

    @Test
    @DisplayName("Проверка успешного входа в аккаунт через кнопку 'Личный кабинет' на Главной странице")
    public void loginMainPageViaPersonalAccountCheck() {
        homePage.clickButton(homePage.getAccountPageButton());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCreateOrderButton()), is("Оформить заказ"));
    }

    @Test
    @DisplayName("Проверка успешного входа через кнопку 'Войти' на форме регистрации")
    public void loginRegistrationFormCheck() {
        homePage.clickButton(homePage.getAccountPageButton());
        loginPage.waitForElementLoading(loginPage.getRegisterLink());
        loginPage.clickButton(loginPage.getRegisterLink());
        registerPage.waitForElementLoading(registerPage.getLoginLink());
        registerPage.clickButton(registerPage.getLoginLink());
        loginPage.waitForElementLoading(loginPage.getRegisterLink());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCreateOrderButton()), is("Оформить заказ"));
    }

    @Test
    @DisplayName("Проверка успешного входа через кнопку 'Войти' на форме восстановления пароля")
    public void loginRestorePasswordFormCheck() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        registerPage.waitForElementLoading(registerPage.getLoginLink());
        registerPage.clickButton(registerPage.getLoginLink());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCreateOrderButton()), is("Оформить заказ"));
    }
}
