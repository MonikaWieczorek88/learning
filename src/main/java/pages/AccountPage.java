package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends TestBase {

    //repozytorium elementów
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    private WebElement nameAccountLabel;

    @FindBy(xpath = "//a[contains(text(),'Zamówienia')]")
    private WebElement ordersSideMenu;

    @FindBy(xpath = "//a[contains(text(),'Adresy')]")
    private WebElement addressesSideMenu;

    //konstruktor
    public AccountPage(){

        PageFactory.initElements(driver, this);
    }

    //pobranie i zwrócenie nazwy konta (imię i nazwisko)
    public String getNameAccount(){
        wait.until(ExpectedConditions.visibilityOf(nameAccountLabel));
        String nameAccount = nameAccountLabel.getText();
        System.out.println("You are logged in as: " + nameAccount);
        return nameAccount;
    }

    //przejście na zakładkę Zamówienia (dotyczy zamówień potwierdzonych)
    public OrderConfirmedPage goToOrders(){
        wait.until(ExpectedConditions.visibilityOf(ordersSideMenu));
        ordersSideMenu.click();

        return new OrderConfirmedPage();
    }

    //przejście na zakładkę Adresy
    public AddressPage goToAddresses(){
        wait.until(ExpectedConditions.visibilityOf(addressesSideMenu));
        addressesSideMenu.click();

        return new AddressPage();
    }
}
