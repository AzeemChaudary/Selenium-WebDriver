package DownloadWordFile;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadwordFileChromeBrowser {

    public static void main(String[] args) throws InterruptedException, IOException {
        String location = System.getProperty("user.dir") + "\\downloads";

        // Browser Settings for Chrome
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("download.default_directory", location);

        // For Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options); //Pass options here

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
