package utils;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class base {
    public WebDriver driver;
    public WebDriverWait wait;


    //Constructor
    public base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void scrolldown(By elementBy) {
        WebElement element = driver.findElement(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        this.scrolldown(elementBy);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        /*this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));*/

    }

    //Wait Wrapper Method
    public void waitClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Wait Wrapper Method
    public void waitTitleIs(String text) {
        wait.until(ExpectedConditions.titleIs(text));
    }

    //Click Method
    public void click(By elementBy) {
        this.scrolldown(elementBy);
        waitClickable(elementBy);
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText(By elementBy, String text) {
        this.scrolldown(elementBy);
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void writeInt(By elementBy, Integer value) {
        String text = value.toString();
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    /*public void waitTextToBe (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        wait.until(ExpectedConditions.textToBe(elementBy, expectedText));
    }*/

    public String getAttribute(By elementBy, String text) {
        String value = driver.findElement(elementBy).getAttribute(text);
        return value;
    }

    //Assert
    public void assertEquals(By elementBy, String expectedText) {
        this.scrolldown(elementBy);
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    //Assert
    public void assertWebElementEquals(WebElement elementBy, String expectedText) {
        Assert.assertEquals(elementBy.getText(), expectedText);
    }

    //Assert
    public void assertTextValues(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertIsDisplayed(By elementBy) {
        this.scrolldown(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element is not displayed " + elementBy);
    }

    public void assertIsNotDisplayed(By elementBy) {
        Assert.assertFalse(driver.findElement(elementBy).isDisplayed());
    }

    public void assertIsSelected(By elementBy) {
        Assert.assertTrue(driver.findElement(elementBy).isSelected());
    }

    public void assertIsEnabled(By elementBy) {
        Assert.assertTrue(driver.findElement(elementBy).isEnabled());
    }

    public void assertElementLength(By elementBy, Integer length) {
        Assert.assertEquals(driver.findElement(elementBy).getSize(), length);

    }

    public void assertFailTest() {
        Assert.fail("Test did not execute probably");

    }

    public void assertTextContains(String sActual, String sExpectedText) {
        Assert.assertTrue(sActual.contains(sExpectedText));

    }


    /*Other methods*/
    public void findValueClick(By elementBy, String expectedText) {
        List<WebElement> listElements = driver.findElements(elementBy);

        for (int i = 0; i < listElements.size(); i++) {
            WebElement listElement = listElements.get(i);
            String elementValue = listElement.getText();
            if (elementValue.equals(expectedText)) {
                System.out.print(">>>>> : >>>>>" + i);
                listElement.click();

            }
        }

    }


    public void assertValueInList(By elementBy, String expectedText) {
        List<WebElement> listElements = driver.findElements(elementBy);
        List<String> value = new ArrayList<String>();

        for (int i = 0; i < listElements.size(); i++) {
            WebElement listElement = listElements.get(i);
            String elementValue = listElement.getText();
            if (elementValue.equals(expectedText)) {
                /*System.out.print(">>>>>>.. " + expectedText);*/
                value.add(elementValue);
            }
        }

        Integer lengthValue = value.size();
        /*System.out.print(">>>lengthValue>>>.. " + lengthValue);*/
        if (lengthValue <= 0) {
            this.assertFailTest();
        } else if (lengthValue > 1) {
            this.assertFailTest();
        } else {
            assertTextValues(expectedText, value.get(0));
        }

    }


    public void assertCurrentUrlContainsText(String sExpectedText) {
        String sCurrentUrl = driver.getCurrentUrl();
        assertTextContains(sCurrentUrl, sExpectedText);
    }
}