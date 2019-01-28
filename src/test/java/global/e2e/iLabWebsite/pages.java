package global.e2e.iLabWebsite;

import config.pageurl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.base;

import java.util.Random;

import static org.openqa.selenium.By.*;

public class pages extends base {



    public pages(WebDriver driver) {
        super(driver);
    }

    /* Initialize pages */
    pageurl urls = new pageurl();

    /* Declaring elements */
    public By eCareers = linkText("CAREERS");
    public By eWorkWith = className("text-left");
    public By eCoutrySouthAfrica = linkText("South Africa");
    public By eHeader3 = tagName("h3");
    public By ePageSections = className("vc_custom_heading");
    public By eBtnApplyOnline = cssSelector("a[href*='https://www.ilabquality.com/job/'");
    public By eJobLink = cssSelector("a[href*='https://www.ilabquality.com/job/'");
    public By eApplicationForm = id("protection");
    public By eApplicationName = id("applicant_name");
    public By eApplicationEmail = id("email");
    public By eApplicationPhone = id("phone");
    public By eApplicationMessage = id("message");
    public By eSendApplication = id("wpjb_submit");
    public By eErrorMessage = className("wpjb-errors");


    /* Other methods */
    public void goToIlab(){
        String url = urls.setIlab();
        driver.get(url);
    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(9999999);

        // this will convert any number sequence into 6 character.
        return String.format("%07d", number);
    }
}
