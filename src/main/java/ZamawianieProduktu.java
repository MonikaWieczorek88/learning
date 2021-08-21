import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZamawianieProduktu {

    public static WebDriver driver;

    @Test
    public void zamawianieProduktuTest() {

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki Sklep
        driver.findElement(By.linkText("SKLEP")).click();

        //przefiltrowanie listy produktów - od najnowszych
        Select productsList = new Select(driver.findElement(By.name("orderby")));
        productsList.selectByVisibleText("Sortuj od najnowszych");

        //wybranie z listy produktu nr 3
        WebElement thirdNewestProduct = driver.findElement(By.xpath("//ul[contains(@class, 'products')]/li[3]"));
        thirdNewestProduct.click();

        //pobranie nazwy produktu
        String nameOfProduct = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

        //pobranie ceny produktu
        String priceOfProduct = driver.findElement(By.xpath("//*[@class='summary entry-summary']/p/span")).getText();

        //wypisanie nazwy i ceny produktu
        System.out.println("Product name on the product detail page: " + nameOfProduct);
        System.out.println("Product price on the product detail page: " + priceOfProduct);

        //podanie ilości 2 - w polu ilość
        WebElement quantityInput = driver.findElement(By.xpath("//input[starts-with(@id, 'quantity')]"));
        quantityInput.clear();
        quantityInput.sendKeys("2");

        //kliknięcie przycisku 'Dodaj do koszyka'
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();

        //kliknięcie opcji 'Zobacz koszyk'
        WebElement viewCart = driver.findElement(By.linkText("Zobacz koszyk"));
        viewCart.click();

        //pobranie nazwy produktu w koszyku
        String nameOfProductInCart = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();

        //pobranie ceny produktu w koszyku
        String priceOfProductInCart = driver.findElement(By.xpath("//td[@class='product-subtotal']/span")).getText();

        //wypisanie nazwy i ceny produktu w koszyku
        System.out.println("Product name in the cart: " + nameOfProductInCart);
        System.out.println("Product price in the cart: " + priceOfProductInCart);

        //weryfikacja nazwy produktu
        Assert.assertEquals(nameOfProduct, nameOfProductInCart);

        //weryfikacja ceny w koszyku (całkowita cena koszyka)
        String correctCartPrice = "240,00 ZŁ";
        Assert.assertEquals(priceOfProductInCart, correctCartPrice);

        driver.close();
        driver.quit();

    }
}
