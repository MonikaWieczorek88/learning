import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {

    public static WebDriver driver;

    @Test
    public void GoogleTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        System.out.println("This is the title of the page: " + driver.getTitle());
        System.out.println("This the URL of the page: " + driver.getCurrentUrl());
        //System.out.println("This is the source of the page: " + driver.getPageSource());

        Thread.sleep(2000);

        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']"));
        agreeButton.click();

        Thread.sleep(2000);

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("TestAutomation.co");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit();

        //driver.quit();
    }
}
