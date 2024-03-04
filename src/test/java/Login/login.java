package Login;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demo.firstTest;
import pages.LoginPage;
import pages.SecureAreaPage;

public class login extends firstTest {
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLogin();
        assertEquals(secureAreaPage.getAlertText(), "You logged into a secure area!", "Alert text is incorrect");
    }
}
