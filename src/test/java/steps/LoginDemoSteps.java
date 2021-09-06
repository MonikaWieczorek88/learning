package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps {

    public WebDriver driver;

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

        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @And("user click on login")
    public void user_click_on_login() {

        driver.findElement(By.id("login")).click();
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {


        Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());

        driver.close();
        driver.quit();
    }
}
