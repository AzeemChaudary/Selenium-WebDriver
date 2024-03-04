package JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Drawing Border & take screenshot
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.drawBorder(logo, driver);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\logo.png");
        FileUtils.copyFile(src, trg);

        // Getting Title of the Page
        String title = JavaScriptUtil.getTitleByJS(driver);
        System.out.println("Title of the page : " + title);

        // Click Element
        WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        JavaScriptUtil.clickElementByJS(regLink, driver);

        // Generate Alert
        JavaScriptUtil.generateAlert(driver, "This is my Alert");

        // Refresh the Page
        JavaScriptUtil.refreshBrowserByJS(driver);

        // Scroll Page down
        JavaScriptUtil.scrollPageDown(driver);

        // Scroll Page Up
        JavaScriptUtil.scrollPageDown(driver);

        Thread.sleep(4000); // wait for 4 seconds

        //Zoom Page
        JavaScriptUtil.zoomPageByJS(driver);

        //Flash Element

        JavaScriptUtil.flash(logo , driver);
    }

}
