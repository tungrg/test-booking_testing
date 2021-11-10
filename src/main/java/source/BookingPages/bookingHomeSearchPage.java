package source.BookingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import source.core.DriverWrapper;


public class bookingHomeSearchPage extends baseBookingPage {

    private By chooseBookingLanguageButtonPath   = By.xpath("//button[@data-modal-id='language-selection']");
    private By bookingLanguageButtonPath = By.xpath("//div[@lang='en-us']");
    private By bookingSearchFieldPath = By.cssSelector("#ss");
    private By bookingMonthButtonPath = By.xpath("//div[@class = 'xp__dates xp__group']");
    private By bookingMonthPath = By.xpath("//div[@class = 'bui-calendar__month']");//list
    private By bookingMonthNextButtonPath = By.xpath("//div[@data-bui-ref= 'calendar-next']");
    private By bookingDatePath = By.xpath("(//div[@class = 'bui-calendar__wrapper']//span[@role='checkbox'])"); //list
    private By bookingSearchButtonPath = By.xpath("//div[@class= 'xp__button']");
    private By bookingGuessButtonPath = By.xpath("//div[@class = 'xp__input-group xp__guests']");
    private By bookingGuessAdultPath = By.xpath("(//span[@class = 'bui-stepper__display'])");
    private By bookingGuessIncreasePath = By.xpath("//button[@data-bui-ref= 'input-stepper-add-button']");
    private By bookingGuessDecreasePath = By.xpath("//button[@data-bui-ref= 'input-stepper-subtract-button']");

    public bookingHomeSearchPage setTextToSearchField(String text){
        DriverWrapper.getDriver().findElement(bookingSearchFieldPath).sendKeys(text);
        try{
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public bookingHomeSearchPage chooseCheckInDay(String month, String inDay, String outDay){
        DriverWrapper.getDriver().findElement(bookingMonthButtonPath).click();

        boolean checkFlag = true;
        while (checkFlag)
        {
            for (WebElement i :DriverWrapper.getDriver().findElements(bookingMonthPath))
            {
                if(i.getText().contains(month))
                {
                    checkFlag = false;
                    break;
                }
            }
            if (checkFlag){
                DriverWrapper.getDriver().findElement(bookingMonthNextButtonPath).click();
            }
        }
        for (WebElement iter : DriverWrapper.getDriver().findElements(bookingDatePath))
        {
            String Date = iter.getAttribute("aria-label");
            String[] parts = Date.split(" ");
            String onlyDate = parts[0];
            String onlyMonth = parts[1];
            if (onlyDate.equals(inDay) && onlyMonth.equals(month) || onlyDate.equals(outDay) && onlyMonth.equals(month))
            {
                iter.click();
            }

        }
        return this;
    }
    public bookingHomeSearchPage chooseAdultGuess(int guess){
        DriverWrapper.getDriver().findElement(bookingGuessButtonPath).click();
        int guessCount = Integer.parseInt(DriverWrapper.getDriver().findElement(bookingGuessAdultPath).getText());
        while (guessCount!= guess && guessCount > 0)
        {
            if (guessCount < guess)
            {
                DriverWrapper.getDriver().findElement(bookingGuessIncreasePath).click();
                guessCount++;
            }
            else if (guessCount > guess)
            {
                DriverWrapper.getDriver().findElement(bookingGuessDecreasePath).click();
                guessCount--;
            }
        }
        return this;
    }
    public bookingHomeSearchPage chooseLanguage(){
        DriverWrapper.getDriver().findElement(chooseBookingLanguageButtonPath).click();
        DriverWrapper.getDriver().findElement(bookingLanguageButtonPath).click();
        return this;
    }
    public bookingSearchResultPage clickBookingSearchButton(){
        DriverWrapper.getDriver().findElement(bookingSearchButtonPath).click();
        return new bookingSearchResultPage();
    }
}
