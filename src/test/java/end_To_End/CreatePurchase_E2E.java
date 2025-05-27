package end_To_End;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.*;
import WebDriverUtility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CreatePurchase_E2E extends BaseClass {
    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void createPurchase() throws Throwable {
        wu.waitForPageLoad(driver);
        // Step 1: Navigate to Inventory
        HomePage hp = new HomePage(driver);
        hp.getInventoryDrpdwn().click();

        // Step 2: Click on Catalogue module
        InventoryMenu_Page ip = new InventoryMenu_Page(driver);
        ip.getCatalogueMdl().click();
        Thread.sleep(1000);

        // Step 3: Click dropdown and select store
        CataloguePage cp = new CataloguePage(driver);
        wu.waitForElementTobeClickable(driver, cp.getSelectStoreIdDrpdwn());
        cp.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, cp.getStoreOption());
        cp.getStoreOption().click();

        // Step 4: Read data from Excel and click on add products
        int rowCount = 2;
            String barcode = eu.getDataFromExcel("productSheet", rowCount, 0) + ju.getRandomNumber();
            String mrp = eu.getDataFromExcel("productSheet", rowCount, 11);
            String prodName = eu.getDataFromExcel("productSheet", rowCount, 3) + ju.getRandomNumber();
            String purPrice = eu.getDataFromExcel("productSheet", rowCount, 12);
            String uom = eu.getDataFromExcel("productSheet", rowCount, 9);
            String SP1 = eu.getDataFromExcel("productSheet", rowCount, 13);
            String qty = eu.getDataFromExcel("productSheet", rowCount, 18);
            String gst = eu.getDataFromExcel("productSheet", rowCount, 16);
            String category = eu.getDataFromExcel("productSheet", rowCount, 7);
            String subCat = eu.getDataFromExcel("productSheet", rowCount, 8);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".v-overlay__scrim")));

            // Re-open the modal each time
            cp.getAddProductBtn().click(); // Make sure this reopens the form
            wu.waitForElementTobeClickable(driver, cp.getAddProductBtn()); // Ensure it's clickable

            // Add product details to the modal
            AddProducts_Page ap = new AddProducts_Page(driver);
            ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);

        //Navigate to Create Purchase module
        hp.getPurchaseEntryDrpdwn().click();

        // Step 2: Create purchase entry
        PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
        wu.waitForElementTobeClickable(driver, pp.getCreatePurchaseEntryMdl());
        pp.getCreatePurchaseEntryMdl().click();

        CreatePurchase_Page purPage = new CreatePurchase_Page(driver);
        wu.waitForElementTobeClickable(driver, purPage.getSelectStoreIdDrpdwn());
        purPage.getSelectStoreIdDrpdwn().click();
        Thread.sleep(500);

        wu.waitForElementPresent(driver, purPage.getStoreOption());
        wu.waitForElementTobeClickable(driver, purPage.getStoreOption());
        purPage.getStoreOption().click();
        Thread.sleep(1000);

        purPage.getTagDistDrpDwn().sendKeys("abc");

        wu.waitForElementTobeClickable(driver, purPage.getAddDistPopupYes());
        purPage.getAddDistPopupYes().click();

        //Read data from Excel and add new Distributor
        int row = 1;
        String name = eu.getDataFromExcel("distributorSheet", row, 0);
        // String phnNo = eu.getDataFromExcel("distributorSheet", row, 1);
        String basePhone = eu.getDataFromExcel("distributorSheet", row, 1); // 7 digits
        String randomPart = String.valueOf((int) (Math.random() * 1000)); // 3 digits
        //String phnNo = (basePhone + randomPart).substring(0, 10); // make it exactly 10 digits
        String phnNo = "";
        try {
            phnNo = (basePhone + randomPart).substring(0, 10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid phone string length. BasePhone: '" + basePhone + "', RandomPart: '" + randomPart + "'");
            phnNo = (basePhone + randomPart + "1234567890").substring(0, 10); // force to 10 digits
        }


        String address = eu.getDataFromExcel("distributorSheet", row, 2);
        String gstIn = eu.getDataFromExcel("distributorSheet", row, 3);
        String landLinNo = eu.getDataFromExcel("distributorSheet", row, 4) + ju.getRandomNumber();
        String email = eu.getDataFromExcel("distributorSheet", row, 5);

        //Add distributors
        AddDistributors_Page adp = new AddDistributors_Page(driver);
        adp.addDistributorWithAllDetails(name, phnNo, address, gstIn, landLinNo, email);

        //Select today's date
        purPage.getInvoiceDate().click(); // open the calendar widget
        purPage.selectTodayDate(); // select today's date dynamically

        //Enter invoice number
        String invoiceNum = eu.getDataFromExcel("distributorSheet", row, 6) + ju.getRandomNumber();
        purPage.getInvoiceNum().sendKeys(invoiceNum);


        //Search the product
        wu.slowType(purPage.getSearchByProdName(), prodName, 50); // delay 200ms between each character

        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + prodName + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);



        Thread.sleep(1000);
        //include gst
        //purPage.getIncludeGst().click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String netAmt = purPage.getNetAmount().getText();
        System.out.println("Net Amount is :" + netAmt);

        Thread.sleep(1000);
       // WebElement printAndSaveBtn = purPage.getPrintAndSave();
        wu.waitForElementTobeClickable(driver, purPage.getPrintAndSave());
        purPage.getPrintAndSave().click();


        // Use JS click in case normal click is being blocked silently
       //js.executeScript("arguments[0].click();", printAndSaveBtn);

        System.out.println("===========WORKING==========");
/**
        //Check purchaseEntryList module
        pp.getPurchaseEntryListMdl().click();
        PurchaseEntryList_Page purEntryListPage= new PurchaseEntryList_Page(driver);
        wu.waitForElementTobeClickable(driver, purEntryListPage.getSelectStoreIdDrpdwn());
        purEntryListPage.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, purEntryListPage.getStoreOption());
        wu.waitForElementTobeClickable(driver, purEntryListPage.getStoreOption());
        purEntryListPage.getStoreOption().click();
        Thread.sleep(1000);

        //Capture All orders
        String allOrdersCount = purEntryListPage.getAllOrdersCount().getText().trim();
        System.out.println("All orders count in warehouse is : "+ allOrdersCount);

        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement row1 : rows) {
            String invoiceNumber = row1.findElement(By.xpath("td[1]")).getText();
            String storeName = row1.findElement(By.xpath("td[2]")).getText();
            String status = row1.findElement(By.xpath("td[4]")).getText();

            System.out.println("Invoice: " + invoiceNumber +
                    ", Store: " + storeName +
                    ", Status: " + status);
        }

        //To capture new orders
        String newOrdersCount = purEntryListPage.getNewOrdersCount().getText().trim();
        System.out.println("New orders count in warehouse is : "+ newOrdersCount);

        purEntryListPage.getNewOrdersCount().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table tbody tr")));

        // Capture data
        List<WebElement> rowsNewOrd = driver.findElements(By.cssSelector("table tbody tr"));

        for (WebElement row2 : rowsNewOrd) {
            String invoiceNumber = row2.findElement(By.xpath("td[1]")).getText();
            String storeName = row2.findElement(By.xpath("td[2]")).getText();
            String status = row2.findElement(By.xpath("td[4]")).getText();

            System.out.println("Invoice: " + invoiceNumber +
                    ", Store: " + storeName +
                    ", Status: " + status);
        }

        //driver.close();
 **/

    }
}

