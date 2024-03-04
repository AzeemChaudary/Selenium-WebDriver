package Cookies;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Capture cookies from the browser
        Set<Cookie> cookies = driver.manage().getCookies(); // Return all the Cookies
        System.out.println("Size of Cookies " + cookies.size());

        // Print cookies
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        // Add Cookie to the Browser
        Cookie cookieobj = new Cookie("MyCookie123/CookieName", "1234/CookieValue");
        driver.manage().addCookie(cookieobj);

        Set<Cookie> cookiesnew = driver.manage().getCookies(); // Return all the Cookies
        System.out.println("Size of Cookies after adding" + cookiesnew.size());

        // Delete Specific Cookie
        driver.manage().deleteCookie(cookieobj);
        Set<Cookie> cookiesneww = driver.manage().getCookies(); // Return all the Cookies
        System.out.println("Size of Cookies after Deleting Specific Cookie" + cookiesneww.size());

        // Delete Cookie by name
        Cookie cookieobjj = new Cookie("MyCookie123/CookieName", "1234/CookieValue");
        driver.manage().addCookie(cookieobjj);
        driver.manage().deleteCookieNamed("MyCookie123/CookieName");

        // Delete all the Cookies
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesnewww = driver.manage().getCookies(); // Return all the Cookies
        System.out.println("Size of Cookies after Deleting all cookies" + cookiesnewww.size());

        driver.quit();

    }
}
