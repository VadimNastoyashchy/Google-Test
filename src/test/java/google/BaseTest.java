package google;

import google.driverutil.DriverFactory;
import org.junit.After;

/**
 * @author Vadym Nastoiashchyi
 */

public class BaseTest {

    @After
    public void tearDown() {
        DriverFactory.quit();
    }

}
