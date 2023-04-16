import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.*;
import yandex.burgers.pageobjects.AccountPage;
import yandex.burgers.pageobjects.HomePage;
import yandex.burgers.pageobjects.LoginPage;

import static org.hamcrest.CoreMatchers.is;

public class AccountTest extends TestBaseChrome{
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Before
    public void loginBeforeTests()
    {
        homePage.waitForElementLoading(homePage.getAccountHeaderButton());
        homePage.clickButton(homePage.getAccountHeaderButton());
        loginPage.fillLoginForm("inn-shaimin@yandex.ru", "Qwerty123");
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
    }

    @After
    public void logoutAfterTests() {
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getLogoutButton());
        accountPage.clickButton(accountPage.getLogoutButton());
        loginPage.waitForElementLoading(loginPage.getRegisterLink());
    }

    @Test
    @DisplayName("Проверка успешного перехода в Личный кабинет через кнопку 'Личный кабинет' на Главной странице")
    public void enterAccountViaLinkOnHomePageCheck() {
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getProfileSection());
        MatcherAssert.assertThat(accountPage.getElementText(accountPage.getProfileSection()), is("Профиль"));
    }

    @Test
    @DisplayName("Проверка успешного перехода из Личного кабинета в Конструктор по кнопке в хедере")
    public void fromAccountToConstructorViaLinkCheck() {
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getProfileSection());
        accountPage.clickButton(accountPage.getConstructorButton());
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(driver.getCurrentUrl(), is("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    @DisplayName("Проверка успешного перехода из Личного кабинета в Конструктор по клику на лого в хедере")
    public void fromAccountToConstructorViaLogoCheck() {
        homePage.clickButton(homePage.getAccountHeaderButton());
        accountPage.waitForElementLoading(accountPage.getProfileSection());
        accountPage.clickButton(accountPage.getPageLogo());
        homePage.waitForElementLoading(homePage.getCreateOrderButton());
        MatcherAssert.assertThat(driver.getCurrentUrl(), is("https://stellarburgers.nomoreparties.site/"));
    }
}
