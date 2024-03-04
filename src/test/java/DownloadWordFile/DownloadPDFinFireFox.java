package DownloadWordFile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPDFinFireFox {
    
      public static void main(String[] args) throws InterruptedException, IOException {


       FirefoxProfile profile = new FirefoxProfile();
       profile.setPreference("pdfjs.disabled", true); //For PDF
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // Mime type for pdf
                                                                                               // files is application/msword
        profile.setPreference("browser.download.folderList", 2); // File will be saved in desired location
        String location = System.getProperty("user.dir") + "\\downloads";

        profile.setPreference("browser.download.dir", location);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options); // Pass options here

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
