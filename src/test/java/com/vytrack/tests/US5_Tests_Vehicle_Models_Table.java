package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US5_Tests_Vehicle_Models_Table extends TestBase {

    @Test
    public void verify_columns_as_sales_manager() {
        //login as sales manager
        VytrackUtils.loginAsSalesManager();
        //go to Fleet tab
        String fleetTabElementLocator="//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        BrowserUtils.sleep(3);
    }
}
