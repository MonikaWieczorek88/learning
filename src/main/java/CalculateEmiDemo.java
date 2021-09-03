import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateEmiDemo {

    WebDriver driver;

    @Test
    public void calculationTest() throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://emicalculator.net/");

        Actions actions = new Actions(driver);

        WebElement loanSliderCircle = driver.findElement(By.cssSelector("#loanamountslider > span"));
        WebElement interestSliderCircle = driver.findElement(By.cssSelector("#loaninterestslider > span"));
        WebElement tenureSliderCircle = driver.findElement(By.cssSelector("#loantermslider > span"));

        actions.dragAndDropBy(loanSliderCircle, 83, 0).build().perform();
        Thread.sleep(2000);

        actions.dragAndDropBy(interestSliderCircle, 88, 0).build().perform();
        Thread.sleep(2000);

        actions.dragAndDropBy(tenureSliderCircle, -111, 0 ).build().perform();
        Thread.sleep(2000);

        WebElement loanEmiElement = driver.findElement(By.cssSelector("#emiamount > p > span"));
        String loanEmiText = loanEmiElement.getText();

        Assert.assertEquals(loanEmiText, "93,672");

        driver.quit();

    }
}
