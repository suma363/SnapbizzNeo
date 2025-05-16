package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryMenu_Page {
	WebDriver driver;
	   public InventoryMenu_Page(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
		
		@FindBy(xpath="//div[text()='Stock']")
		private WebElement stockMdl;
		
		@FindBy(xpath="//div[text()='Catalogue']")
		private WebElement catalogueMdl;
		
		@FindBy(xpath="//div[text()='Upload New Products']")
		private WebElement uploadNewProductsMdl;
		public WebElement getStockMdl() {
			return stockMdl;
		}

		public WebElement getCatalogueMdl() {
			return catalogueMdl;
		}

		public WebElement getUploadNewProductsMdl() {
			return uploadNewProductsMdl;
		}
		
		
		
}
