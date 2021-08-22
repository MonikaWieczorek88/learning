import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitZadanie {

    public static WebDriver driver;

    @Test
    public void mechanizmOczekiwaniaTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //utworzenie obiektu klasy WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //kliknięcie przycisku 'Proces'
        WebElement processButton = driver.findElement(By.id("proces"));
        processButton.click();

        //oczekiwanie na wyświetlenie napisu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Element Proces został wyświetlony')]")));

        //wyświetlenie napisu
        WebElement message = driver.findElement(By.xpath("//span[contains(text(), 'Element Proces został wyświetlony')]"));

        //weryfikacja, czy napis jest wyświetlony
        Assert.assertTrue(message.isDisplayed(), "The message is not visible on the page");

        driver.close();
        driver.quit();

    }
}
