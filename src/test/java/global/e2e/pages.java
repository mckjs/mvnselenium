package global.e2e;

import config.pageurl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.base;

public class pages extends base {
    public pages(WebDriver driver) {
        super(driver);
    }

    /* Initialize pages */
    pageurl urls = new pageurl();

    /* Declaring elements */
    public By headerText = By.className("head text-center");
    public By btnStartPractising = By.id("btn_basic_example");
    public By btnProceedNext = By.id("btn_inter_example");

    /* Other methods */
    public void goToSeleniumEasy(){
        String url = urls.setSeleniumEasy();
        driver.get(url);
    }
}
