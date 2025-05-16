package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockPage {

	   WebDriver driver;
	   
	   public StockPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
	      
		@FindBy(id="input-203")
		private WebElement selectStoreIdDrpdwn;
}
