package ObjectRepository;


import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.WebElement;

import FileUtility.FileUtility;


public class LoginPage {

    private WindowsDriver<WebElement> driver;
    FileUtility fu= new FileUtility();
    

    public LoginPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }

	public WindowsDriver<WebElement> getDriver() {
		return driver;
	}
	
	 public WebElement getUsernameField() {
		return driver.findElementByAccessibilityId("userName");
   
		 
	    }

	    public WebElement getPasswordField() {
	        return driver.findElementByAccessibilityId("password");
	    }

	    public WebElement getEyeIcon() {
	        return driver.findElementByAccessibilityId("RevealButton");
	    }

	    public WebElement getOkButton() {
	        return driver.findElementByClassName("Button");
	    }

	    public WebElement getCreateNewSessionButton() {
	        return driver.findElementByAccessibilityId("PrimaryButton");
	    }

	    public WebElement getContinueButton() {
	        return driver.findElementByAccessibilityId("continueButton");
	    }

	    public WebElement getSubmitButton() {
	        return driver.findElementByAccessibilityId("Submit");
	    }

    
	public void loginToApp() throws InterruptedException, Throwable {   
		String USERNAME = fu.getDataFromPropertiesFile( "username");
		String PASSWORD = fu.getDataFromPropertiesFile("password");
		
        getUsernameField().sendKeys(USERNAME);
        getPasswordField().clear();
        getPasswordField().sendKeys(PASSWORD);
        getEyeIcon().click();
        getOkButton().click();
       // getCreateNewSessionButton().click();
       // getContinueButton().click();
        Thread.sleep(500);
        getSubmitButton().click();
        Thread.sleep(1000);
        
        System.out.println("Logged in successfully");
	}    
}

	

