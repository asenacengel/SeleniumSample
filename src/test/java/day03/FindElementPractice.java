package day03;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args) throws Exception {

     //   WebDriverManager.chromedriver().setup();
      //  WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        Thread.sleep(3000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(3000);
        WebElement signup = driver.findElement(By.name("wooden_spoon"));
        signup.click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");

        }


        Thread.sleep(3000);
        driver.quit();


    }
}
