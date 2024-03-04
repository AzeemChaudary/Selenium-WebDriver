package CheckBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();

        // Select specific checkbox
        driver.findElement(By.xpath("//input[@id='monday']")).click();

        // Select All the checkboxes
        List<WebElement> checkboxes = driver
                .findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total no of checkboxes " + checkboxes.size());

        // Using for loop
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }

        // Using for each Loop
        for (WebElement chbox : checkboxes) {
            chbox.click();
        }

        // Selecting checkboxes By Choice Monday and Sunday
        for (WebElement chbox : checkboxes) {
            String checkboxName = chbox.getAttribute("id");
            if (checkboxName.equals("monday") || checkboxName.equals("sunday")) {
                chbox.click();
            }
        }

        // Select last 2 CheckBoxes
        int totalcheckboxes = checkboxes.size();
        for (int i = totalcheckboxes - 2; i < totalcheckboxes; i++) {
            checkboxes.get(i).click();
        }

        // Select first 2 CheckBoxes
        for (int i = 0; i < totalcheckboxes; i++) {
            if (i < 3) {
                checkboxes.get(i).click();
            }
        }
    }
}
