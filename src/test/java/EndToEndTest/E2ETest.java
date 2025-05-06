package EndToEndTest;

import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.BillingCartPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.Reports_Page;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class E2ETest extends BaseTest{
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	@Test
	public void addCustomers() throws Throwable {
		
	  	wu.waitForPageLoad(driver);
	  	
	  //Login to app
	  		
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
		//ac.getCancelBtn().click();
	    Thread.sleep(500); // or better: use wait for form to close
	    
	    hp.clickOpenMenu();
		hp.clickCart();
		
        String productName = eu.getDataFromExcel("productSheet", 1, 0) ;
        String customrName = eu.getDataFromExcel("customerSheet", 1, 0);

        
		BillingCartPage bp=new BillingCartPage(driver);
		bp.cartBilling(productName, customrName);
		
		hp.clickOpenMenu();
		hp.clickBills();
		hp.clickOpenMenu();
		hp.clickReports();
		
		Reports_Page rp= new Reports_Page(driver);
		rp.sales().click();
		
	}

}
