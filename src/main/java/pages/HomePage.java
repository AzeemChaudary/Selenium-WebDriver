package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication() {
        clickLlink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        clickLlink("Dropdown");
        return new DropdownPage(driver);
    }

    public void clickLlink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        ;

    }

    public HoversPage clickHovers() {
        clickLlink("Hovers");
        return new HoversPage(driver);
    }

}
