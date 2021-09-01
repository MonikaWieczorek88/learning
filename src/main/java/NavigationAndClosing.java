import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationAndClosing {

    public  static WebDriver driver;

    @BeforeMethod
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void getMethod(){
        driver.get("https://www.google.pl");
    }

    @Test
    public void navigateMethod(){
        URL googleURL = null;
        try {
            googleURL = new URL("http://google.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.navigate().to(googleURL);
    }

    @Test
    public void navigationMethods(){
        driver.navigate().to("https://google.pl");
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

}
