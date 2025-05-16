package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UploadNewProductsPage {
	WebDriver driver;
	
	   public UploadNewProductsPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	   }
	      
		@FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg' and @class='v-icon__svg']")
		private WebElement selectStoreIdDrpdwn;
			

		@FindBy(xpath="//div[contains(text(),'92793-Suma test store')]")
		private WebElement storeOption;

		public WebElement getStoreOption() {
		    return storeOption;
		}

		
		@FindBy(xpath="//div[@class='v-responsive__sizer']/ancestor::div[@class='v-card-item']")
		private WebElement uploadFile;
		
		
		@FindBy(xpath = "//input[@type='file']")
		private WebElement fileUploadInput;
		
		@FindBy(xpath = "//h4[contains(text(), 'Upload CSV File')]")
		private WebElement uploadCsvFileBtn;
		
		

		public WebElement getUploadCsvFileBtn() {
			return uploadCsvFileBtn;
		}


		public WebElement getFileUploadInput() {
		    return fileUploadInput;
		}

		public WebElement getSelectStoreIdDrpdwn() {
			return selectStoreIdDrpdwn;
		}


		public WebElement getUploadFile() {
			return uploadFile;
		}
		
	

}
