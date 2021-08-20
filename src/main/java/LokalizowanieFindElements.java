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
        List<WebElement> wszystkieGrafiki = driver.findElements(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));

        //sprawdzenie ilości grafik
        int liczbaGrafik = wszystkieGrafiki.size();

        System.out.println("Liczba grafik produktowych na stronie = " + liczbaGrafik);

        //weryfikacja prawidłowej ilości grafik
        Assert.assertEquals(liczbaGrafik, 12);

        //wypisanie linków do wszystkich grafik
        for(int i=0; i<liczbaGrafik; i++) {
            System.out.println(wszystkieGrafiki.get(i).getAttribute("src"));
        }

        driver.close();
        driver.quit();
    }
}
