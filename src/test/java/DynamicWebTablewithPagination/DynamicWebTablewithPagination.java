package DynamicWebTablewithPagination;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTablewithPagination {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        // Login
        WebElement username = driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Sales section and Go to Orders
        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

        // Table
        // Total no of Pages in the table
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("Total no of pages are :" + total_pages);

        // Total no of rows in the table
        for (int p = 1; p <= total_pages; p++) {
            WebElement actice_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("Actice Page " + actice_page.getText());
            actice_page.click();

            // No of Rows in the Current Page
            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"))
                    .size();
            System.out.println("No of Rows " + rows);

            // Read all the rows from Current Page
            for (int r = 1; r <= rows; r++) {
                String orderid = driver
                        .findElement(By.xpath(
                                "//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
                        .getText();
                String customerName = driver
                        .findElement(By.xpath(
                                "//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
                        .getText();
                String status = driver
                        .findElement(By.xpath(
                                "//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
                        .getText();

                System.out.println(orderid + "  " + customerName + "  " + status);
            }

            // Click on next page in the table
            String nextpageno = Integer.toString(p + 1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + nextpageno + "']")).click();

        }

    }
}
