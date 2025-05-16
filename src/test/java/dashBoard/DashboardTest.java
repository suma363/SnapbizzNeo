package dashBoard;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.DashboardPage;
import WebDriverUtility.WebDriverUtility;

public class DashboardTest extends BaseClass{
	
	@Test
	public void selectstoreId() throws Throwable {
		WebDriverUtility wu= new WebDriverUtility();
		DashboardPage dp=new DashboardPage(driver);
		
		wu.waitForPageLoad(driver);
		dp.selectStoreId();
		
	}
}
