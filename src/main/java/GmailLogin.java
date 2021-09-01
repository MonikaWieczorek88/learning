import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLogin {

    public static WebDriver driver;

    @Test
    public void gmailLoginTest(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://accounts.google.com");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.clear();
        emailInput.sendKeys("monika.tester.88@gmail.com");

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
        nextButton.click();

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("88888");

        WebElement nextButton2 = driver.findElement(By.xpath("//*[@id='passwordNext']/content/span"));
        nextButton2.click();


    }
}
