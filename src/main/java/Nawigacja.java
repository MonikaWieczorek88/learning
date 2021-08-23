import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Nawigacja {

    public static WebDriver driver;

    @Test
    public void nawigacjaTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //nawigacja do strony głównej
        driver.navigate().to("http://www.selenium-shop.pl/");

        //wypisanie informacji o tytule strony oraz URL
        System.out.println("After method 'to'");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL address: " + driver.getCurrentUrl());

        //przejście do podstrony Moje Konto
        WebElement myAccount = driver.findElement(By.linkText("MOJE KONTO"));
        myAccount.click();

        //wypisanie informacji o tytule strony oraz URL
        System.out.println("After switching to the tab 'My Account'");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL address: " + driver.getCurrentUrl());

        //powrót do poprzedniej strony
        driver.navigate().back();

        //wypisanie informacji o tytule strony oraz URL
        System.out.println("After method 'back'");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL address: " + driver.getCurrentUrl());

        //przejście stronę do przodu - instrukcja forward
        driver.navigate().forward();

        //wypisanie informacji o tytule strony oraz URL
        System.out.println("After method 'forward'");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL address: " + driver.getCurrentUrl());

        //odświeżenie strony (symulacja akcji przycisku F5)
        driver.navigate().refresh();

        //wypisanie infromacji o tytule strony oraz URL
        System.out.println("After method 'refresh'");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL address: " + driver.getCurrentUrl());

        driver.close();
        driver.quit();

    }
}
