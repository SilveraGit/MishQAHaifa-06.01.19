package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.ProfilePageHelper;

/**
 * Created by Inka on 22-Dec-18.
 */
public class AccountCreatePageTests extends TestBase {
    //------Pages Helpers---------//
    HomePageHelper homePage;
    CreateAccountPageHelper createAccountPage;
    ProfilePageHelper profilePage;
    MenuPageHelper menuPage;
    LoginPageHelper loginPage;



    //-------Initialization page helpers-----//
    @BeforeMethod
    public void initPage() {
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        createAccountPage = PageFactory.initElements(driver, CreateAccountPageHelper.class);
        profilePage = PageFactory.initElements(driver, ProfilePageHelper.class);
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    //--------- Actions ----//

    @Test
    public void createNewAccount(){
        String email1 = latinDigitString(8) + "@gmail.com";
        homePage.waitUntilPageLoad().pressCreateAccountButton();
        createAccountPage.waitUntilPageLoad();
        createAccountPage.enterValueToFieldEmail(email1);
        createAccountPage.enterValueToFieldPassword("example");
        createAccountPage.enterValueToFieldRepPassword("example");
        createAccountPage.waitUntilRegButtonLoad();
        createAccountPage.pressRegButton();
        profilePage.waitUntilPageLoad();
        profilePage.pressMenuButton();
        menuPage.waitUntilPageIsLoad();
        menuPage.pressLogOutButton();

    }

    @Test
    public void newAccountAndLogin(){
        String email2 = latinDigitString(8) + "@gmail.com";
        homePage.waitUntilPageLoad();
        homePage.pressCreateAccountButton();
        createAccountPage.waitUntilPageLoad();
        createAccountPage.enterValueToFieldEmail(email2);
        createAccountPage.enterValueToFieldPassword("example");
        createAccountPage.enterValueToFieldRepPassword("example");
        createAccountPage.waitUntilRegButtonLoad();
        createAccountPage.pressRegButton();
        profilePage.waitUntilPageLoad();
        profilePage.pressMenuButton();
        menuPage.waitUntilPageIsLoad();
        menuPage.pressLogOutButton();
        //------------------------------Login created user----------

        homePage.waitUntilPageLoad();
        homePage.pressLoginButton();
        loginPage.waitUntilPageLoad();
        loginPage.enterValueToFieldEmail(email2);
        loginPage.enterValueToFieldPassword("example");
        loginPage.pressLogInButton();



    }
}
