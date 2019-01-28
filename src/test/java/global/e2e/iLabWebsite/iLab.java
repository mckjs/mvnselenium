package global.e2e.iLabWebsite;

import org.junit.Test;
import utils.Driver;
import utils.openBrowsers;

public class iLab extends openBrowsers {
    Driver driver;

    @Test
    public void test1() {
        driver.get("https://www.ilabquality.com/");
    }
}
