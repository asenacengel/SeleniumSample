package EmreSamples.Common.Drivers;

import EmreSamples.Configurations.Configuration;
import com.automation.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private Configuration _configuration;
    public DriverFactory(){
        _configuration = new Configuration();

    }
    public IDriverFactory DriverByConfiguration(){
        String browser = _configuration.DefaultBrowserName().toLowerCase();
        return new BaseDriver(browser);
    }

    public IDriverFactory FireFoxDriver(){
        return new BaseDriver("firefox");
    }

    public IDriverFactory ChromeDriver(){
        return new BaseDriver("chrome");
    }

    public String UserName(){
        return _configuration.DefaultUserName();
    }

    public String Password(){
        return _configuration.DefaultPassword();
    }


}
