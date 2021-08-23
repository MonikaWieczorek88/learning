import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exceptions {

    public static WebDriver driver;

    @Test
    public void wyjatkiTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/moje-konto/");

        Actions builder = new Actions(driver);

        //zlokalizowanie przycisku 'Zarejestruj się'
        WebElement registerButton = driver.findElement(By.name("register"));

        //instrukcja try-catch
        try {
            driver.findElement(By.name("register"));
        } catch (NoSuchElementException e1) {
            System.out.println("The button is not displayed on the page");
            driver.navigate().refresh();
        } catch (ElementNotVisibleException e2) {
            System.out.println("The button is not visible on the page");
            driver.navigate().refresh();
        } catch (ElementNotInteractableException e3) {
            System.out.println("The button cannot be clicked");
            driver.navigate().refresh();
        }

        driver.quit();
    }
}
