package AutoSuggestDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        List<WebElement> list = driver.findElements((By.xpath("//li[@class='sa_sg']//span")));
        System.out.println("No of AutoSuggestions are " + list.size());

        for (WebElement ListItem : list) {
            if (ListItem.getText().equals("selenium")) {
                ListItem.click();
                break;
            }
        }
    }
}
