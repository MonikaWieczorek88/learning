import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsercjeZadanie {

    public static WebDriver driver;

    @Test
    public void AsercjeTest(){

        String correctMainPageTitle = "Selenium Shop Automatyzacja Testów";

        String correctSubPageMyAccountTitle = "Moje konto - Selenium Shop Automatyzacja Testów";

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //weryfikacja tytułu strony głównej
        Assert.assertEquals(driver.getTitle(), correctMainPageTitle, "The title of main page is incorrect");

        //weryfikacja tytułu podstrony 'Moje konto'
        WebElement subpageMyAccount = driver.findElement(By.linkText("MOJE KONTO"));
        subpageMyAccount.click();

        Assert.assertEquals(driver.getTitle(), correctSubPageMyAccountTitle, "The title of subpage 'My account' is incorrect");

        //sprawdzenie, czy jest wyświetlone pole Login
        WebElement loginInput = driver.findElement(By.id("username"));

        Assert.assertTrue(loginInput.isDisplayed(), "The login field is not displayed on the page");

        //sprawdzenie, czy checkbox nie jest zaznaczony
        WebElement rememberMeCheckbox = driver.findElement(By.id("rememberme"));

        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Checkbox 'remember me' is selected");

        driver.close();
        driver.quit();
    }
}
