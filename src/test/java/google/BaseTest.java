package google;

import org.junit.After;

/**
 * @author Vadym Nastoiashchyi
 */

public class BaseTest {

    @After
    public void tearDown() {
        BaseClass.quit();
    }

}
