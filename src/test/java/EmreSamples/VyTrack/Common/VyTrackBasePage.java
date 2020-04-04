package EmreSamples.VyTrack.Common;

import EmreSamples.Common.BasePage;
import EmreSamples.Common.Drivers.IDriverFactory;
import EmreSamples.VyTrack.States;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class VyTrackBasePage extends BasePage  {

    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;


    public String CurrentUserName(){

        DriverFactory.WaitForPageLoadForSeconds(10);
        DriverFactory.Wait().until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }


    public void NavigateTo(String tabName,String moduleName){

        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = DriverFactory.Driver().findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = DriverFactory.Driver().findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(DriverFactory.Driver());
        BrowserUtils.wait(3);

        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();

        BrowserUtils.wait(5);

    }
}
