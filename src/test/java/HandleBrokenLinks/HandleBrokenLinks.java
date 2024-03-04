package HandleBrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenlinks = 0;
        for (WebElement everylink : links) {
            String url = everylink.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty");
                continue;
            }
            URL link = new URL(url);
            try {
                HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
                httpconn.connect();
                if (httpconn.getResponseCode() >= 400) {
                    System.out.println(httpconn.getResponseCode() + url + "is Broken Link");
                    brokenlinks++;
                } else {
                    System.out.println(httpconn.getResponseCode() + url + "is Valid Link");

                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        System.out.println(("No of broken links :" + brokenlinks));
        driver.quit();
    }
}
