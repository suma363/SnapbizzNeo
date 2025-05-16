package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockTransferMenu_Page {
	
	WebDriver driver;	   
	   public StockTransferMenu_Page(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
	      
		@FindBy(xpath="//a[@href='/stock-transfer/']")
		private WebElement stockTransferMdl;
		
		@FindBy(xpath="//div[text()='Sales Invoice']")
		private WebElement salesInvoiceMdl;
		
		

}
