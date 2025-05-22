package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.WebDriverUtility;

public class DashboardPage {
	
	WebDriverUtility wu= new WebDriverUtility();
	
	WebDriver driver;
	   public DashboardPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
		
		@FindBy(xpath="//div[@class='v-avatar v-theme--light v-avatar--density-default v-avatar--variant-flat me-2']")
		private WebElement profileIcon;
		
		@FindBy(xpath="//div[@class='v-sheet v-theme--light rounded-md']/descendant::*[local-name()='svg']")
		private WebElement logoutBtn;		
		
		@FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg']")
		private WebElement storeIdDropdwn;
		
		public WebElement getProfileIcon() {
			return profileIcon;
		}

		public WebElement getLogoutBtn() {
			return logoutBtn;
		}
			
		public WebElement getStoreIdDropdwn() {
			return storeIdDropdwn;
		}

		
		
		//Action to select the storeId
		public void selectStoreId() {
			//wu.waitForElementtobeClickable(driver, getStoreIdDropdwn());
			wu.mouseMoveOnElement(driver, storeIdDropdwn);
			storeIdDropdwn.click();
			storeIdDropdwn.sendKeys("1");
		}
		
		//Action for logout
				public void logout() {
					profileIcon.click();
					wu.waitForElementTobeClickable(driver, logoutBtn);
					logoutBtn.click();
				}
	
		
}
