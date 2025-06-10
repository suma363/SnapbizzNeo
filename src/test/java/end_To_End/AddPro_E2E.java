package end_To_End;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.AddProducts_Page;
import ObjectRepository.CataloguePage;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryMenu_Page;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddPro_E2E extends BaseClass{
	
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
		Thread.sleep(1000);
		cp.getAddProductBtn().click();

		// Step 4: Read data from excel and click on add products
		int rowCount = eu.getRowCount("productSheet");

		for (int i = 1; i <= rowCount; i++) {
			String barcode = eu.getDataFromExcel("productSheet", i, 0)+ju.getRandomNumber();
			String mrp = eu.getDataFromExcel("productSheet", i, 11);
			String prodName = eu.getDataFromExcel("productSheet", i, 3) + ju.getRandomNumber();
			String purPrice = eu.getDataFromExcel("productSheet", i, 12);
			String uom = eu.getDataFromExcel("productSheet", i, 9);
			String SP1 = eu.getDataFromExcel("productSheet", i, 13);
			String qty = eu.getDataFromExcel("productSheet", i, 10);
			String gst = eu.getDataFromExcel("productSheet", i, 18);
			String category = eu.getDataFromExcel("productSheet", i, 7);
			String subCat = eu.getDataFromExcel("productSheet", i, 8);

			AddProducts_Page ap = new AddProducts_Page(driver);
			ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);
		}
		Thread.sleep(500);

	}

}
