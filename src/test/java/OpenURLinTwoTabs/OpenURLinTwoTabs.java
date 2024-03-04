
package OpenURLinTwoTabs;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLinTwoTabs {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   
   
        //Opening links in different tabs of same wndow
        driver.get("https://demo.nopcommerce.com");

        driver.switchTo().newWindow(WindowType.TAB); //Switch to new tab of same window

        driver.get("https://opencart.com");

        
        
        //Openng links in different Windows 
        driver.get("https://demo.nopcommerce.com");

        driver.switchTo().newWindow(WindowType.WINDOW); //Switch to new  window

        driver.get("https://opencart.com");
    
    }

}