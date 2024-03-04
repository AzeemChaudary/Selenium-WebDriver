package KeyboardActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CopyandPasteText {
    

      public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
        driver.get("https://text-compare.com");
        driver.manage().window().maximize();
        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

        input1.sendKeys(("welcome to selenium"));

        Actions act = new Actions(driver);

        // CNTRL + A Select All the Text
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");

        act.keyUp(Keys.CONTROL);
        act.perform();

        // CNTRL + C Copy Select text
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");

        act.keyUp(Keys.CONTROL);
        act.perform();

        // TAB Key. Shift to input2 box
        act.sendKeys(Keys.TAB);
        act.perform();

        // CNTRL + C Paste Select text
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");

        act.keyUp(Keys.CONTROL);
        act.perform();

        if (input1.getAttribute("value").equals((input2.getAttribute("value")))) {
            System.out.println("Text Copied ");
        } else {
            System.out.println("Text Not Copied ");

        }
    
    }
}
