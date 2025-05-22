package end_To_End;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.AddDistributors_Page;
import ObjectRepository.CreatePurchase_Page;
import ObjectRepository.HomePage;
import ObjectRepository.PurchaseEntryMenu_Page;
import WebDriverUtility.*;
import org.testng.annotations.Test;

public class CreatePurchase_E2E extends BaseClass {
    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void addDistributors() throws Throwable {
        wu.waitForPageLoad(driver);

        // Step 1: Navigate to purchase entry module
        HomePage hp = new HomePage(driver);
        hp.getPurchaseEntryDrpdwn().click();

        // Step 2: Create puchase entry
        PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
        pp.getCreatePurchaseEntryMdl().click();

        CreatePurchase_Page cp = new CreatePurchase_Page(driver);
        wu.waitForElementTobeClickable(driver, cp.getSelectStoreIdDrpdwn());
        cp.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, cp.getWareHouseOption());
        wu.waitForElementTobeClickable(driver, cp.getWareHouseOption());
        cp.getWareHouseOption().click();
        Thread.sleep(1000);

        //Read data from excel and add new Distributor
        int rowCount = eu.getRowCount("wareHouseProducts");
        for (int i = 1; i <= rowCount; i++) {
            String name = eu.getDataFromExcel("distributorSheet", i, 0);
            String phnNo = eu.getDataFromExcel("distributorSheet", i, 1) + ju.getRandomNumber();
            String address = eu.getDataFromExcel("distributorSheet", i, 2);
            String gstin = eu.getDataFromExcel("distributorSheet", i, 3);
            String landLinNo = eu.getDataFromExcel("distributorSheet", i, 4) + ju.getRandomNumber();
            String email = eu.getDataFromExcel("distributorSheet", i, 5);

            cp.getTagDistDrpDwn().sendKeys("abc");

            wu.waitForElementTobeClickable(driver, cp.getAddDistPopupYes());
            cp.getAddDistPopupYes().click();

            AddDistributors_Page ap = new AddDistributors_Page(driver);
            ap.addDistributorWithAllDetails(name, phnNo, address, gstin, landLinNo, email);

        }

    }
}
