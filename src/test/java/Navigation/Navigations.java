package Navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup(); // using webdriver manager API 
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.snapdeal.pk/");
        driver.get("http://www.amazon.com");
        driver.navigate().back();  // back to snapdeal
        driver.navigate().forward(); // again back to amazon
    driver.navigate().refresh();
    
    } 
    
}
