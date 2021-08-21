import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selektory {

    public static WebDriver driver;

    @Test
    public void lokalizowanieElementow() {


        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        //kliknięcie zakładki Sklep
        WebElement shopMenu = driver.findElement(By.linkText("SKLEP"));
        shopMenu.click();

        //kliknięcie produktu "Koszulka Chelsea London"
        WebElement chelseaTshirt = driver.findElement(By.xpath("//h2[contains(text(), 'Chelsea')]"));
        chelseaTshirt.click();

        //wprowadzenie ilości 2
        WebElement quantityField = driver.findElement(By.xpath("//*[starts-with(@id, 'quantity_')]"));
        quantityField.clear();
        quantityField.sendKeys("2");

        //kliknięcie przycisku 'Dodaj do koszyka'
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        addToCartButton.click();

        //kliknięcie linku "Zobacz koszyk"
        WebElement viewCartLink = driver.findElement(By.linkText("Zobacz koszyk"));
        viewCartLink.click();

        //wprowadzenie kodu kuponu "Wiosna2020"
        WebElement couponCodeInput = driver.findElement(By.id("coupon_code"));
        couponCodeInput.clear();
        couponCodeInput.sendKeys("Wiosna2020");

        //kliknięcie przycisku 'Zastosuj kupon'
        WebElement applyCouponButton = driver.findElement(By.name("apply_coupon"));
        applyCouponButton.click();

        driver.close();
        driver.quit();

    }
}
