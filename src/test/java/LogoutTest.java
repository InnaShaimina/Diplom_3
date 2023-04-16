import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import yandex.burgers.pageobjects.AccountPage;
import yandex.burgers.pageobjects.HomePage;
import yandex.burgers.pageobjects.LoginPage;

import static org.hamcrest.CoreMatchers.is;

public class LogoutTest extends TestBaseChrome{
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Test
    @DisplayName("Проверка выхода из аккаунта после нажатия на кнопку 'Выход' в Личном кабинете")
    public void logoutFromAccountCheck() {
        homePage.waitForElementLoading(homePage.getAccountHeaderButton());
        homePage.clickButton(homePage.getAccountHeaderButton());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getLogoutButton());
        accountPage.clickButton(accountPage.getLogoutButton());
        loginPage.waitForElementLoading(loginPage.getRegisterLink());
        MatcherAssert.assertThat(driver.getCurrentUrl(), is("https://stellarburgers.nomoreparties.site/login"));
    }
}
