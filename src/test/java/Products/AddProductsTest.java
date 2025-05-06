package Products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.Add_ProductsPage;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddProductsTest extends BaseTest {
	
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	@Test
	public void addProducts() throws InterruptedException, Throwable, IOException {
	    
	  	wu.waitForPageLoad(driver);
	  	
		//Navigate to inventory module and click on add products
		HomePage hp= new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickInventory();
		InventoryPage inventory= new InventoryPage(driver);
		inventory.clickAddProducts();
		
		//read data from excel
				String barcode=eu.getDataFromExcel("productSheet", 1, 0)+ju.getRandomNumber();
				String productName=eu.getDataFromExcel("productSheet", 1, 1)+ ju.getRandomNumber();
				String mrp=eu.getDataFromExcel("productSheet", 1, 2);
				String uom=eu.getDataFromExcel("productSheet", 1, 3);
				
		Add_ProductsPage ap= new Add_ProductsPage(driver);
		ap.createProducts(barcode, productName, mrp, uom);
				
	}
	
	@Test
	public void addProductsWithMore() throws InterruptedException, Throwable, IOException {
	    
	  	wu.waitForPageLoad(driver);
	  	
		//login to app
	  	
		//Navigate to inventory module and click on add products
		HomePage hp= new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickInventory();
		InventoryPage inventory= new InventoryPage(driver);
		inventory.clickAddProducts();
		
		// Read row count
	    int rowCount = eu.getRowCount("customerSheet");

	    for (int i = 1; i <= rowCount; i++) {  // Skip header (row 0)     
		
		//read data from excel
				String barcode=eu.getDataFromExcel("productSheet", i, 0)+ju.getRandomNumber();
				String productName=eu.getDataFromExcel("productSheet", i, 1)+ ju.getRandomNumber();
				String purchaseprice=eu.getDataFromExcel("productSheet", i, 2);
				String mrp=eu.getDataFromExcel("productSheet", i, 3);
				String uom=eu.getDataFromExcel("productSheet", i, 4);
				String sellingPrice=eu.getDataFromExcel("productSheet", i, 5);
				
				Add_ProductsPage ap= new Add_ProductsPage(driver);
				ap.createProducts(barcode, productName, purchaseprice, mrp, uom, sellingPrice);
	    }
						
		 // Optional: add a short delay to avoid overlap
        Thread.sleep(1000);
		
	}
	
}
