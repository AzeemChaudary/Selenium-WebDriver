package HandleIFrames;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame2 {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult"); // Switch to Outer IFrame
        driver.switchTo().frame(0); // Switch to inner iframe
        String InnerFrameText = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Inner Frame text : " + InnerFrameText);
        driver.switchTo().parentFrame(); // go to parent/Outer Frame
        String OuterFrameText = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes')]")).getText();
        System.out.println("Outer Frame text : " + OuterFrameText);

    }
}
