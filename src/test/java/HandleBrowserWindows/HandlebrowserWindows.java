package HandleBrowserWindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlebrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        String windowID = driver.getWindowHandle(); // Return ID of single broswer window
        System.out.println(windowID); // Return different ID Dyanamically every time weopen a broweser window
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIDs = driver.getWindowHandles(); // return IDs of multiple windows

        // First Method Iterator()
        Iterator<String> it = windowIDs.iterator();

        String parentwindowID = it.next();
        String childwindowID = it.next();

        System.out.println(("Parent window ID " + parentwindowID));
        System.out.println(("Child window ID " + childwindowID));

        // Second Method using List/ArrayList
        List<String> windowIDsList = new ArrayList<>(windowIDs); // Converting Set to List
        String parentwindowwID = windowIDsList.get(0); // Parent window ID
        String childwindowwID = windowIDsList.get(1); // Child window ID

        System.out.println(("Parent window ID " + parentwindowwID));
        System.out.println(("Child window ID " + childwindowwID));

        // How to use window IDs for switching from one window to another
        driver.switchTo().window(parentwindowID);

        System.out.println("Parent window Title : " + driver.getTitle());

        driver.switchTo().window(childwindowID);
        System.out.println("Child window Title : " + driver.getTitle());

        // Using For each Loop
        for (String winID : windowIDsList) {
            System.out.println("Current Window ID : " + winID);
            String title = driver.switchTo().window(winID).getTitle();
            System.out.println("Current Window Title : " + title);
        }

        driver.close(); // Close single browser window which driver is pointing

        // driver.quit(); //Close all the browser windows

        // Closing Browser windows of our choice
        for (String winID : windowIDsList) {
            String title = driver.switchTo().window(winID).getTitle();
            if (title.equals("OrangeHRM") || title.equals("another title")) {
                driver.close();
            }
        }

    }
}
