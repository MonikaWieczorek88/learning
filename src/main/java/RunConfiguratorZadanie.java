import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunConfiguratorZadanie {

    public static WebDriver driver;

    @Test
    public void weryfikacjaZakladkiSklep(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl");

        driver.findElement(By.linkText("SKLEP")).click();

        String adresUrl = driver.getCurrentUrl();

        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl, "http://www.selenium-shop.pl/sklep/");
    }

    @Test
    public void weryfikacjaZakladkiAnkieta(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl");

        driver.findElement(By.linkText("ANKIETA")).click();

        String adresUrl = driver.getCurrentUrl();

        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl, "http://www.selenium-shop.pl/o-nas/");

    }

    @Test
    public void weryfikacjaZakladkiKoszyk(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl");

        driver.findElement(By.linkText("KOSZYK")).click();

        String adresUrl = driver.getCurrentUrl();

        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl, "http://www.selenium-shop.pl/koszyk/");
    }

}
