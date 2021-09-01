import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestGoogle {

    @Test
    public void demoTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));

        driver.navigate().to("https://google.pl");

        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']"));
        agreeButton.click();

        WebElement searchField = driver.findElement(By.name("q"));

        String searchEntry = "wszechświaty równoległe";
        String title = "Wieloświat – Wikipedia, wolna encyklopedia";

        searchField.sendKeys(searchEntry);
        searchField.submit();

        driver.findElement(By.xpath(".//*[text()='" + title + "']")).click();


        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(title));

        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";

        Assert.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");

        driver.quit();
    }
}
