package inventoryModule;

import java.time.Duration;

import ObjectRepository.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddProductsToWareHouse_Test extends BaseClass {
	
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

		wu.waitForElementPresent(driver, cp.getWareHouseOption());
		cp.getWareHouseOption().click();

		// Step 4: Read data from Excel and click on add products
		int rowCount = eu.getRowCount("wareHouseProducts");
		for (int i = 1; i <= rowCount; i++) {
			String barcode = eu.getDataFromExcel("wareHouseProducts", i, 0) + ju.getRandomNumber();
			String mrp = eu.getDataFromExcel("wareHouseProducts", i, 9);
			String prodName = eu.getDataFromExcel("wareHouseProducts", i, 3) + ju.getRandomNumber();
			String purPrice = eu.getDataFromExcel("wareHouseProducts", i, 10);
			String uom = eu.getDataFromExcel("wareHouseProducts", i, 7);
			String SP1 = eu.getDataFromExcel("wareHouseProducts", i, 11);
			String qty = eu.getDataFromExcel("wareHouseProducts", i, 8);
			String gst = eu.getDataFromExcel("wareHouseProducts", i, 16);
			String category = eu.getDataFromExcel("wareHouseProducts", i, 5);
			String subCat = eu.getDataFromExcel("wareHouseProducts", i, 6);

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
		System.out.println("WareHouse inventory count is : "+ ivnCount);

		ip.getStockMdl().click();
		Thread.sleep(500);

		// Step 3: Click dropdown and select store
		StockPage sp= new StockPage(driver);
		wu.waitForElementTobeClickable(driver, sp.getSelectStoreIdDrpdwn());
		sp.getSelectStoreIdDrpdwn().click();
		Thread.sleep(1000);

		wu.waitForElementPresent(driver, sp.getWareHouseOption());
		wu.waitForElementTobeClickable(driver, sp.getWareHouseOption());
		sp.getWareHouseOption().click();

		String ivnCountInStock= sp.getInventoryCount().getText();
		System.out.println("WareHouse Stock inventory count is : "+ ivnCountInStock);
	}

}
