import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonExample {

    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testRadioButton() {

        driver.get("https://testautomation.co/webelements/");

        List<WebElement> browserRadios = driver.findElements(By.name("browser"));

        //browserRadios.get(1).click();

        for (WebElement radio : browserRadios) {
            System.out.println(radio.getAttribute("value"));
            if (radio.getAttribute("value").equals("ie")) {
                radio.click();
            }
        }
    }
}
