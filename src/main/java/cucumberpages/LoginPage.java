package cucumberpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    @FindBy (id = "name")
    WebElement txt_username;

    @FindBy (id = "password")
    WebElement txt_password;

    @FindBy (id = "login")
    WebElement btn_login;

    @FindBy (id = "logout")
    WebElement btn_logout;


    public LoginPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

    public void enterUsername(String username){

        //driver.findElement(txt_username).sendKeys(username);
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password){

        txt_password.sendKeys(password);
    }

    public void clickLogin(){

        btn_login.click();
    }

    public void checkLogOutIsDisplayes(){

        btn_logout.isDisplayed();
    }

    public void loginValidUser(String username, String password){

        txt_username.sendKeys(username);
        txt_username.sendKeys(password);
        btn_login.click();
    }
}
