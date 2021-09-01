import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZadankoWikiNavi {

    WebDriver driver;

    @BeforeMethod
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @AfterMethod
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void navigationTest(){

        driver.get("https://wikipedia.pl");
        driver.navigate().to("https://nasa.gov");

        driver.navigate().back();
        String wikiTitle = "Wikipedia, wolna encyklopedia";
        Assert.assertEquals(wikiTitle, driver.getTitle(), "The title of the page is not: " + wikiTitle);

        driver.navigate().forward();
        String nasaTitle = "NASA";
        Assert.assertEquals(nasaTitle, driver.getTitle(), "The title of the page is not: " + nasaTitle);
    }
}
