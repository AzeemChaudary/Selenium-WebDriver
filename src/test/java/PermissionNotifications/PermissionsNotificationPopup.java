package PermissionNotifications;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionsNotificationPopup {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // disable notifications popup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://redbus.in/");
        driver.manage().window().maximize();

    }
}
