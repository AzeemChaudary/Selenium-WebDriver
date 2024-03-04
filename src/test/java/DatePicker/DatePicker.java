package DatePicker;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://redbus.in/");
        driver.manage().window().maximize();
        String year = "2021";
        String month = "July";
        String date = "10";

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

        while (true) {
            String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else {
                driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
            }

        }

        // Date Selection
        List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

        for (WebElement e : alldates) {
            String dt = e.getText();
            if (dt.equals(date)) {
                e.click();
                break;
            }
        }
    }
}
