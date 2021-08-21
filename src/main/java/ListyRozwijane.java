import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ListyRozwijane {

    public static WebDriver driver;

    @Test
    public void listaRozwijanaSportTest(){

        //konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //przejście do zakładki Ankieta
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //zlokalizowanie listy Sport
        Select sportList = new Select(driver.findElement(By.name("Sport")));

        //weryfikacja, czy lista jest multilistą / listą jednokrotnego wyboru
        if(sportList.isMultiple()) {
            System.out.println("The list is multiple choice");
        }else{
            System.out.println("The list is single choice");
        }

        //liczenie pozycji na liście
        int numberOFItemsOnTheSportList = sportList.getOptions().size();
        System.out.println("The number of items on the sport list: " + numberOFItemsOnTheSportList);

        //wypisanie pierwszej domyślnej pozycji listy
        System.out.println("Default selected item on the list: " + sportList.getFirstSelectedOption().getText());

        //wypisanie wszystkich pozycji z listy
        for (int i = 0; i<numberOFItemsOnTheSportList; i++) {
            System.out.println("Position: " + sportList.getOptions().get(i).getText());
        }

        //wybór pozycji Bieganie
        sportList.selectByValue("bieganie");

        //wypisanie aktualnie zaznaczonej pozycji z listy
        System.out.println("Currently selected item on the list: " + sportList.getFirstSelectedOption().getText());

        driver.close();
        driver.quit();


    }
}
