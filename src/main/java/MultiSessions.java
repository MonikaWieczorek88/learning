import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSessions {

    @Test
    public void clickFormMenu_SessionOne(){

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver;

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 1. Thread id: " + id);
        System.out.println("Test 1. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyValueNameInput_SessionTwo(){
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver;

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        Assert.assertEquals(nameInput.getAttribute("value"), "Adam");


        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 2. Thread id: " + id);
        System.out.println("Test 2. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyIsSelectedAgeRange20_29_SessionThree(){
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver;

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();


        WebElement ageRange20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!ageRange20_29.isSelected()) {
            ageRange20_29.click();
        }
        Assert.assertTrue(ageRange20_29.isSelected());


        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 3. Thread id: " + id);
        System.out.println("Test 3. Session id: " + sessionid);
        driver.quit();
    }
}

