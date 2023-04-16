import org.hamcrest.MatcherAssert;
import org.junit.Test;
import yandex.burgers.pageobjects.HomePage;
import io.qameta.allure.junit4.DisplayName;

import static org.hamcrest.CoreMatchers.is;

public class ConstructorTest extends TestBaseChrome{
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Проверка возможности переключения на вкладку 'Булки' ")
    public void switchToBunTabIsPossible(){
        homePage.clickButton(homePage.getSauceTab()); // переходим на другую вкладку, так как "Булки" открыты по дефолту
        homePage.clickButton(homePage.getBunTab());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCurrentTab()), is (homePage.getElementText(homePage.getBunTab())));
    }

    @Test
    @DisplayName("Проверка возможности переключения на вкладку 'Соусы' ")
    public void switchToSauceTabIsPossible(){
        homePage.clickButton(homePage.getSauceTab());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCurrentTab()), is (homePage.getElementText(homePage.getSauceTab())));
    }

    @Test
    @DisplayName("Проверка возможности переключения на вкладку 'Начинки' ")
    public void switchToFillingTabIsPossible(){
        homePage.clickButton(homePage.getFillingTab());
        MatcherAssert.assertThat(homePage.getElementText(homePage.getCurrentTab()), is (homePage.getElementText(homePage.getFillingTab())));
    }
}
