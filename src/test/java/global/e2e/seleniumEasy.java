package global.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.base;
import utils.launchingBrowser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.*;


public class seleniumEasy extends launchingBrowser {

    @Test(description="Single Input Field")
    public void single_input_field() throws InterruptedException {
        base utils = new base(driver);
        pages p = new pages(driver);

        p.goToSeleniumEasy();
        utils.scrolldown(p.btnStartPractising);

        utils.assertEquals(p.btnStartPractising, "Start Practising");

        utils.click(p.btnStartPractising);

        utils.scrolldown(p.btnProceedNext);
        utils.click(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a"));
        utils.click(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a"));
        utils.assertEquals(By.xpath("//*[@id=\"easycont\"]/div/div[2]/h3"), "This would be your first example to start with Selenium.");

        /*Set input field*/
        utils.assertIsDisplayed(By.id("user-message"));
        String sentence = "Hi there, this value is entered using automation tool";
        utils.writeText(By.id("user-message"), sentence);

       utils.click(By.xpath("//*[@id=\"get-input\"]/button"));
       utils.assertEquals(By.id("display"), sentence);
    }
    @Test(description="Two Input Field")
    public void two_input_fields() throws InterruptedException {
        base utils = new base(driver);
        pages p = new pages(driver);

        p.goToSeleniumEasy();
        utils.scrolldown(p.btnStartPractising);

        utils.assertEquals(p.btnStartPractising, "Start Practising");

        utils.click(p.btnStartPractising);

        utils.scrolldown(p.btnProceedNext);
        utils.click(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a"));
        utils.click(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a"));
        utils.assertEquals(By.xpath("//*[@id=\"easycont\"]/div/div[2]/h3"), "This would be your first example to start with Selenium.");

        /*Set input field*/
        utils.assertIsDisplayed(By.id("user-message"));
        Integer sum1 = 2500;
        Integer sum2 = 500;
        utils.writeInt(By.id("sum1"), sum1);
        utils.writeInt(By.id("sum2"), sum2);

        Integer total = sum1 + sum2;
        String totalValue = total.toString();

        utils.click(By.xpath("//*[@id=\"gettotal\"]/button"));
        utils.assertEquals(By.id("displayvalue"), totalValue);
    }

    @Test(description = "Date pickers")
    public void date_example() throws InterruptedException {
        base utils = new base(driver);
        pages p = new pages(driver);

        p.goToSeleniumEasy();
        utils.click(By.xpath(" //*[@id=\"treemenu\"]/li/ul/li[2]/a"));
        utils.click((By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/ul/li[1]/a")));
        utils.assertEquals(By.xpath("/html/body/div[2]/div/div[2]/h1"), "Bootstrap Date Pickers Example");
        utils.click(By.xpath("//*[@id=\"sandbox-container1\"]/div/span/i"));
        /*Select date*/
        utils.click(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th"));
    }

    @Test(description = "Date Range Example")
    public void date_range() throws InterruptedException {
        base utils = new base(driver);
        pages p = new pages(driver);

        p.goToSeleniumEasy();
        utils.click(By.xpath(" //*[@id=\"treemenu\"]/li/ul/li[2]/a"));
        utils.click((By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/ul/li[1]/a")));
        utils.assertEquals(By.xpath("/html/body/div[2]/div/div[2]/h1"), "Bootstrap Date Pickers Example");
        utils.writeText(By.xpath("//*[@id=\"datepicker\"]/input[1]"), "04/02/2019");
        sleep(1000);
        utils.writeText(By.xpath("//*[@id=\"datepicker\"]/input[2]"), "28/02/2019");
        /*https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html*/

    }
    @Test(description = "Tables")
    public void table_data_search() throws InterruptedException {
        base utils = new base(driver);
        pages p = new pages(driver);

        p.goToSeleniumEasy();
        utils.click(By.xpath(" //*[@id=\"treemenu\"]/li/ul/li[2]/a"));
        utils.click((By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/ul/li[1]/a")));
        utils.assertEquals(By.xpath("/html/body/div[2]/div/div[2]/h1"), "Bootstrap Date Pickers Example");
        utils.writeText(By.xpath("//*[@id=\"datepicker\"]/input[1]"), "04/02/2019");
        sleep(1000);
        utils.writeText(By.xpath("//*[@id=\"datepicker\"]/input[2]"), "28/02/2019");
        /*https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html*/

    }
}
