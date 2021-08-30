package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmedPage extends TestBase {

    //repozytorium elementów
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/div[2]")
    private WebElement infoAboutOrders;

    //konstruktor
    public OrderConfirmedPage(){

        PageFactory.initElements(driver, this);
    }

    //pobranie i zwrócenie komunikatu o liczbie złożonych zamówień
    public String getInfoAboutOrders(){
        wait.until(ExpectedConditions.visibilityOf(infoAboutOrders));
        String message = infoAboutOrders.getText();
        System.out.println("Information about placed orders: " + message);

        return message;
    }
}
