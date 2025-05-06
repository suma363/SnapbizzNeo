package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebDriverUtility.JavaUtility;
import io.appium.java_client.windows.WindowsDriver;

public class Purchases_page {
	
	
	private WindowsDriver<WebElement> driver;
    public Purchases_page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //search for distributor
    public WebElement searchDist() {
    	return driver.findElementByName("Search For Distributor");
        }
    
    public WebElement distSugg() {
    	return driver.findElementByName("SnapBilling.Services.AppServices.DistributorsInfoDisplay");
        }
    
    
  //search for product
    public WebElement searchProd() {
    	return driver.findElementByName("Search By Product Name/Barcode/MRP/Attributes (Ctrl+F)");
        }
    
    public WebElement prodSugg() {
    	return driver.findElementByName("SnapBilling.Services.AppServices.ProductPackCompact");
        }
    
  //add qty
    public WebElement addQty() {
    	return driver.findElementByAccessibilityId("okBtn");
        }
    

    //click on save button
    public WebElement clickOnSaveBtn() {
    	return driver.findElementByAccessibilityId("saveButton");
        }
    
    //memo no   
    public WebElement addMemoNo() {
    	return driver.findElementByAccessibilityId("invoiceNoTextBox");
        }
    
    // click on ok for memo no
    public WebElement ClickOKMemoNo() {
    	return driver.findElementByAccessibilityId("PrimaryButton");
        }
    
    
    
    
    public void addDist(String distName, String prodName) throws InterruptedException {
        
    	WebDriverWait wait = new WebDriverWait(driver, 10);   
        
    	for (char c : distName.toCharArray()) {
    	    searchDist().sendKeys(String.valueOf(c));
    	    Thread.sleep(10); // slow typing
    	}

   
//        searchDist().clear();
//    	searchDist().sendKeys(distName);
//    	Thread.sleep(500);
    	wait.until(ExpectedConditions.elementToBeClickable(distSugg()));
    	distSugg().click();
    	
    	searchProd().clear();
    	searchProd().sendKeys(prodName);
    	Thread.sleep(500);
    	wait.until(ExpectedConditions.elementToBeClickable(prodSugg()));
    	prodSugg().click();
    	
    	addQty().click();
    	clickOnSaveBtn().click();
    	
    	JavaUtility ju = new JavaUtility();
    	String uniqueMemo = "MEMO" + ju.getRandomNumber();  
    	addMemoNo().sendKeys(uniqueMemo);

    	
    	//addMemoNo().sendKeys("123");
    	ClickOKMemoNo().click();
    	
    }

}
