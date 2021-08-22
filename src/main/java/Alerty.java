import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerty {

    public static WebDriver driver;

    @Test
    public void alertyTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //kliknięcie przycisku 'Alert'
        WebElement alertButton = driver.findElement(By.id("alertPrzycisk"));
        alertButton.click();

        //zaakceptowanie okna Alert
        driver.switchTo().alert().accept();

        //kliknięcie przycisku 'Prompt Alert'
        WebElement promptAlertButton = driver.findElement(By.id("promtAlertPrzycisk"));
        promptAlertButton.click();

        //wprowadzenie wartości 'Warszawa'
        driver.switchTo().alert().sendKeys("Warszawa");

        //zaakceptowanie okna 'Prompt Alert'
        driver.switchTo().alert().accept();

        //kliknięcie przycisku 'Confirm Alert'
        WebElement confirmAlert = driver.findElement(By.id("confimationAlertPrzycisk"));
        confirmAlert.click();

        //pobranie tekstu komunikatu
        System.out.println("The message from the alert window: " + driver.switchTo().alert().getText());

        //odrzucenie okna Confirm Alert
        driver.switchTo().alert().dismiss();

        driver.quit();

    }
}
