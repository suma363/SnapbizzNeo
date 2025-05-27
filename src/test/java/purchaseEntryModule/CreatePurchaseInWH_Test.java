package purchaseEntryModule;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.*;
import WebDriverUtility.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreatePurchaseInWH_Test extends BaseClass {
    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void createPurchaseForWarehouse() throws Throwable {
        wu.waitForPageLoad(driver);

        // Step 1: Navigate to purchase entry module
        HomePage hp = new HomePage(driver);
        hp.getPurchaseEntryDrpdwn().click();

        // Step 2: Create purchase entry
        PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
        pp.getCreatePurchaseEntryMdl().click();
        Thread.sleep(1000);

        CreatePurchase_Page cp = new CreatePurchase_Page(driver);
        wu.waitForElementTobeClickable(driver, cp.getSelectStoreIdDrpdwn());
        cp.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, cp.getWareHouseOption());
        wu.waitForElementTobeClickable(driver, cp.getWareHouseOption());
        cp.getWareHouseOption().click();
        Thread.sleep(1000);

        cp.getTagDistDrpDwn().sendKeys("abc");

        wu.waitForElementTobeClickable(driver, cp.getAddDistPopupYes());
        cp.getAddDistPopupYes().click();

        //Read data from Excel and add new Distributor
        int row = 1;
            String name = eu.getDataFromExcel("distributorSheet", row, 0);
           //String phnNo = eu.getDataFromExcel("distributorSheet", row, 1);
        String basePhone = eu.getDataFromExcel("distributorSheet", row, 1); // 7 digits
        String randomPart = String.valueOf((int)(Math.random() * 1000)); // 3 digits
        String phnNo = (basePhone + randomPart).substring(0, 10); // make it exactly 10 digits

        String address = eu.getDataFromExcel("distributorSheet", row, 2);
            String gstIn = eu.getDataFromExcel("distributorSheet", row, 3);
            String landLinNo = eu.getDataFromExcel("distributorSheet", row, 4)+ ju.getRandomNumber();
            String email = eu.getDataFromExcel("distributorSheet", row, 5);

            //Add distributors
            AddDistributors_Page adp = new AddDistributors_Page(driver);
            adp.addDistributorWithAllDetails(name, phnNo, address, gstIn, landLinNo, email);

            //Select today's date
            cp.getInvoiceDate().click(); // open the calendar widget
            cp.selectTodayDate(); // select today's date dynamically

            //Enter invoice number
            String invoiceNum = eu.getDataFromExcel("distributorSheet", row, 6)+ju.getRandomNumber();
            cp.getInvoiceNum().sendKeys(invoiceNum);

            cp.getSearchByProdName().sendKeys("abc");

            //Search product if the product is not there add it
        int prodRow = 1;
        String barcode = eu.getDataFromExcel("wareHouseProducts", prodRow, 0) + ju.getRandomNumber();
        String mrp = eu.getDataFromExcel("wareHouseProducts", prodRow, 9);
        String prodName = eu.getDataFromExcel("wareHouseProducts", prodRow, 3) + ju.getRandomNumber();
        String purPrice = eu.getDataFromExcel("wareHouseProducts", prodRow, 10);
        String uom = eu.getDataFromExcel("wareHouseProducts", prodRow, 7);
        String SP1 = eu.getDataFromExcel("wareHouseProducts", prodRow, 11);
        String qty = eu.getDataFromExcel("wareHouseProducts", prodRow, 8);
        String gst = eu.getDataFromExcel("wareHouseProducts", prodRow, 16);
        String category = eu.getDataFromExcel("wareHouseProducts", prodRow, 5);
        String subCat = eu.getDataFromExcel("wareHouseProducts", prodRow, 6);

        // Add product details to the modal
        AddProducts_Page ap = new AddProducts_Page(driver);
        ap.addProduct(barcode,mrp,prodName,purPrice,uom,SP1,qty,gst,category,subCat);

        //include gst
        cp.getIncludeGst().click();
        Thread.sleep(1000);

        // Scroll to bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String netAmt = cp.getNetAmount().getText();
        System.out.println("Net Amount is :" + netAmt);

        Thread.sleep(1000);
        WebElement printAndSaveBtn = cp.getPrintAndSave();
        wu.waitForElementTobeClickable(driver, printAndSaveBtn);

       // Use JS click in case normal click is being blocked silently
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", printAndSaveBtn);

        //driver.close();


    }


}
