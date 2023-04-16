import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class TestBaseChrome {
    static WebDriver driver;
    @BeforeClass
    public static void setupApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
    }
    @Before
    public void goToHomePage()
    {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @AfterClass
    public static void closeApplication()
    {
        driver.quit();
    }
}

