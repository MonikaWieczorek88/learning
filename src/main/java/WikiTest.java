import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTest {

    public static WebDriver driver;

    @Test
    public void wikiTest(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.wikipedia.org");

        WebElement englishLang = driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong"));
        englishLang.click();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchInput.clear();
        searchInput.sendKeys("Warszawa");
        //searchInput.sendKeys(Keys.ENTER); // lista wyników
        searchInput.submit(); // pierwszy wynik z listy

        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Warsaw - Wikipedia");

        driver.quit();


    }
}
