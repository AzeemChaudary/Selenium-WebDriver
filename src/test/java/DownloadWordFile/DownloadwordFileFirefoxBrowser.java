package DownloadWordFile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadwordFileFirefoxBrowser {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Firefox
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword"); // Mime type for doc
                                                                                               // files is application/msword
        // profile.setPreference("browser.download.folderList", 0); // File will be
        // saved in desktop
        // profile.setPreference("browser.download.folderList", 1); // File will be
        // saved in downloads
        profile.setPreference("browser.download.folderList", 2); // File will be saved in desired location
        String location = System.getProperty("user.dir") + "\\downloads";

        profile.setPreference("browser.download.dir", location);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options); // Pass options here

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
