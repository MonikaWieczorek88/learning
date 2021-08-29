package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SeleniumShopAccount;
import pages.SeleniumShopLogin;

import java.util.concurrent.TimeUnit;

public class SeleniumShopLoginTest {

    public static WebDriver driver;

    WebDriverWait wait;

    SeleniumShopLogin seleniumShopLogin;
    SeleniumShopAccount seleniumShopAccount;

    //konfiguracja początkowa
    @BeforeTest
    public void serUp() {
        System.out.println("Before Test");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        driver.get("http://www.selenium-shop.pl/moje-konto/");

        seleniumShopLogin = new SeleniumShopLogin(driver);
        seleniumShopAccount = new SeleniumShopAccount(driver);
    }

    //czynności zamykające testy
    @AfterTest
    public void closeBrowser(){
        System.out.println("After Test");
        driver.quit();
    }

    @Test
    public void verifyNameAccountAfterLogin(){

        String correctLogin = "UserTest1";
        String correctPassword = "HasloTestowe1";

        seleniumShopLogin.setLoginInput(correctLogin);
        seleniumShopLogin.setPasswordInput(correctPassword);
        seleniumShopLogin.clckLoginButton();

        Assert.assertEquals(seleniumShopAccount.getNameAccount(), "Jan Testowy1");
    }
}



