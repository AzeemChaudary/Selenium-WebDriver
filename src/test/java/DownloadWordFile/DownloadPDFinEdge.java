package DownloadWordFile;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPDFinEdge {
    
    
    public static void main(String[] args) throws InterruptedException, IOException {

        String location = System.getProperty("user.dir") + "\\downloads";

        HashMap<String, Object> preferences = new HashMap<>();
        preferences.put("plugins.always_open_pdf_externally", true);
        preferences.put("download.default_directory", location);
        // For Chrome Options
        EdgeOptions options = new EdgeOptions();
        options.setCapability("prefs", preferences);

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options); // Pass options here

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
