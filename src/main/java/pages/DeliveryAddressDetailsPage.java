package pages;

import base.TestBase;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DeliveryAddressDetailsPage extends TestBase {

    //repozytorium elementów
    @FindBy(id = "shipping_first_name")
    private WebElement name;

    @FindBy(id = "shipping_last_name")
    private WebElement lastName;

    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    private WebElement arrowInputCountry;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private  WebElement inputCountry;

    @FindBy(id = "shipping_address_1")
    private  WebElement address;

    @FindBy(id = "shipping_postcode")
    private  WebElement postcode;

    @FindBy(id = "shipping_city")
    private  WebElement city;

    @FindBy(name = "save_address")
    private WebElement saveAddressButton;


    //konstruktor
    public DeliveryAddressDetailsPage(){
        PageFactory.initElements(driver, this);
    }

    //wpisanie wartości tekstowej w pole Imię
    public void setName(String nameStr) {
        wait.until(ExpectedConditions.visibilityOf(name));
        name.clear();
        name.sendKeys(nameStr);
    }

    //wpisanie wartości tekstowej w pole Nazwisko
    public void setLastName(String lastNameStr){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.clear();
        lastName.sendKeys(lastNameStr);
    }

    //wpisanie wartości tekstowej w pole Region
    public void setCountry(String country){
        wait.until(ExpectedConditions.visibilityOf(arrowInputCountry));
        arrowInputCountry.click();
        inputCountry.sendKeys(country, Keys.ENTER);
    }

    //wpisanie wartości tekstowej w pole Ulica
    public void setAddress(String addressStr){
        wait.until(visibilityOf(address));
        address.clear();
        address.sendKeys(addressStr);
    }

    // Wpisanie wartości tekstowej w pole Kod Pocztowy
    public void setPostcode(String postcodeStr){
        wait.until(visibilityOf(postcode));
        postcode.clear();
        postcode.sendKeys(postcodeStr);
    }

    // Wpisanie wartości tekstowej w pole Miasto
    public void setCity(String cityStr){
        wait.until(visibilityOf(city));
        city.clear();
        city.sendKeys(cityStr);
    }

    // Kliknięcie przycisku: Zapisz adres
    public void clickSaveAddressButton() {
        wait.until(elementToBeClickable(saveAddressButton));
        saveAddressButton.click();
    }

    //metoda wykonująca pełną akcję uzupełniania formularza adresu dostawy i zwracająca stronę AddressPage
    public AddressPage fillForm(String nameStr, String lastNameStr, String countryString, String addressStr, String postcodeString, String cityStr) {
        setName(nameStr);
        setLastName(lastNameStr);
        setCountry(countryString);
        setAddress(addressStr);
        setPostcode(postcodeString);
        setCity(cityStr);
        clickSaveAddressButton();

        return new AddressPage();

    }


}
