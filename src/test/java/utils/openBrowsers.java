package utils;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class openBrowsers {

    Driver driver;

    @Before
    public void setUp() {
        String browserName = getParameter("browser");
        driver = new Driver(browserName);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            /*throw new RuntimeException(name + " is not a parameter!");*/
            /*value = "chrome";*/
            value = "ie";

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    @Test
    public void test1() {
        driver.get("http://www.vpl.ca");
    }

}
