package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    public WebDriver driver;

    @Given("Chrome browser is open")
    public void chrome_browser_is_open(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("User is on google search page")
    public void user_is_on_google_search_page() {

        driver.navigate().to("https://www.google.com");

        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

    }
    @When("User enters aa text in search box")
    public void user_enters_aa_text_in_search_box() {

        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
    }
    @And("User hits enter")
    public void user_hits_enter() {

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("User is navigated to search result")
    public void user_is_navigated_to_search_result() {

        driver.getPageSource().contains("Online Courses");

        driver.close();
        driver.quit();
    }

}
