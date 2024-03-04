package ActionvsActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionvsActions {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement feautures = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions act = new Actions(driver);
        act.moveToElement(feautures).perform(); // Mouse hover action

        act.moveToElement(feautures).build().perform();

        Action action = act.moveToElement(feautures).build();
        action.perform();

    }

}
