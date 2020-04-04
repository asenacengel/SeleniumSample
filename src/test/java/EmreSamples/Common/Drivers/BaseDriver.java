package EmreSamples.Common.Drivers;

import EmreSamples.Configurations.Configuration;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class BaseDriver implements IDriverFactory{

    private  WebDriver _driver;
    private WebDriverWait _wait;
    private String _browser;

    public BaseDriver(String browser) {
        _browser = browser;
    }

    public WebDriver Driver() {
        return RetrieveDriver(_browser);

    }
    public WebDriverWait Wait() {

        return RetrieveDriverWait();
    }

    private WebDriverWait RetrieveDriverWait(){
            if(_wait == null){
              _wait =   new WebDriverWait(Driver(), 15);
            }

            return _wait;
    }
    private WebDriver RetrieveDriver(String browser){
        if (_driver == null) {
            //specify browser type in configuration.properties file

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    _driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return _driver;
    }


    public  void CloseDriver() {
        if (_driver != null) {
            _driver.quit();
            _driver = null;
        }
    }

    public void WaitInSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void WaitForPageLoadForSeconds(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

}
