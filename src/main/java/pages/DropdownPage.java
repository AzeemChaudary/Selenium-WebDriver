package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.cssSelector("div #dropdown");

    public DropdownPage(WebDriver driver){
        this.driver=driver;
    }

    public void selectFromDropDown(String option){
findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedopton(){
        List<WebElement> selectedElements =findDropdownElement().getAllSelectedOptions();
        List<String> selectedTexts = new ArrayList<>(); // Create an empty list for strings

    for (WebElement element : selectedElements) {
        selectedTexts.add(element.getText()); // Extract text from each WebElement
    }

    return selectedTexts;  
    }

    private Select findDropdownElement(){
return new Select(driver.findElement(dropdown));    
    }
}
