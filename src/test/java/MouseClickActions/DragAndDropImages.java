package MouseClickActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropImages {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement FirstElement = driver.findElement(By.xpath("//li[1]"));
        WebElement SecondElement = driver.findElement(By.xpath("//li[2]"));
        WebElement trash = driver.findElement(By.xpath("//div[@id=;trash]"));

        Actions act = new Actions(driver);
        act.dragAndDrop(FirstElement, trash).perform(); //Move firstElement to Trash
        act.dragAndDrop(SecondElement, trash).perform(); //Move SecondElement to Trash

    }
}
