package DropdownSorted;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSorted {
    
        public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement drpElement=driver.findElement(By.name("category_id"));
        Select drpselect=new Select(drpElement);
        List<WebElement> options=drpselect.getOptions();
        ArrayList <String> originalList=new ArrayList<>();
        ArrayList<String> tempList=new ArrayList<>();

        for(WebElement option:options){
            originalList.add(option.getText());
            tempList.add(option.getText());
        }
System.out.println("Original list: " + originalList);
System.out.println("Temp list: " + tempList);

        Collections.sort(tempList);
        System.out.println("Original list: " + originalList);
System.out.println("Temp list After sorting: " + tempList);
       
if(originalList.equals(tempList)){
    System.out.println("Dropdown is sorted");
}else{
    System.out.println("Dropdown is Unsorted");

}

}
}
