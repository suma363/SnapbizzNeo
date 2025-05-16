package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	   public HomePage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
		
		@FindBy(xpath="//ancestor::a[@class='v-list-item v-list-item--active v-list-item--link v-theme--light text-primary v-list-item--density-default v-list-item--one-line v-list-item--rounded v-list-item--variant-text']")
		private WebElement dashboardMdl;
		
		@FindBy(xpath="//div[text()='Inventory']")
		private WebElement inventoryDrpdwn;
		
		@FindBy(xpath="//div[@class='v-list-group v-list-group--prepend leftPadding']/descendant::div[text()='Purchase Entry']")
		private WebElement purchaseEntryDrpdwn;
		
		@FindBy(xpath="//div[text()='Stock Transfer']/ancestor::div[@class='v-list-group v-list-group--prepend leftPadding']")
		private WebElement stockTransferDrpdwn;

		public WebElement getDashboardMdl() {
			return dashboardMdl;
		}

		public WebElement getInventoryDrpdwn() {
			return inventoryDrpdwn;
		}

		public WebElement getPurchaseEntryDrpdwn() {
			return purchaseEntryDrpdwn;
		}

		public WebElement getStockTransferDrpdwn() {
			return stockTransferDrpdwn;
		}		
		
}