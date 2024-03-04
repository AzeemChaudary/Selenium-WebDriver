package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdowns {
    public static void main(String[] args){
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/dropdown");
WebElement dropdown=driver.findElement(By.cssSelector(".example #dropdown"));

//First way for selecting option from dropdown
Select dropdownElements = new Select(dropdown);
dropdownElements.selectByVisibleText("Option 1");

//Second way 
dropdownElements.selectByValue("2");

//Third way
dropdownElements.selectByIndex(1);
    }
}
