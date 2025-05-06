package Customers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddCustomer_Test extends BaseTest {
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	
	@Test
	public void addCustomers() throws Throwable {
	
  	wu.waitForPageLoad(driver);
  	
	//login to app
  	
	//Navigate to inventory module and click on add products
	HomePage hp= new HomePage(driver);
	hp.clickOpenMenu();
	hp.clickCustomer();
	
	Add_CustomerPage ac = new Add_CustomerPage(driver);
	int rowCount = eu.getRowCount("customerSheet");

	for (int i = 1; i <= rowCount; i++) { // skip row 0 (header)
	    String custName = eu.getDataFromExcel("customerSheet", i, 0) + ju.getRandomNumber();
	    String custPhone = eu.getDataFromExcel("customerSheet", i, 1) + ju.getRandomNumber();

	    ac.createCustumer(custPhone, custName);
	    }
	
    hp.clickOpenMenu();
    
   }
    
   /** @Test
    public void addCustomerWithMoreInformation() throws Throwable {  	
      	wu.waitForPageLoad(driver);
      	
    	//login to app
    	LoginPage lp= new LoginPage(driver);
    	lp.loginToApp();
    	
    	//Navigate to inventory module and click on add products
    	HomePage hp= new HomePage(driver);
    	hp.clickOpenMenu();
    	hp.clickCustomer();
    	
    	
    	
    	 // Read row count
        int rowCount = eu.getRowCount("customerSheet");

        for (int i = 1; i <= rowCount; i++) {  // Skip header (row 0)
            String custName = eu.getDataFromExcel("customerSheet", i, 0) + ju.getRandomNumber();
            String custPhone = eu.getDataFromExcel("customerSheet", i, 1) + ju.getRandomNumber();
            String custAltPhone = eu.getDataFromExcel("customerSheet", i, 2) + ju.getRandomNumber();
            String email = eu.getDataFromExcel("customerSheet", i, 3) ;
            String memId = eu.getDataFromExcel("customerSheet", i, 4) + ju.getRandomNumber();
            String Gender = eu.getDataFromExcel("customerSheet", i, 5);

            Add_CustomerPage ac = new Add_CustomerPage(driver);
            ac.createCustumerWithMemID(custPhone, custAltPhone, custName, email, memId, Gender);
            
         // Optional: add a short delay to avoid overlap
            Thread.sleep(1000);
            
        }**/
	
	@Test
	public void addCustomerWithMoreInformation() throws Throwable {  	
	    wu.waitForPageLoad(driver);

	    // Login to app
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp();

	    // Navigate to customer module
	    HomePage hp = new HomePage(driver);
	    hp.clickOpenMenu();
	    hp.clickCustomer();

	    // Read row count
	    int rowCount = eu.getRowCount("customerSheet");

	    Add_CustomerPage ac = new Add_CustomerPage(driver);

	    for (int i = 1; i <= rowCount; i++) {  // Skip header (row 0)

	        // Wait for Add Customer button to be visible and clickable
	        for (int retry = 0; retry < 5; retry++) {
	            try {
	                WebElement addBtn = ac.getClickAddCustomer();
	                if (addBtn.isDisplayed() && addBtn.isEnabled()) {
	                    System.out.println("Clicking 'Add Customer' button for entry: " + i);
	                    addBtn.click();
	                    break;
	                }
	            } catch (Exception e) {
	                Thread.sleep(500); // Wait before retry
	            }
	        }

	        // Fetch data from Excel
	        String custName = eu.getDataFromExcel("customerSheet", i, 0) + ju.getRandomNumber();
	        String custPhone = eu.getDataFromExcel("customerSheet", i, 1) + ju.getRandomNumber();
	        String custAltPhone = eu.getDataFromExcel("customerSheet", i, 2) + ju.getRandomNumber();
	        String email = eu.getDataFromExcel("customerSheet", i, 3);
	        String memId = eu.getDataFromExcel("customerSheet", i, 4) + ju.getRandomNumber();
	        String Gender = eu.getDataFromExcel("customerSheet", i, 5);

	        // Fill customer data and submit
	        ac.getCustPhone().clear();
	        ac.getCustPhone().sendKeys(custPhone);

	        ac.getCustAltPhone().clear();
	        ac.getCustAltPhone().sendKeys(custAltPhone);

	        ac.getCustName().clear();
	        ac.getCustName().sendKeys(custName);

	        ac.getCustEmail().clear();
	        ac.getCustEmail().sendKeys(email);

	        ac.getCustMemId().clear();
	        ac.getCustMemId().sendKeys(memId);

	        WebElement dropdown = ac.getCustGendor();
	        dropdown.click();
	        dropdown.sendKeys(Gender);
	        dropdown.sendKeys(Keys.ENTER);

	        ac.getSaveBtn().click();

	        System.out.println("Customer saved: " + custName + ", Phone: " + custPhone);

	        // Wait for UI to return to customer list view
	        Thread.sleep(1500);
	    }
	}
}

