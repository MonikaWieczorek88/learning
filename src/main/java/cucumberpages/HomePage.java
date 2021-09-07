package cucumberpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy (id = "logout")
    WebElement btn_logout;

    public HomePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void checkIfLogOutIsDisplayed(){

        btn_logout.isDisplayed();
    }
}
