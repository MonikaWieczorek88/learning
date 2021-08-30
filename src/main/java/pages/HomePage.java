package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    //repozytorium elementów
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shopMenu;

    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/moje-konto/']")
    private WebElement myAccountMenu;

    //konstruktor
    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    //przejście na stronę sklepu z produktami
    public ProductListPage goToProductPage(){
        wait.until(ExpectedConditions.visibilityOf(shopMenu));
        shopMenu.click();
        return new ProductListPage();
    }

    //przejście na zakładkę 'Moje Konto' - zakładka z logowaniem
    public LoginPage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(myAccountMenu));
        myAccountMenu.click();
        return new LoginPage();
    }
}
