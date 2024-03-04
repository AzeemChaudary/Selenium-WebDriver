package SizeAndLocationOfElement;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        // Location method 1
        logo.getLocation(); // Provide x-axis and y-axis coordinated of Webelement
        logo.getLocation().getX(); // Get X-axis coordinate of WebElement only
        logo.getLocation().getY(); // Get Y-axis coordinate of WebElement only

        // Location method 2
        logo.getRect().getX();
        logo.getRect().getY();

        // Size of Element
        logo.getSize();
        logo.getSize().getWidth(); // Get width of element
        logo.getSize().getHeight(); // Get Height of element

        // Size Method 2
        logo.getRect().getDimension().getWidth();
        logo.getRect().getDimension().getHeight();

    }
}
