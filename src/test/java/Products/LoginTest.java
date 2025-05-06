package Products;

import ObjectRepository.LoginPage;

import org.testng.annotations.Test;

import BaseClass.BaseTest;

	public class LoginTest extends BaseTest {

	   @Test
	    public void testLogin() throws Throwable, Throwable { 
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp();       
	    }
	}



