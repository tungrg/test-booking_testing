package testing.Booking;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.annotations.Test;

import source.BookingPages.bookingHomeSearchPage;

public class Booking4Test extends BookingBaseTest {

    @Test
    public void testBooking() throws InterruptedException {
        Assert.assertEquals(new bookingHomeSearchPage()
                .chooseLanguage()
                .setTextToSearchField("Paris")
                .chooseCheckInDay("February","13","15")
                .chooseAdultGuess(3)
                .clickBookingSearchButton()
                .getParisElement(), "Paris");
    }

}
