package OpenLinkinNewTab;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkinNewTab {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();

        String tab = Keys.chord(Keys.CONTROL, Keys.RETURN); // Press CNTRL and Enter at same time
        driver.findElement(By.linkText("Register")).sendKeys(tab);

        // Or use following code
        driver.findElement(By.linkText("Register")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

    }
}
