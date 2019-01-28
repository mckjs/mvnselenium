package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class launchingBrowser {
    public WebDriver driver;

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
       /* driver = new FirefoxDriver();*/

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}