import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LokalizowanieFindElements {

    public static WebDriver driver;

    @Test
    public void weryfikacjaGrafik(){


        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki 'Sklep'
        driver.findElement(By.linkText("SKLEP")).click();

        //utworzenie listy grafik
        List<WebElement> allGraphics = driver.findElements(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));

        //sprawdzenie ilości grafik
        int numberOfGraphics = allGraphics.size();

        System.out.println("Liczba grafik produktowych na stronie = " + numberOfGraphics);

        //weryfikacja prawidłowej ilości grafik
        Assert.assertEquals(numberOfGraphics, 12);

        //wypisanie linków do wszystkich grafik
        for(int i=0; i<numberOfGraphics; i++) {
            System.out.println(allGraphics.get(i).getAttribute("src"));
        }

        driver.close();
        driver.quit();
    }
}
