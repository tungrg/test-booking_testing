package source.BookingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import source.core.DriverWrapper;

public class bookingSearchResultPage extends baseBookingPage {
    public String getTitle(){
        return DriverWrapper.getDriver().getTitle();
    }
    public String getUrl(){
        return DriverWrapper.getDriver().getCurrentUrl();
    }
    public String getParisElement (){
        return DriverWrapper.getDriver().findElement(By.cssSelector("#ss")).getAttribute("value");
    }
}
