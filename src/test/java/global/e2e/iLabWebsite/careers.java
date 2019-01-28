package global.e2e.iLabWebsite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.base;
import utils.launchingBrowser;

public class careers extends launchingBrowser {

    @BeforeClass
    public void navigateToIlabWebsite() {
        pages pageTest = new pages(driver);
        pageTest.goToIlab();
    }

    @Test(description="Verify user is not able to apply online without uploading a file")
    public void apply_online_without_upload_file() {
        base utils = new base(driver);
        pages pageTest = new pages(driver);

        utils.waitTitleIs("Home Page - iLAB");
        /* click careers*/
        utils.click(pageTest.eCareers);
        utils.waitTitleIs("CAREERS - iLAB");
        utils.assertIsDisplayed(pageTest.eWorkWith);
        utils.assertEquals(pageTest.eWorkWith, "WORK WITH iLAB");
        /* select south africa*/
        utils.click(pageTest.eCoutrySouthAfrica);
        utils.waitTitleIs("SOUTH AFRICA - iLAB");
        /* click on the first available job hyperlink*/
        utils.click(pageTest.eJobLink);
        /*Verify url contains text /job*/
        utils.assertCurrentUrlContainsText("/job");
        /* select apply online*/
        utils.scrolldown(pageTest.eBtnApplyOnline);
        utils.click(pageTest.eBtnApplyOnline);

        utils.writeText(pageTest.eApplicationName, "Input a first name");

        /* populate the form once displayed*/
        /* Enter name: Input a first name*/
        utils.writeText(pageTest.eApplicationName, "Input a first name");
        /* Enter email: automationAssessment@iLABQuality.com*/
        utils.writeText(pageTest.eApplicationEmail, "automationAssessment@iLABQuality.com");
        /* Enter phone: format 0835687859*/
        String sSetPhone = pageTest.getRandomNumberString();
        String sNewPhone = "083"+ sSetPhone;
        utils.writeText(pageTest.eApplicationPhone, sNewPhone);

        /* Do not upload a file*/
        /* Validate that the following text is displayed: You need to upload at least one file */
        utils.scrolldown(pageTest.eSendApplication);
        utils.click(pageTest.eSendApplication);
        utils.assertCurrentUrlContainsText("form=apply");
        utils.assertIsDisplayed(pageTest.eErrorMessage);
        utils.assertEquals(pageTest.eErrorMessage, "You need to upload at least one file.");

    }
}
