package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class HomePage  {
	
	private WindowsDriver<WebElement> driver;
    public HomePage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //Click on open menu
//    public void clickOpenMenu() {
//    	driver.findElementByAccessibilityId("TogglePaneButton").click();
//    }
    
    public void clickOpenMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        WebElement menu = driver.findElementByAccessibilityId("TogglePaneButton");
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }


    
    //click on customer
    public void clickCustomer() {
    	driver.findElementByName("CUSTOMERS  (Alt+C) ").click();
    }
	
	//Inventory module
	public void clickInventory() {
		driver.findElementByName("INVENTORY  (Alt+I) ").click();
	}
	
	//Bills module
	public void clickBills() {
		driver.findElementByName("BILLS  (Alt+B) ").click();
	}
	
	//cart module	
	public void clickCart() {
		driver.findElementByName("CART  (Alt+H) ").click();
	}
	
	//Distributors module
	public void clickDistributor() {
		driver.findElementByName("DISTRIBUTORS  (Alt+D) ").click();
	}
	
	//Distributors module
		public void clickReports() {
			driver.findElementByName("REPORTS  (Alt+Z) ").click();
		}
	
}
