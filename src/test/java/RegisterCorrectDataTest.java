import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import yandex.burgers.pageobjects.HomePage;
import yandex.burgers.pageobjects.LoginPage;
import yandex.burgers.pageobjects.RegisterPage;

import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static org.hamcrest.CoreMatchers.*;

public class RegisterCorrectDataTest extends TestBaseChrome{
    RegisterPage registerPage = new RegisterPage(driver);
    UserAPI userAPI = new UserAPI();
    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);
    String accessToken;

    @After
    public void cleanUserAfterTest() {
        userAPI.delete(accessToken)
                .statusCode(HTTP_ACCEPTED);
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registrationAllFieldsFillIsPossibleCheck() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage.waitForElementLoading(registerPage.getLoginLink());
        registerPage.fillRegistrationForm(name, email, password);
        ValidatableResponse response = userAPI.loginUser(email, password);
        accessToken = response.extract().path("accessToken");
        MatcherAssert.assertThat(accessToken, is(notNullValue()));
    }
}
