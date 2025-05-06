package Distributors;

import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_DistributorPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddDistributor_Test extends BaseTest {
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	
	@Test
	public void addDistributors() throws Throwable {	
  	wu.waitForPageLoad(driver);
  	
	//login to app
	
	//Navigate to inventory module and click on add products
	HomePage hp= new HomePage(driver);
	hp.clickOpenMenu();
	hp.clickDistributor();
	
	Add_DistributorPage ad= new Add_DistributorPage(driver);	
	int rowCount = eu.getRowCount("distributorSheet");

	for (int i = 1; i <= rowCount; i++) { // skip row 0 (header)
	    String DistName = eu.getDataFromExcel("distributorSheet", i, 0) + ju.getRandomNumber();
	    String phoneNo = eu.getDataFromExcel("distributorSheet", i, 1) + ju.getRandomNumber();

	    ad.addDistributors(phoneNo, DistName);
	    }
    Thread.sleep(500); // or better: use wait for form to close
    
    hp.clickOpenMenu();
    
	
	
	}

}
