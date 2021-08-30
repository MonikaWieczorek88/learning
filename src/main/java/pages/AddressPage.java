package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressPage extends TestBase {

    //repozytorium elementów
    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*//parent::*/address")
    private WebElement infoDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/a")
    private WebElement addDeliveryAddress;

    //konstruktor
    public AddressPage(){

        PageFactory.initElements(driver, this);
    }

    //przejście do strony z dodaniem / edytowaniem adresu dostawy
    public DeliveryAddressDetailsPage goToAddDeliveryAddress(){
        wait.until(ExpectedConditions.visibilityOf(addDeliveryAddress));
        addDeliveryAddress.click();
        return new DeliveryAddressDetailsPage();
    }

    //pobranie i zwrócenie komunikatu dotycząego istniejcego adresu dostawy
    public String getInfoDeliveryAddress(){
        wait.until(ExpectedConditions.visibilityOf(infoDeliveryAddress));
        String message = infoDeliveryAddress.getText();
        System.out.println("Delivery address message: " + message);
        return message;
    }
}
