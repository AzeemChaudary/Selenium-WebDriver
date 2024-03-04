package HandleIFrames;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrames {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        // Methods for switching to a frame
        // driver.switchTo().frame(name of frame /id of frame)
        // driver.switchTo().frame(0) // index
        // driver.switchTo().frame(WebElement)

        // Methods for switching to a frame
        // driver.switchTo().frame(name of frame /id of frame)
        // driver.switchTo().frame(0) // index
        // driver.switchTo().frame(WebElement)

        // 1st iFrame
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
        driver.switchTo().defaultContent(); // Go Back to Main page
        Thread.sleep(3000);
       
        // 2nd iFrame
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//a[normalize-space()='WebDriver']")).click();
        driver.switchTo().defaultContent(); // Go Back to Main page
        Thread.sleep(3000);

        // 3rd iFrame
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();
        

    }
}
