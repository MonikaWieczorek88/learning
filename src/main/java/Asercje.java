import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asercje {

    public static WebDriver driver;

    @Test
    public void AsercjeTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //wprowadzenie wartości w polu Imię
        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        //wprowadzenie wartości w polu Nazwisko
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        surnameInput.sendKeys("Nowak");

        //zaznaczenie opcji Mężczyzna - w polu płeć
        WebElement manButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if(!manButton.isSelected()) {
            manButton.click();
        }

        //zaznaczenie przedziału wieku 20-29 - w polu wiek
        WebElement ageRange = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if(!ageRange.isSelected()){
            ageRange.click();
        }
        WebElement ageRange2 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='15-19']"));

        //wybranie produktu - w polu produkty
        WebElement wantedProduct = driver.findElement(By.xpath("//input[@name='Produkt'][@value='Torba sportowa']"));
        if(!wantedProduct.isSelected()){
            wantedProduct.click();
        }

        //Weryfikacja wcześniej wprowadzonych danych

        //weryfikacja pola imię (czy wartość jest równa)
        Assert.assertEquals(nameInput.getAttribute("value"), "Adam");

        //weryfikacja pola nazwisko (czy wartość nie jest równa)
        Assert.assertNotEquals(surnameInput.getAttribute("value"), "Kowalski");

        //sprawdzenie, czy opcja jest aktualnie zaznaczona
        Assert.assertTrue(manButton.isSelected());

        //sprawdzenie, czy opcja jest odznaczona
        Assert.assertFalse(ageRange2.isSelected());

        //sprawdzenie, czy checkbox jest dostępny na stronie (nie powinien zawierać atrybutu 'disabled'
        Assert.assertNull(wantedProduct.getAttribute("disabled"));

        //wysłanie ankiety
        WebElement sendButton = driver.findElement(By.id("Wyslij"));
        sendButton.click();

        //wypisanie komunikatu
        WebElement sentInfo = driver.findElement(By.id("info"));
        System.out.println(sentInfo.getText());

        driver.close();
        driver.quit();

    }
}
