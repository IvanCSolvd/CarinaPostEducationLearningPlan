package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.posteducationlearningplan.CartPage;
import com.zebrunner.carina.demo.posteducationlearningplan.CreateAccountPage;
import com.zebrunner.carina.demo.posteducationlearningplan.HomePage;
import com.zebrunner.carina.demo.posteducationlearningplan.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationStoreTest implements IAbstractTest {

    @Test
    public void testFailedRegistration() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened());
        CreateAccountPage createAccountPage = loginPage.clickRegistrationContinueButton();
        createAccountPage.acceptPolicy();
        createAccountPage.verifyRegistration();
        Assert.assertTrue(createAccountPage.isAlertErrorDisplayed(), "The registration error was not displayed");
    }

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.login("testeandoando", "Test123");
        Assert.assertTrue(loginPage.accountIsLogged(), "Account is not logged");
    }

    //todo implement testSearchProduct

    public void testEmptyCart() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = homePage.clickCartButton();
        Assert.assertTrue(cartPage.isCarIsEmptyTextPresent(), "Car is not empty");
    }
}