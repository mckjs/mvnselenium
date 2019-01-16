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
    public By linkInputForms = By.linkText("Input Forms");
    public By linkSimpleFormDemo = By.linkText("Simple Form Demo");
    public By sectionLinkDatePickers = By.linkText("Date pickers");
    public By linkDatePickers = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/a");
    public By sectionLinkBootstrapDatePickers = By.linkText("Bootstrap Date Picker");
    public By linkBootstrapDatePickers = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/ul/li[1]/a");
    public By sectionLinkTable = By.linkText("Table");
    public By linkTable = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[3]/a");
    public By linkTableDataSearch = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[3]/ul/li[2]/a");
    public By tableRow = By.tagName("tr");
    public By linkProgressBarsSliders = By.linkText("Progress Bars & Sliders");
    public By linkAlertsModals = By.linkText("Alerts & Modals");
    public By linkListBox = By.linkText("List Box");
    public By linkOthers = By.linkText("Others");

    public By pageName = By.tagName("h3");
    public By pageHeaderName = By.tagName("h1");
    public By titlePageDatePicker = By.xpath("/html/body/div[2]/div/div[2]/h1");
    public By inputYourMessage = By.id("user-message");
    public By btnShowMessage = By.xpath("//*[@id=\"get-input\"]/button");
    public By displayShowMessage = By.id("display");
    public By inputSum1 = By.id("sum1");
    public By inputSum2 = By.id("sum2");
    public By btnCalculate = By.xpath("//*[@id=\"gettotal\"]/button");
    public By displayTotal = By.id("displayvalue");
    public By dateIcon = By.className("input-group-addon");
    public By dateInputGroup = By.className("input-group date");
    public By dateCalendar = By.className("datepicker-switch");
    public By todayDate = By.cssSelector(".today.day");
    public By formControlDate = By.cssSelector(".form-control");
    public By titlePageTable = By.xpath("/html/body/div[2]/div/div[2]/h2");




    /* Other methods */
    public void goToSeleniumEasy(){
        String url = urls.setSeleniumEasy();
        driver.get(url);
    }
}
