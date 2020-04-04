package EmreSamples.Common;

import EmreSamples.Common.Drivers.DriverFactory;
import EmreSamples.Common.Drivers.IDriverFactory;
import com.automation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public IDriverFactory DriverFactory;

   public BasePage(){
       DriverFactory factory = new DriverFactory();
       DriverFactory = factory.DriverByConfiguration();

       PageFactory.initElements(DriverFactory.Driver(),this );
    }

}

