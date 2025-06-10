package inventoryModule;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryMenu_Page;
import ObjectRepository.UploadNewProductsPage;
import WebDriverUtility.WebDriverUtility;

public class UploadProductsTest extends BaseClass {	
	WebDriverUtility wu= new WebDriverUtility();
	/**
	@Test
	public void uploadProducts() throws Throwable {
		wu.waitForPageLoad(driver);
	    //Step 1: Launch the application
		
		//Step 2: Navigate to inventory module
		HomePage hp= new HomePage(driver);
		hp.getInventoryDrpdwn().click();
		
		//Step 3: Click on  upload  new products and select store 
		 InventoryMenu_Page ip= new InventoryMenu_Page(driver);
	     ip.getUploadNewProductsMdl().click();
		
		UploadNewProductsPage up= new UploadNewProductsPage(driver);	
		Thread.sleep(200);
		up.getSelectStoreIdDrpdwn().click();
		Thread.sleep(100);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(up.getStoreOption())).click();

        up.getUploadFile().click();
        Thread.sleep(500); 
        
        // Step 4: Upload the file using hidden input
       // String filePath = System.getProperty("user.dir") + "/src/test/resources/whportal_sample_upload (1).csv";

        //String filePath =System.getProperty("user.dir") + "./src/test/resources/whportal_sample_upload data.csv";

       String filePath = "./src/test/resources/whportal_sample_upload data.csv";

        up.getFileUploadInput().sendKeys(filePath);
        
        up.getUploadCsvFileBtn().click();
	}

	**/
	@Test
	    public void uploadProducts() throws Throwable {
	        wu.waitForPageLoad(driver);

	        // Step 1: Navigate to Inventory
	        HomePage hp = new HomePage(driver);
	        hp.getInventoryDrpdwn().click();
	        
	       //Step 2: Click Upload New Products and select store
	        InventoryMenu_Page ip= new InventoryMenu_Page(driver);
	        ip.getUploadNewProductsMdl().click();
	        
	        UploadNewProductsPage up = new UploadNewProductsPage(driver);
	        Thread.sleep(300);
	        up.getSelectStoreIdDrpdwn().click();
	        
	        wu.waitForElementPresent(driver, up.getStoreOption());
			up.getStoreOption().click();

	        // Step 3: Trigger the uploader UI
	        up.getUploadFile().click();
	        Thread.sleep(1000); // Give time for input to appear

	        // Step 4: Upload file using input tag
	        String filePath = System.getProperty("user.dir") + "./src/test/resources/whportal_sample_upload data.csv";
	        WebElement fileInput = up.getFileUploadInput();
	        fileInput.sendKeys(filePath);
	        Thread.sleep(2000); // Let upload process (optional)
	        
	       // Step 5: Click the final Upload CSV button
	        up.getUploadCsvFileBtn().click();

	        // Optional: Add assertion or wait for success message
	        // e.g., wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Upload successful']")));
	    }

	        
}
