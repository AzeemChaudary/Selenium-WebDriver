package Tables;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        // Find no of rows in the table
        int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
        System.out.println("No of rows are " + rows);

        // Find no of columns in the table
        int columns = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
        System.out.println("No of columns are " + columns);

        // Retrieve specific row and column data
        String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
        System.out.println("Text is " + value);

        // Retrieve all the data from the table
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[" + c + "]"))
                        .getText();
                System.out.print("Data of each row : " + data + "  ");
            }
            System.out.println();
        }

        driver.quit();

    }
}
