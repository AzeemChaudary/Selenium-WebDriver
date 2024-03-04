package MouseClickActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClick {

  public static void main(String[] args) throws InterruptedException, MalformedURLException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https:/swisnl.github.io/jQuery-contextMenu/demo.html");
    driver.manage().window().maximize();

    WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
    Actions act = new Actions(driver);
    act.contextClick(button).perform(); // perform right click on button

  }
}
