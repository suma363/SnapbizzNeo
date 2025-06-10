package purchaseEntryModule;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.*;
import WebDriverUtility.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class CreatePurchaseInStore_Test extends BaseClass {

    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void addSingleDistributor() throws Throwable {
        wu.waitForPageLoad(driver);

        //Step 1: Navigate to purchase entry module
        HomePage hp = new HomePage(driver);
        hp.getPurchaseEntryDrpdwn().click();

        // Step 2: Create purchase entry
        PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
        pp.getCreatePurchaseEntryMdl().click();
        Thread.sleep(1000);

        CreatePurchase_Page cp = new CreatePurchase_Page(driver);
        wu.waitForElementTobeClickable(driver, cp.getSelectStoreIdDrpdwn());
        cp.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, cp.getStoreOption());
        wu.waitForElementTobeClickable(driver, cp.getStoreOption());
        cp.getStoreOption().click();
        Thread.sleep(1000);

        cp.getTagDistDrpDwn().sendKeys("abc");

        wu.waitForElementTobeClickable(driver, cp.getAddDistPopupYes());
        cp.getAddDistPopupYes().click();

        //Read data from Excel and add new Distributor
        int row = 2;
        String name = eu.getDataFromExcel("distributorSheet", row, 0);
        // String phnNo = eu.getDataFromExcel("distributorSheet", row, 1);
        String basePhone = eu.getDataFromExcel("distributorSheet", row, 1); // 7 digits
        String randomPart = String.valueOf((int)(Math.random() * 5000)); // 3 digits
        String phnNo = (basePhone + randomPart).substring(0, 10); // make it exactly 10 digits

        String address = eu.getDataFromExcel("distributorSheet", row, 2);
        String gstin = eu.getDataFromExcel("distributorSheet", row, 3);
        String landLinNo = eu.getDataFromExcel("distributorSheet", row, 4)+ ju.getRandomNumber();
        String email = eu.getDataFromExcel("distributorSheet", row, 5);

        //Add distributors
        AddDistributors_Page adp = new AddDistributors_Page(driver);
        adp.addDistributorWithAllDetails(name, phnNo, address, gstin, landLinNo, email);

        //Select today's date
        cp.getInvoiceDate().click(); // open the calendar widget
        cp.selectTodayDate(); // select today's date dynamically

        //Enter invoice number
        String invoiceNum = eu.getDataFromExcel("distributorSheet", row, 6)+ju.getRandomNumber();
        cp.getInvoiceNum().sendKeys(invoiceNum);

        cp.getSearchByProdName().sendKeys("abc");

        //Search product if the product is not there add it
        int prodRow = 2;
        String barcode = eu.getDataFromExcel("productSheet", prodRow, 0) + ju.getRandomNumber();
        String mrp = eu.getDataFromExcel("productSheet", prodRow, 11);
        String prodName = eu.getDataFromExcel("productSheet", prodRow, 3) + ju.getRandomNumber();
        String purPrice = eu.getDataFromExcel("productSheet", prodRow, 12);
        String uom = eu.getDataFromExcel("productSheet", prodRow, 9);
        String SP1 = eu.getDataFromExcel("productSheet", prodRow, 13);
        String qty = eu.getDataFromExcel("productSheet", prodRow, 10);
        String gst = eu.getDataFromExcel("productSheet", prodRow, 16);
        String category = eu.getDataFromExcel("productSheet", prodRow, 7);
        String subCat = eu.getDataFromExcel("productSheet", prodRow, 8);


        // Add product details to the modal
        AddProducts_Page ap = new AddProducts_Page(driver);
        ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);

        //include gst
        cp.getIncludeGst().click();

       // Scroll to bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String netAmt = cp.getNetAmount().getText();
        System.out.println("Net Amount is :" + netAmt);

        Thread.sleep(500);
       wu.waitForElementTobeClickable(driver,cp.getPrintAndSendInStore());
        cp.getPrintAndSendInStore().click();

        driver.close();
    }

}
