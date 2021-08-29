import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WieleOkien {

    public static WebDriver driver;

    @Test
    public void obslugaWieluOkien(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/o-nas/");

        //wypisanie tytułu strony
        System.out.println("Title of the page: " + driver.getTitle());

        //wypisanie ID okna, w którym się aktualnie znajdujemy
        System.out.println("Window ID: " + driver.getWindowHandle());

        //kliknięcie przycisku 'Otwórz nowe okno'
        driver.findElement(By.xpath("//*[@value='Otwórz nowe okno']")).click();

        //tablica kluczy - kolekcja (unikalne wartości) - lokalizacja ID dwóch okien
        Set<String> browserWindows = driver.getWindowHandles();

        //wypisanie liczby okien
        System.out.println("Number of all open windows: " + browserWindows.size());

        //wypisanie pozycji z kolekcji
        for (String window: browserWindows){
            System.out.println("Browser window: " + window);
        }

        //przeglądanie kolekcji i identyfikacja składowych
        Iterator<String> iterator = browserWindows.iterator();

        String parent = iterator.next(); //okno główne
        String child = iterator.next(); //okno drugie

        //przełączenie do nowego okna
        driver.switchTo().window(child);

        //wpisanie wartości w nowym oknie
        WebElement nameInput = driver.findElement(By.id("imie_nazwisko"));
        nameInput.sendKeys("Monika");

        //wypisanie tytułu strony
        System.out.println("Title of the page (child window): " + driver.getTitle());

        //wypisanie ID okna
        System.out.println("Window ID (child window: " + driver.getWindowHandle());

        driver.quit();
    }
}