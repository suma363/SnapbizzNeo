package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{   //Rule 1
	
	
	//  Rule 2
	WebDriver driver;
   public LoginPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
	
	@FindBy(id="input-0")
	private WebElement emailTxtField;
	
	@FindBy(id="input-2")
	private WebElement passwordTxtField;
	
	@FindBy(xpath="//button[@class='v-btn v-btn--block v-theme--light bg-primary v-btn--density-default rounded-md v-btn--size-large v-btn--variant-flat mt-5 mb-0' ]")
	private WebElement loginbtn;
	

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	/**
	 * login into aplication based on email , password, url arguements
	 * 
	 * @param url
	 * @param email
	 * @param password
	 */
	
   //Provide an action
	
	public void loginToApp(String url , String username, String password) {
		
		waitForPageLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		emailTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginbtn.click();
	}

}
