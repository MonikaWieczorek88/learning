import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgProgress {

    public static WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        System.out.println("BeforeTest");

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

    }

    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }

    @Test (priority = 1)
    public void formMenu(){
        System.out.println("Test 1");
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();
    }

    @Test (priority = 2)
    public void verifyValueNameInput(){
        System.out.println("Test 2");
        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        Assert.assertEquals(nameInput.getAttribute("value"), "Adam");
    }

    @Test (priority = 3)
    public void verifyValueSurnameInput(){
        System.out.println("test 3");
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        surnameInput.sendKeys("Nowak");

        Assert.assertEquals(surnameInput.getAttribute("value"), "Nowak");
    }

    @Test (priority = 4)
    public void verifyIsSelectedMale(){
        System.out.println("Test 4");
        WebElement maleButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if (!maleButton.isSelected()) {
            maleButton.click();
        }

        Assert.assertTrue(maleButton.isSelected());
    }

    @Test (priority = 5)
    public void verifyIsSelectedAgeRange20_29(){
        System.out.println("Test 5");
        WebElement ageRange20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!ageRange20_29.isSelected()){
            ageRange20_29.click();
        }

        Assert.assertTrue(ageRange20_29.isSelected());
    }

    @Test (priority = 6)
    public void writeConsoleLog() {
        System.out.println("Test 6");
        WebElement sendInfo = driver.findElement(By.id("info"));
        System.out.println(sendInfo.getText());
    }

}
