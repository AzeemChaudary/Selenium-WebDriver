package demo;
// import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
public class firstTest {
    
    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public static void setUp(){
//         System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
//         ChromeDriver driver = new ChromeDriver();
  
WebDriverManager.chromedriver().setup(); // using webdriver manager API 
WebDriver driver=new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/");
 
// WebDriverManager.firefoxdriver().setup();
// WebDriverManager.edgedriver().setup();


//    System.setProperty("webdriver.gecko.driver" , "/path");
//    FirefoxDriver driver=new FirefoxDriver();

// System.setProperty("webdriver.edge.driver" , "resources/chromedriver.exe");
// EdgeDriver driver = new EdgeDriver();

//    driver.manage().window().maximize();  //    maximizing window size

// List<WebElement> links = driver.findElements(By.tagName("a"));
//    System.out.println(links.size());
// WebElement inputLink=driver.findElement(By.linkText("Inputs"));
// inputLink.click();
// System.out.println(driver.getTitle());
  // driver.quit(); 
  homePage=new HomePage(driver);
  // driver.close();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    // public static void main(String args[]){
    //     firstTest test = new firstTest();
    //     test.setUp();
    // }
}

