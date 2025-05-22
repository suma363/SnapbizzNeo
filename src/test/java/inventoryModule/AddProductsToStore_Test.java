package inventoryModule;

import java.time.Duration;

import ObjectRepository.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;
 //@Listeners(ListenerUtility.ListenerImpClass.class)
public class AddProductsToStore_Test extends BaseClass {
	WebDriverUtility wu = new WebDriverUtility();
	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju = new JavaUtility();

	@Test
	public void addProducts() throws Throwable {
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

		// Step 4: Read data from excel and click on add products
		int rowCount = eu.getRowCount("productSheet");
		for (int i = 1; i <= rowCount; i++) {
			String barcode = eu.getDataFromExcel("productSheet", i, 0) + ju.getRandomNumber();
			String mrp = eu.getDataFromExcel("productSheet", i, 11);
			String prodName = eu.getDataFromExcel("productSheet", i, 3) + ju.getRandomNumber();
			String purPrice = eu.getDataFromExcel("productSheet", i, 12);
			String uom = eu.getDataFromExcel("productSheet", i, 9);
			String SP1 = eu.getDataFromExcel("productSheet", i, 13);
			String qty = eu.getDataFromExcel("productSheet", i, 18);
			String gst = eu.getDataFromExcel("productSheet", i, 16);
			String category = eu.getDataFromExcel("productSheet", i, 7);
			String subCat = eu.getDataFromExcel("productSheet", i, 8);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".v-overlay__scrim")));

			// Re-open the modal each time
			cp.getAddProductBtn().click(); // Make sure this reopens the form
			wu.waitForElementTobeClickable(driver, cp.getAddProductBtn()); // Ensure it's clickable

			// Add product details to the modal
			AddProducts_Page ap = new AddProducts_Page(driver);
			ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);
		}
		String ivnCount= cp.getInventoryCount().getText();
		System.out.println(" Inventory count is : "+ ivnCount);

		//Check the inventory count in stock
		ip.getStockMdl().click();
		Thread.sleep(500);

		// Click dropdown and select store
		StockPage sp= new StockPage(driver);
		wu.waitForElementTobeClickable(driver, sp.getSelectStoreIdDrpdwn());
		sp.getSelectStoreIdDrpdwn().click();
		Thread.sleep(1000);

		wu.waitForElementPresent(driver, sp.getStoreOption());
		wu.waitForElementTobeClickable(driver, sp.getStoreOption());
		sp.getStoreOption().click();

		String ivnCountInStock= sp.getInventoryCount().getText();
		System.out.println("Store inventory count is : "+ ivnCountInStock);



	}
}
