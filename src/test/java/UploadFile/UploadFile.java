package UploadFile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
    public static void main(String[] args) throws InterruptedException, IOException, AWTException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://monsterindia.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();

        // Whenever we have type='file' attribute for a element we can use sendkeys for
        // uploading file

        // Using sendkeys method
        // Provide path of the file to be uploaded
        driver.findElement(By.xpath("//input[@id='file-upload']"))
                .sendKeys("D:\\Selenium WebDriver\\demo\\downloads\\file-sample_150kB.pdf");

        // Using Robot class methods & using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", button);

        // Copy path of file to be uploaded
        // CNTRL+V
        // ENTER

        Robot rb = new Robot();
        rb.delay(2000); // Delay time as upload file window screen will take some time to appear

        StringSelection ss = new StringSelection("D:\\Selenium WebDriver\\demo\\downloads\\file-sample_150kB.pdf"); // Pass
                                                                                                                    // the
                                                                                                                    // path
                                                                                                                    // of
                                                                                                                    // file
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); // Copy the file path to Clipboard

        // CNTRL +V

        rb.keyPress(KeyEvent.VK_CONTROL); // Press the CNTRL Key
        rb.keyPress(KeyEvent.VK_V); // Press the V Key
        rb.delay(2000);

        // Release CNTRL AND V Keys
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);
        // ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
