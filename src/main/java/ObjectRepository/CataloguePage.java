package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage {

	WebDriver driver;
	   
	   public CataloguePage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
	      
		@FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg']")
		private WebElement selectStoreIdDrpdwn;

		@FindBy(xpath="//div[contains(text(),'92793-Suma test store')]")
		private WebElement storeOption;
		
		@FindBy(xpath="//div[contains(text(),'Warehouse')]")
		private WebElement wareHouseOption;
		
		@FindBy(xpath="//span[.=' Add Product']")
		private WebElement addProductBtn;
		
		@FindBy(xpath = "//h4[@class='text-h4 mb-4']")
		private WebElement inventoryCount;
		
		@FindBy(xpath = "//input[@class='v-field__input']")
		private WebElement searchProduct;

		@FindBy(xpath = "//*[local-name()='svg'  and @class='pc-icon primary']")
		private WebElement editProdBtn;

		@FindBy(xpath = "//span[text()='Delete ']")
		private WebElement confDelProdBtn;


	public WebElement getDeleteBtn(String barcode) {
		String xpath="//td[text()='"+barcode+"']/ancestor::tr/descendant::*[local-name()='svg' and @class='pc-icon']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getEditProdBtn() {
		return editProdBtn;
	}

	public WebElement getConfDelProdBtn() {
		return confDelProdBtn;
	}

	public WebElement getWareHouseOption() {
			return wareHouseOption;
		}

		public WebElement getStoreOption() {
		    return storeOption;
		}

		public WebElement getSelectStoreIdDrpdwn() {
			return selectStoreIdDrpdwn;
		}

		public WebElement getAddProductBtn() {
			return addProductBtn;
		}

		public WebElement getInventoryCount() {
			return inventoryCount;
		}

		public WebElement getSearchProduct() {
			return searchProduct;
		}



}
