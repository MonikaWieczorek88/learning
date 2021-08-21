import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperacjeNaWebElementach {

    public static WebDriver driver;

    @Test
    public void webElementyTest() {

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki "Ankieta"
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //wypełnienie pola 'Imię'
        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        //wypełnienie pola 'Nazwisko'
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        surnameInput.sendKeys("Nowak");

        //zaznaczenie opcji 'Mężczyzna' w polu płeć
        WebElement manButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if (!manButton.isSelected()) {
            manButton.click();
        }

        //zaznaczenie opcji 20-29 w polu 'Wiek'
        WebElement ageRange = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!ageRange.isSelected()){
            ageRange.click();
        }

        //zaznaczenie opcji 'Torba sportowa' w polu produkt
        WebElement wantedProdukt = driver.findElement(By.xpath("//input[@name='Produkt'][@value='Torba sportowa']"));
        if (!wantedProdukt.isSelected()) {
            wantedProdukt.click();
        }

        //wybranie opcji 'Siatkówka' z listy sport
        Select sportLista = new Select(driver.findElement(By.name("Sport")));
        sportLista.selectByVisibleText("Siatkówka");

        //wybranie opcji 'Kappa' z listy marki
        Select brandList = new Select(driver.findElement(By.id("Marki")));
        brandList.selectByVisibleText("Kappa");

        //wysyłanie formularza - kliknięcie przycisku 'Wyśli'
        WebElement sendButton = driver.findElement(By.id("Wyslij"));
        sendButton.click();

        //weryfikacja, czy komunikat 'Wysłane dane" został wyświetlony na stronie
        WebElement sentData = driver.findElement(By.xpath("//*[contains(text(), 'Wysłane dane')]"));
        Assert.assertTrue(sentData.isDisplayed());

        //potwierdzenie wysłania informacji
        WebElement sentInfo = driver.findElement(By.id("info"));
        System.out.println(sentInfo.getText());

        driver.close();
        driver.quit();
    }
}
