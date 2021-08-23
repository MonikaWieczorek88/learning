import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KlasaAction {

    public static WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.out.println("Before Test");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");
    }

    @AfterTest
    public void closeBrowser(){

        System.out.println("After Test");

        driver.quit();
    }

    @Test (priority = 1)
    public void verifyMessageAfterDoubleClick(){

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //wykonanie akcji double click na przycisku
        WebElement doubleClickButton = driver.findElement(By.xpath("//*[@value='Dwuklik pokaż komunikat']"));

        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClickButton).perform();

        //Weryfikacja wyświetlonego komunikatu
        String expectedMessage = "Przycisk dwuklik został kliknięty";
        String actualMessage = driver.findElement(By.id("p-doubleClick")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (priority = 2)
    public void verifyMessageAfterRightClick(){

        //przejście do zakładki Ankieta (w przypadku uruchamiania testów oddzielnie)
        //WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        //ankietaMenu.click();

        //wykonanie akcji right click na przycisku
        WebElement rightClickButton = driver.findElement(By.id("rightClick"));

        Actions builder = new Actions(driver);
        builder.contextClick(rightClickButton).perform();

        ////Weryfikacja wyświetlonego komunikatu
        String expectedMessage = "Przycisk RIGHT został kliknięty";
        String actualMessage = driver.findElement(By.id("rightClickInfo")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (priority = 3)
    public void verifyMessageSurnameInput(){

        //przejście do zakładki Ankieta (w przypadku uruchamiania testów oddzielnie)
        //WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        //ankietaMenu.click();

        //wprowadzenie wartości w pole tekstowe 'Nazwisko'
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();

        Actions builder = new Actions(driver);
        org.openqa.selenium.interactions.Action typeInCAPS = builder.keyDown(surnameInput, Keys.SHIFT)
                .sendKeys(surnameInput, "nowak")
                .keyUp(surnameInput, Keys.SHIFT)
                .build();

        typeInCAPS.perform();


        //Weryfikacja wyświetlonego komunikatu
        String expectedMessage = "NOWAK";

        Assert.assertEquals(surnameInput.getAttribute("value"), expectedMessage);

    }
}
