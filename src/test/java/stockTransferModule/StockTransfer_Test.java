package stockTransferModule;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.HomePage;
import WebDriverUtility.*;
import org.testng.annotations.Test;

public class StockTransfer_Test extends BaseClass {
    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void stockTransfer() throws Throwable {
        wu.waitForPageLoad(driver);

        //Step 1: Navigate to purchase entry module
        HomePage hp = new HomePage(driver);
        hp.getStockTransferDrpdwn().click();


    }

}
