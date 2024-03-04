package hover;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import demo.firstTest;
import pages.HomePage;
import pages.HoversPage;

public class HoverTests extends firstTest {

    private WebDriver driver;

    @Test
    public void testHoverUser1() {
        HomePage home = new HomePage(driver);
        HoversPage hoversPage = new HoversPage(driver);

        home.clickHovers();

        // HoversPage hoversPage = homePage.clickHovers();
        hoversPage.hoverOverFigure(1);
        assertTrue(hoversPage.hoverOverFigure(1).isCaptionDisplayed(), "Caption not displayed");
        assertEquals(hoversPage.hoverOverFigure(1).getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(hoversPage.hoverOverFigure(1).getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(hoversPage.hoverOverFigure(1).getLink().endsWith("/users/1"), "Link incorrect");
    }

}
