package CaptureScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Full Page Screenshot
        TakesScreenshot ts = driver;
        File screenshotSRC = ts.getScreenshotAs(OutputType.FILE); // Capture the screenshot and save it somewhere in our
                                                                  // Memory
        File trg = new File(".\\screenshots\\homepage.png"); // Location where we want to save screenshot

        FileUtils.copyFile(screenshotSRC, trg); // Copy that screenshot in our desired location

        // Capture screenshot of portion of a page
        WebElement features = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File SRC = features.getScreenshotAs(OutputType.FILE); // Capture the screenshot and save it somewhere in our
                                                              // Memory
        File trgt = new File(".\\screenshots\\featuredproducts.png"); // Location where we want to save screenshot

        FileUtils.copyFile(SRC, trgt); // Copy that screenshot in our desired location

        // Capture Screenshot of Specific WebElement
        WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File SRCC = ele.getScreenshotAs(OutputType.FILE); // Capture the screenshot and save it somewhere in our Memory
        File trget = new File(".\\screenshots\\logo.png"); // Location where we want to save screenshot

        FileUtils.copyFile(SRCC, trget); // Copy that screenshot in our desired location

    }
}
