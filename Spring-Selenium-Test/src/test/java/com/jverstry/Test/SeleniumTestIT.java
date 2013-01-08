
package com.jverstry.Test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SeleniumTestIT extends AbstractTestIT {

    @Test
    public void testWeSeeHelloWorld() {
        drv.get(siteBase.toString());
        assertTrue(drv.getPageSource().contains("Hello World"));
    }

}
