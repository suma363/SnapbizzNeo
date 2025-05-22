package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseEntryMenu_Page {
	
	WebDriver driver;
	   public PurchaseEntryMenu_Page(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
	      
		@FindBy(xpath="//div[text()='Create Purchase']")
		private WebElement createPurchaseEntryMdl;
		
		@FindBy(xpath="//div[text()='Purchase Entry List']")
		private WebElement purchaseEntryListMdl;

		public WebElement getCreatePurchaseEntryMdl() {
			return createPurchaseEntryMdl;
		}

		public WebElement getPurchaseEntryListMdl() {
			return purchaseEntryListMdl;
		}
		
		

}
