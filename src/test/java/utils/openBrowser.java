package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class openBrowser {
    public WebDriver driver;
    private int capabilities;

    @BeforeClass
    public void setup() {
        String browserName = "chrome";
        //Create a Chrome driver. All test classes use this.
        try
        {
            System.out.printf("Opening %s browser.\n", browserName);
            switch (browserName)
            {
                case "firefox":
                {
                    System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome":
                {
                    System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                }
                case "ie":
                {
                    System.setProperty("webdriver.ie.driver","./IEDriverServer.exe");
                    driver = new InternetExplorerDriver(capabilities);
                    break;
                }
                default:
                    break;
            }
            //Maximize Window
            driver.manage().window().maximize();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }

}
