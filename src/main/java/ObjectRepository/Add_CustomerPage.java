package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Add_CustomerPage {
	
	private WindowsDriver<WebElement> driver;

    public Add_CustomerPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    public WebElement getClickAddCustomer() {
        return driver.findElementByAccessibilityId("buttonNewb");       
    }

    public WebElement getCustPhone() {
        return driver.findElementByAccessibilityId("CustomerPhone");
    }
    
    public WebElement getCustAltPhone() {
        return driver.findElementByAccessibilityId("CustomerAlternatePhone");
    }
    
    public WebElement getCustName() {
        return driver.findElementByAccessibilityId("CustomerName");
    }
    
    public WebElement getCustEmail() {   
    	return driver.findElementByAccessibilityId("CustomerEmail");
    }
    
    public WebElement getCustMemId() {
        return driver.findElementByAccessibilityId("Identifier");
    }
    
    public WebElement getDOB() {
        return driver.findElementByAccessibilityId("DateText");
    }
    
    public WebElement getCustGendor() {
        return driver.findElementByAccessibilityId("GenderPicker");
    }
    
    public WebElement getSaveBtn() {
        return driver.findElementByAccessibilityId("SubmitButton");
    }
    
//    public WebElement getCancelBtn() {
//        return driver.findElementByName("Cancel");
//    }
    
    
    
   // business logic 
    public void createCustumer( String phoneNo,String custName) {
    	getClickAddCustomer().click();
    	getCustPhone().clear();
    	getCustPhone().sendKeys(phoneNo);
    	
    	getCustName().clear();
    	getCustName().sendKeys(custName);
    	getSaveBtn().click();
    	//getCancelBtn().click();
    	
    }
    
    public void createCustumerWithMemID(  String phoneNo,String altNo,String custName, String email, String memId, String genderBtn) {
        	
    	getClickAddCustomer().click();
        	
        	getCustPhone().clear();
        	getCustPhone().sendKeys(phoneNo);
        	
        	getCustAltPhone().clear();
        	getCustAltPhone().sendKeys(altNo);
        	
        	getCustName().clear();
        	getCustName().sendKeys(custName);
        	
        	getCustEmail().clear();
        	getCustEmail().sendKeys(email);
        	
        	getCustMemId().clear();
        	getCustMemId().sendKeys(memId);
        	
        	WebElement dropdown = getCustGendor();
            dropdown.click();
            dropdown.sendKeys(genderBtn);
            dropdown.sendKeys(Keys.ENTER);
        	
        	getSaveBtn().click();
    	   	
    }   
}
