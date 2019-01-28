package global.e2e.seleniumEasy;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.base;
import utils.launchingBrowser;
import utils.dateGenerator;


import java.util.Date;

import static java.lang.Thread.*;


public class seleniumEasy extends launchingBrowser {

    @BeforeClass
    public void navigateToSeleniumWebsite() {
        base utils = new base(driver);
        pages pageTest = new pages(driver);
        pageTest.goToSeleniumEasy();

        utils.scrolldown(pageTest.btnStartPractising);
        utils.assertEquals(pageTest.btnStartPractising, "Start Practising");
        utils.click(pageTest.btnStartPractising);

        utils.scrolldown(pageTest.btnProceedNext);
    }

    @Test(description="Verify user is able to make use of the Show Message")
    public void single_input_field() {
        base utils = new base(driver);
        pages pageTest = new pages(driver);


        utils.assertIsDisplayed(pageTest.linkInputForms);
        utils.click(pageTest.linkInputForms);
        utils.assertIsDisplayed(pageTest.linkSimpleFormDemo);
        utils.click(pageTest.linkSimpleFormDemo);
        utils.assertEquals(pageTest.pageName, "This would be your first example to start with Selenium.");

        /*Set input field*/
        utils.assertIsDisplayed(pageTest.inputYourMessage);
        String sentence = "Hi there, this value is entered using automation tool";
        utils.writeText(pageTest.inputYourMessage, sentence);

        utils.scrolldown(pageTest.btnShowMessage);
        utils.click(pageTest.btnShowMessage);
        utils.assertEquals(pageTest.displayShowMessage, sentence);
    }
   @Test(description="Verify user is able to add sum1 and sum2 and get the correct total")
    public void two_input_fields() throws InterruptedException {
        base utils = new base(driver);
        pages pageTest = new pages(driver);

       utils.assertIsDisplayed(pageTest.linkInputForms);
       utils.click(pageTest.linkInputForms);
       utils.assertIsDisplayed(pageTest.linkSimpleFormDemo);
       utils.click(pageTest.linkSimpleFormDemo);
       utils.assertEquals(pageTest.pageName, "This would be your first example to start with Selenium.");

        /*Set input field*/
        utils.assertIsDisplayed(pageTest.inputYourMessage);
        Integer sum1 = 2500;
        Integer sum2 = 500;
        utils.writeInt(pageTest.inputSum1, sum1);
        utils.writeInt(pageTest.inputSum2, sum2);

        Integer total = sum1 + sum2;
        String totalValue = total.toString();

        utils.click(pageTest.btnCalculate);
        utils.assertEquals(pageTest.displayTotal, totalValue);
    }

    @Test(description = "Verify user can select today date")
    public void date_example() throws InterruptedException {
        base utils = new base(driver);
        pages pageTest = new pages(driver);

        utils.assertIsDisplayed(pageTest.linkInputForms);
        utils.assertIsDisplayed(pageTest.linkDatePickers);
        utils.click(pageTest.linkDatePickers);
        utils.assertIsDisplayed(pageTest.linkBootstrapDatePickers);
        utils.click(pageTest.linkBootstrapDatePickers);
        utils.assertEquals(pageTest.titlePageDatePicker, "Bootstrap Date Pickers Example");
        utils.click(pageTest.dateIcon);
        utils.assertIsDisplayed(pageTest.dateCalendar);

        utils.click(pageTest.todayDate);
        Thread.sleep(1000);
       /*
       "Value does not get saved in html css"
            dateGenerator dg = new dateGenerator();
            String todayDate = dg.setTodayDate();
            System.out.print(">>>>>" + utils.readText(pageTest.formControlDate));
            String currentDate = utils.readText(pageTest.formControlDate);
            utils.assertTextValues(currentDate, todayDate);
        */

    }
    @Test(description = "Verify that the jQuery library is in the list")
    public void table_data_search() throws InterruptedException {
        base utils = new base(driver);
        pages pageTest = new pages(driver);
        utils.assertIsDisplayed(pageTest.linkTable);
        utils.click(pageTest.linkTable);
        utils.click(pageTest.linkTableDataSearch);

        utils.assertEquals(pageTest.titlePageTable, "Type in your search to filter data by Tasks / Assignee / Status");

        utils.assertValueInList(pageTest.tableRow, "5 jQuery library Holden Charles deployed");


    }
}
