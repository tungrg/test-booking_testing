package testing.Booking;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import source.core.DriverWrapper;
import testing.BaseTest;


public abstract class BookingBaseTest extends BaseTest {
    @BeforeMethod
    public void preCondition(){
        DriverWrapper.getDriver().navigate().to("https://booking.com");
    }
    @AfterMethod
    public void postCondition(){
        DriverWrapper.getDriver().quit();
    }
}
