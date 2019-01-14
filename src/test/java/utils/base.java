package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class base {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public base (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
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
    public void click (By elementBy) {
        scrolldown(elementBy);
        waitClickable(elementBy);
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void writeInt(By elementBy, Integer value) {
       String text = value.toString();
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void waitTextToBe (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        wait.until(ExpectedConditions.textToBe(elementBy, expectedText));
    }

    public String getAttribute(By elementBy, String text){
        String value = driver.findElement(elementBy).getAttribute(text);
        return value;
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }
    //Assert
    public void assertWebElementEquals (WebElement elementBy, String expectedText) {
        Assert.assertEquals(elementBy.getText(), expectedText);
    }

    //Assert
    public void assertTextValues (String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertIsDisplayed(By elementBy) {
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element is not displayed " + elementBy);
    }
    public void assertIsNotDisplayed(By elementBy){
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
    public void scrolldown(By elementBy){
    WebElement element = driver.findElement(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }


}