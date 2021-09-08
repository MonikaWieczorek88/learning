package StepsForHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HooksDemoSteps {

    public static WebDriver driver;

    @Before
    public void browserSetUp(){

        System.out.println("I am inside browserSetUp method");
        System.setProperty("webdriver.chrome.webdriver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){


        System.out.println("I am inside teardown method");
        driver.close();
        driver.quit();
    }

    @BeforeStep
    public void beforeSteps(){

        System.out.println("I am inside beforeSteps method");
    }

    @AfterStep
    public void afterSteps(){

        System.out.println("I am inside afterSteps method");
    }


    @Given("Login is on login page")
    public void login_is_on_login_page() {

    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {

    }
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {

    }
    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {

    }

}
