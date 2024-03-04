package Alerts;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // Alert window with OK Button
        driver.findElement(By.xpath("//button[normalize-space()='click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // Close the alert by clicking Ok button

        // Alert window with Ok button and cancel button
        driver.findElement(By.xpath("//button[normalize-space()='click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // Click the Ok Button and Close the Alert
        driver.findElement(By.xpath("//button[normalize-space()='click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss(); // Close Alert by clicking cancel button

        // Alert window with Ok & cancel button with Input Box
        driver.findElement(By.xpath("//button[normalize-space()='click for JS Prompt']")).click();
        Thread.sleep(3000);
        Alert alertwindow = driver.switchTo().alert();
        System.out.println("Message displayed on alert " + alertwindow.getText());
        alertwindow.sendKeys("Welcome"); //Enter text in textbox of Alert
        alertwindow.accept();   // Click the Ok Button and Close the Alert

    }
}
