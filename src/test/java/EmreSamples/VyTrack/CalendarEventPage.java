package EmreSamples.VyTrack;

import EmreSamples.Common.Drivers.DriverFactory;
import EmreSamples.VyTrack.Common.VyTrackBasePage;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventPage extends VyTrackBasePage {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;
    @FindBy(className = "select2-chosen")
    private WebElement owner;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calender_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    public List<String> getColumnNames(){
        DriverFactory.WaitForPageLoadForSeconds(20);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

    public String getStartTime(){
        DriverFactory.WaitForPageLoadForSeconds(20);
        DriverFactory.Wait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }
    public String getEndTime() {
        DriverFactory.WaitForPageLoadForSeconds(20);
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }




    public String getOwnerName(){
        DriverFactory.WaitForPageLoadForSeconds(20);
        DriverFactory.Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("select2-chosen")));
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalenderEvent(){
        DriverFactory.WaitForPageLoadForSeconds(20);
        DriverFactory.Wait().until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }

    public String getStartDate(){
        DriverFactory.WaitForPageLoadForSeconds(20);
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(startTime));
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

}

