package HandleLinks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        // driver.findElement(By.linkText("Today's Deals")).click();
        // driver.findElement(By.partialLinkText("Deals")).click();

        // How to capture all the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // System.out.println("Total no of links : " + links.size());

        // Normal for loop
        for (int i = 0; i <= links.size(); i++) {
            String text = links.get(i).getText();
            System.out.println(" links Text  : " + text);
            String link = links.get(i).getAttribute("href");
            System.out.println(" links  href : " + link);

        }

        // Using For each Loop
        for (WebElement link : links) {
            String text = link.getText();
            System.out.println(" links Text  : " + text);
            String linkhref = link.getAttribute("href");
            System.out.println(" links  href : " + linkhref);
        }

    }
}
