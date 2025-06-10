package inventoryModule;

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

public class EditAndDeleteStoreProduct_Test extends BaseClass {

    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void editProduct() throws Throwable {
        wu.waitForPageLoad(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Navigate to Inventory
        HomePage hp = new HomePage(driver);
        hp.getInventoryDrpdwn().click();

        // Step 2: Click on Catalogue module
        InventoryMenu_Page ip = new InventoryMenu_Page(driver);
        ip.getCatalogueMdl().click();
        Thread.sleep(500);

        // Step 3: Click dropdown and select store
        CataloguePage cp = new CataloguePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(cp.getSelectStoreIdDrpdwn()));
        cp.getSelectStoreIdDrpdwn().click();
        Thread.sleep(1000);

        wu.waitForElementPresent(driver, cp.getStoreOption());
        wait.until(ExpectedConditions.elementToBeClickable(cp.getStoreOption())).click();

        // Step 4: Click on Add Product
        wait.until(ExpectedConditions.elementToBeClickable(cp.getAddProductBtn())).click();

        // Step 5: Read data from Excel and click on add products
        int row = 3; // pick first row (or change if needed)

        String barcode = eu.getDataFromExcel("productSheet", row, 0) + ju.getRandomNumber();
        String mrp = eu.getDataFromExcel("productSheet", row, 11);
        String prodName = eu.getDataFromExcel("productSheet", row, 3) + ju.getRandomNumber();
        String purPrice = eu.getDataFromExcel("productSheet", row, 12);
        String uom = eu.getDataFromExcel("productSheet", row, 9);
        String SP1 = eu.getDataFromExcel("productSheet", row, 13);
        String qty = eu.getDataFromExcel("productSheet", row, 10);
        String gst = eu.getDataFromExcel("productSheet", row, 16);
        String category = eu.getDataFromExcel("productSheet", row, 7);
        String subCat = eu.getDataFromExcel("productSheet", row, 8);

        // Step 6: Fill the form and submit
        AddProducts_Page ap = new AddProducts_Page(driver);
        ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);
        Thread.sleep(2000);

        // Step 7: Search for the product you just added
        wu.slowType(cp.getSearchProduct(), prodName.trim(), 200); // 150ms delay per character
        cp.getSearchProduct().sendKeys(Keys.ENTER);

        /**Thread.sleep(1000);
        WebElement productRow = driver.findElement(By.xpath("//td[text()='" + barcode + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productRow);
        Thread.sleep(500); // Wait for scroll to complete


        // Step 8: Capture the product's status using the generated barcode
        String xpath = "//td[text()='" + barcode + "']/ancestor::tr//div[contains(@class,'v-chip__content')]";
        String status = driver.findElement(By.xpath(xpath)).getText();

        // Print the barcode and its status
        System.out.println("Barcode: " + barcode + " status is "+ status);

         **/

        // Step 9: Scroll to the product row and click the Edit button
        WebElement productRow = driver.findElement(By.xpath("//td[text()='" + barcode + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productRow);
        Thread.sleep(500); // Wait for scroll to complete

        //Click the Edit button in the same row
        cp.getEditProdBtn().click();
        Thread.sleep(1000);

        //Edit mrp and sp1
        String updatedMrp = "200"; // new quantity to update
        String updatedSp1 = "150"; // new quantity to update

        EditProducts_Page ep= new EditProducts_Page(driver);
        ep.editMrpAndSp1(updatedMrp, updatedSp1);
        Thread.sleep(2000);

        //Before delete the product
        String beforeInvCount=cp.getInventoryCount().getText();
        System.out.println("Before delete the product inventory count is :"+ beforeInvCount);

        //Search for the product you have added and delete the same product
        cp.getSearchProduct().click();
        cp.getSearchProduct().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        wu.slowType(cp.getSearchProduct(), prodName.trim(), 200); // 150ms delay per character
        cp.getSearchProduct().sendKeys(Keys.ENTER);

        //Scroll to the product row and click the Edit button
        WebElement prodRow = driver.findElement(By.xpath("//td[text()='" + barcode + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prodRow);
        Thread.sleep(500); // Wait for scroll to complete

        cp.getDeleteBtn(barcode).click();
        cp.getConfDelProdBtn().click();
        Thread.sleep(2000);
        String afterInvCount=cp.getInventoryCount().getText();
        System.out.println("After delete the product inventory count is :"+ afterInvCount);

    }
}
