import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import yandex.burgers.pageobjects.LoginPage;
import yandex.burgers.pageobjects.RegisterPage;

import static org.hamcrest.CoreMatchers.is;

public class RegisterIncorrectPasswordTest extends TestBaseChrome{
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    @DisplayName("Минимальная длина пароля должна быть 6 символов")
    public void registerWithIncorrectPasswordIsImpossibleCheck() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5);
        registerPage.waitForElementLoading(registerPage.getLoginLink());
        registerPage.fillRegistrationForm(name, email, password);
        registerPage.waitForElementLoading(registerPage.getIncorrectPasswordError());
        MatcherAssert.assertThat(registerPage.getElementText(registerPage.getIncorrectPasswordError()), is ("Некорректный пароль"));
    }

}
