package ToolTip;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();

        WebElement inputbox = driver.findElement(By.xpath("//input[@id='age']"));

        String tooltiptext = inputbox.getAttribute("title");
        System.out.println("tooltip text : " + tooltiptext);

    }
}
