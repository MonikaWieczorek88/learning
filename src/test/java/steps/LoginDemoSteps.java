package steps;


import cucumberpages.HomePage;
import cucumberpages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginDemoSteps {

    public WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;

    @Given("Browser is open")
    public void browser_is_open() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }
    @And("User is on login page")
    public void user_is_on_login_page() {

        driver.navigate().to("https://example.testproject.io/web/");


    }
    @When("^User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);


    }

    @And("user click on login")
    public void user_click_on_login() {

        loginPage.clickLogin();

        //driver.findElement(By.id("login")).click();
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {

        homePage = new HomePage(driver);
        homePage.checkIfLogOutIsDisplayed();

        //Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());

        driver.close();
        driver.quit();
    }
}
