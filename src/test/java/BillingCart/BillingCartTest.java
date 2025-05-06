package BillingCart;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.BillingCartPage;
import ObjectRepository.HomePage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;


public class BillingCartTest extends BaseTest{
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
		
	@Test
	public void billingCart() throws Throwable {
	
  	wu.waitForPageLoad(driver);
	
	//Navigate to billing cart module 
	HomePage hp= new HomePage(driver);
	hp.clickOpenMenu();
	hp.clickCart();
	
    String productName = eu.getDataFromExcel("productSheet", 1, 0);
    String custName = eu.getDataFromExcel("customerSheet", 1, 0);

    
	BillingCartPage bp = new BillingCartPage(driver);
	bp.cartBilling(productName, custName);	
	hp.clickOpenMenu();
	hp.clickBills();
	
	}
}
