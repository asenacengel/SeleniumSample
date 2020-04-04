package EmreSamples.Common.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface IDriverFactory{

     WebDriver Driver();
     WebDriverWait Wait();
    void CloseDriver();
    void WaitInSeconds(int seconds);
     void WaitForPageLoadForSeconds(long timeOutInSeconds);
}

