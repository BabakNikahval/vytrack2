package com.vytrack.tests;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.VytrackLoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTestWithPOM {

    @Test
    public void login_test(){
        VytrackLoginPage loginPage=new VytrackLoginPage();
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
        DashboardPage dashboardPage=new DashboardPage();

        Boolean isDisplayedPageHeader=dashboardPage.pageHeader.isDisplayed();
        Assert.assertTrue(isDisplayedPageHeader);



    }


    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
