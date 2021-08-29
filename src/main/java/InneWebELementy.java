import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InneWebELementy {

    public static WebDriver driver;

    @Test
    public void inneWebElementyTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //wpisanie daty w kalendarzu
        WebElement calendarInput = driver.findElement(By.xpath("//*[@id='datepicker']/input"));
        calendarInput.clear();
        calendarInput.sendKeys("25-08-2021");

        //weryfikacja wartości tekstowej, która jest obecna w polu kalendarz
        Assert.assertEquals(calendarInput.getAttribute("value"), "25-08-2021");

        //dodanie pliku
        WebElement infoMessage = driver.findElement(By.id("fileInfo"));

        WebElement addFile = driver.findElement(By.id("file"));
        addFile.sendKeys("C:\\Users\\monik\\Desktop\\Od Laika Do Automatyka\\informacje.txt");

        //weryfikacja komunikatu potwierdzającego załączenie / załadowanie pliku
        Assert.assertEquals(infoMessage.getText(), "Plik informacje.txt został załadowany");

        driver.quit();


    }
}
