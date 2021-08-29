package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumShopAccount {

    public static WebDriver driver;

    //repozytorium elementów
    @FindBy (xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    WebElement nameAccountLabel;

    //konstruktor
    public SeleniumShopAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //metoda pobierająca nazwę konta
    public String getNameAccount(){
        String nameAccount = nameAccountLabel.getText();
        System.out.println("You are logged in as: " + nameAccount);
        return nameAccount;
    }
}
