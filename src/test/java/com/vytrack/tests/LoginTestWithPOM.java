package com.vytrack.tests;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.VytrackLoginPage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTestWithPOM extends TestBase {


    @Test
    public void login_test() {

        //goto login page
        loginPage.gotoLoginPage();
        //enter username
        BrowserUtils.sleep(2);
        loginPage.userNameInput
                .sendKeys(ConfigurationReader.getProperty("driver_username"));
        //enter password
        BrowserUtils.sleep(2);
        loginPage.passwordInput
                .sendKeys(ConfigurationReader.getProperty("driver_password"));
        //click the login button
        BrowserUtils.sleep(2);
        loginPage.loginButton.click();
        //verify page header
        Boolean isDisplayedPageHeader = dashboardPage.pageHeader.isDisplayed();
        Assert.assertTrue(isDisplayedPageHeader);


    }

    @Test
    public void login_test_with_method() {
        //go to login page
        loginPage.gotoLoginPage();

        //login
        loginPage
                .login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));
        //verify page header
        String expectedPageHeader="Dashboard";
        String actualPageHeader=dashboardPage.pageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);

    }

}
