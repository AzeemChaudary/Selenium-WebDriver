package DatePicker;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dummyticket.com/dummy-ticket-for-visa-application");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='dob']")).click();
        Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthDropDown.selectByVisibleText("Oct");

        Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yearDropDown.selectByVisibleText("1990");

        // Date Selection
        String date = "15";
        List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement e : alldates) {
            String dt = e.getText();
            if (dt.equals(date)) {
                e.click();
                break;
            }
        }

    }
}
