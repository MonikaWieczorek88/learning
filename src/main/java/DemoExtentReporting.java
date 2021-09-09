import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoExtentReporting {

    ExtentReports extent;
    ExtentSparkReporter sparkReporter;

    @BeforeSuite
    public void BeforeSuite(){
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("report.html");
        extent.attachReporter(sparkReporter);
    }


    @AfterSuite
    public void AfterSuite(){
        extent.flush();
    }


    @Test
    public void DemoExtentReports1() {

        ExtentTest test = extent.createTest("TC1_DemoExtentReports1");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        test.log(Status.INFO, "Launching chrome browser");
        WebDriver driver = new ChromeDriver();
        test.info("Opening url on browser: " + "http://stackoverflow.com");
        driver.get("http://stackoverflow.com");
        test.info("Clicking on Login button");
        driver.findElement(By.linkText("Log in")).click();
        test.pass("We have successfully clicked on Login button");
        test.info("CLosing browser");
        driver.close();
        test.info("Disposing selenium sessions");
        driver.quit();

    }

    @Test
    public void DemoExtentReports2() {

        ExtentTest test = extent.createTest("TC2_DemoExtentReports2");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        test.log(Status.INFO, "Launching chrome browser");
        WebDriver driver = new ChromeDriver();
        test.info("Opening url on browser: " + "http://stackoverflow.com");
        driver.get("http://stackoverflow.com");
        test.info("Clicking on Login button");
        try {
            driver.findElement(By.linkText("Log")).click();
        } catch (NoSuchElementException e) {
            test.fail("Unable to find Login button");
        }
        test.pass("We have successfully clicked on Login button");
        test.info("CLosing browser");
        driver.close();
        test.info("Disposing selenium sessions");
        driver.quit();
    }
}
