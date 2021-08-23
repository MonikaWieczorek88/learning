import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.out.println("Before Test");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");
    }

    @AfterTest
    public void closeBrowser(){

        System.out.println("After Test");

        driver.quit();
    }

    public void takeScreenShot(int TestNumber){

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + TestNumber + "_screenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test (priority = 1)
    public void verifyValueNameInput(){
        System.out.println("Test 1");

        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        Assert.assertEquals(nameInput.getAttribute("value"), "Adam");

        takeScreenShot(1);
    }

    @Test
    public void verifyValueSurnameInput(){
        System.out.println("Test 2");

        //WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        //formMenu.click();

        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        surnameInput.sendKeys("Nowak");

        Assert.assertEquals(surnameInput.getAttribute("value"), "Nowak");

        takeScreenShot(2);
    }

}
