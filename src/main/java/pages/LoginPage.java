package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestBase {

    //repozytorium elementów
    @FindBy (id = "username")
    public WebElement loginInput;

    @FindBy (id = "password")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@name='login']")
    private WebElement loginButton;

    //konstruktor
    public LoginPage(){

        PageFactory.initElements(driver, this);
    }

    //pobranie i zwrócenie aktualnego tytułu strony
    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("LoginPage title: " + title);
        return title;
    }

    //wpisanie wartości tekstowej w pole login
    public void setLoginInput(String login){
        wait.until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    //wpisanie wartości tekstowej w pole password
    public void setPasswordInput(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    //kliknięcie przycisku Zaloguj się
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    //metoda wykonująca pełną akcję logowania i zwracająca stronę AccountPage
    public AccountPage login(String login, String password){
        setLoginInput(login);
        setPasswordInput(password);
        clickLoginButton();

        return new AccountPage();
    }
}
