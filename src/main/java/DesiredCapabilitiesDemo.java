import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("ignoreProtectedModeSetting", true);


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("ABCD");
        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        driver.close();
        driver.quit();
    }


}
