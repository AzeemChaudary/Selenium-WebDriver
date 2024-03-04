package dropdown;
// import static org.testng.Assert.assertEquals;
// import static org.testng.Assert.assertTrue;

// import java.util.List;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import demo.firstTest;
import pages.DropdownPage;
//import pages.HomePage;

public class dropdown extends firstTest {
//private WebDriver driver;
    @Test
    public void testSelectedption(){
      //  String option = "Option 1";
      //  HomePage homePage = new HomePage(driver);
     // DropdownPage dropDownPage;
      DropdownPage dropDownPage = homePage.clickDropdown();
             dropDownPage.selectFromDropDown("Option 1");
    // List<String> selectedOptions = dropDownPage.getSelectedopton();
    // assertEquals(selectedOptions.size(), 1 );
    // assertTrue(selectedOptions.contains(option) , "option not selected");
     }

   
  
}
