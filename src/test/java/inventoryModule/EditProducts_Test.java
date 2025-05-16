package inventoryModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.AddProducts_Page;
import ObjectRepository.CataloguePage;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryMenu_Page;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class EditProducts_Test extends BaseClass {

	WebDriverUtility wu = new WebDriverUtility();
	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju = new JavaUtility();

	@Test
	public void editProduct() throws Throwable {
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
		wu.waitForElementtobeClickable(driver, cp.getSelectStoreIdDrpdwn());
		cp.getSelectStoreIdDrpdwn().click();

		wu.waitForElementPresent(driver, cp.getWareHouseOption());
		cp.getWareHouseOption().click();
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Step 4: Click on Add Product
	    wait.until(ExpectedConditions.elementToBeClickable(cp.getAddProductBtn()));
	    cp.getAddProductBtn().click();


		// Step 5: Read data from excel and click on add products
		 int row = 1; // pick first row (or change if needed)
		    String barcode = eu.getDataFromExcel("wareHouseProducts", row, 0) + ju.getRandomNumber();
		    String mrp = eu.getDataFromExcel("wareHouseProducts", row, 9);
		    String prodName = eu.getDataFromExcel("wareHouseProducts", row, 3) + ju.getRandomNumber();
		    String purPrice = eu.getDataFromExcel("wareHouseProducts", row, 10);
		    String uom = eu.getDataFromExcel("wareHouseProducts", row, 7);
		    String SP1 = eu.getDataFromExcel("wareHouseProducts", row, 11);
		    String qty = eu.getDataFromExcel("wareHouseProducts", row, 8);
		    String gst = eu.getDataFromExcel("wareHouseProducts", row, 16);
		    String category = eu.getDataFromExcel("wareHouseProducts", row, 5);
		    String subCat = eu.getDataFromExcel("wareHouseProducts", row, 6);

		   // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".v-overlay__scrim")));

		    
		    // Step 6: Fill the form and submit
		    AddProducts_Page ap = new AddProducts_Page(driver);
		    ap.addProduct(barcode, mrp, prodName, purPrice, uom, SP1, qty, gst, category, subCat);

		    // Step 7: Search for the product you just added
		    Thread.sleep(2000); // optional, let table refresh
		    cp.getSearchProduct().clear();
		    cp.getSearchProduct().sendKeys(prodName); // or use barcode
	}
}
