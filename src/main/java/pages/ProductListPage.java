package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductListPage extends TestBase {

    //repozytorium elementów
    @FindBy(xpath = "//ul[contains(@class,'products')]/li")
    List<WebElement> productsItems;

    @FindBy(xpath = "//ul[contains(@class,'products')]/li/a/h2")
    List<WebElement> productsName;

    @FindBy(name = "orderby")
    WebElement orderbyList;

    //konstruktor
    public ProductListPage(){

        PageFactory.initElements(driver, this);
    }

    //pobranie i zwrócenie ilości produktów
    public int getProductsNumber(){
        wait.until(ExpectedConditions.visibilityOfAllElements(productsItems));
        int allProdutsNumber = productsItems.size();
        return allProdutsNumber;
    }

    //wybranie, z listy sortującej, pozycji: Sortuj wg ceny: od najniższej
    public void sortProductByPrice(){
        Select orderByList = new Select(orderbyList);
        orderByList.selectByValue("price");
    }

    //sortowanie listy - po cenie - od najniższej
    //pobieranie przesortowanej listy produktów
    //wypisanie produktów do konsoli
    public ArrayList getProductsNameAfterOrderByPrice(){
        sortProductByPrice();
        ArrayList productsNameList = new ArrayList();
        for (int i = 0; i <productsItems.size(); i++) {
            productsNameList.add(productsName.get(i).getText());
            System.out.println(productsNameList.get(i));
        }
        return productsNameList;
    }
}
