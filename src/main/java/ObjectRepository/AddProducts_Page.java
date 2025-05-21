package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.WebDriverUtility;

public class AddProducts_Page {

	WebDriver driver;

	WebDriverUtility wu = new WebDriverUtility();

	public AddProducts_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@tabindex='1' and @class='v-field__input']")
	private WebElement barcodeTxtBox;

	@FindBy(xpath = "//input[@tabindex='2' and @class='v-field__input']")
	private WebElement mrpTxtBox;

	@FindBy(xpath = "//input[@tabindex='3' and @class='v-field__input']")
	private WebElement productNameTxtBox;

	@FindBy(xpath = "//input[@tabindex='7' and @class='v-field__input']")
	private WebElement purchasePriceTxtBox;

	@FindBy(xpath = "//input[@tabindex='12']")
	private WebElement uomDropDown;

	@FindBy(xpath = "//input[@tabindex='4' and @class='v-field__input']")
	private WebElement SP1TxtBox;

	@FindBy(xpath = "//input[@tabindex='5' and @class='v-field__input']")
	private WebElement qtyTxtBox;

	@FindBy(xpath = "//input[@tabindex='5' and @class='v-field__input']")
	private WebElement gstDropDown;

	@FindBy(xpath = "//input[@tabindex='9']")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//input[@tabindex='10']")
	private WebElement subCatDropDown;

	@FindBy(xpath = "//span[text()='Add ']")
	private WebElement addBtn;

	@FindBy(xpath = "//span[text()='Cancel ']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//span[text()='Update ']")
	private WebElement UpdateBtn;

	public WebElement getBarcodeTxtBox() {
		return barcodeTxtBox;
	}

	public WebElement getMrpTxtBox() {
		return mrpTxtBox;
	}

	public WebElement getProductNameTxtBox() {
		return productNameTxtBox;
	}

	public WebElement getPurchasePriceTxtBox() {
		return purchasePriceTxtBox;
	}

	public WebElement getUomDropDown() {
		return uomDropDown;
	}

	public WebElement getSP1TxtBox() {
		return SP1TxtBox;
	}

	public WebElement getQtyTxtBox() {
		return qtyTxtBox;
	}

	public WebElement getGstDropDown() {
		return gstDropDown;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubCatDropDown() {
		return subCatDropDown;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	// Action
	public void addProduct(String barcode, String mrp, String prodName, String purPrice, String uom, String SP1,
			String qty, String gst, String catogory, String subCat) throws Throwable {

		getBarcodeTxtBox().sendKeys(barcode);
		
		getMrpTxtBox().click();
		Thread.sleep(300);
		getMrpTxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		getMrpTxtBox().sendKeys(mrp);

		getProductNameTxtBox().clear();
		getProductNameTxtBox().sendKeys(prodName);

		getPurchasePriceTxtBox().click();
		getPurchasePriceTxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		getPurchasePriceTxtBox().sendKeys(purPrice);

		getUomDropDown().click();
		getUomDropDown().sendKeys(uom);
		getUomDropDown().sendKeys(Keys.ENTER);

		getSP1TxtBox().click();
		getSP1TxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);;
		getSP1TxtBox().sendKeys(SP1);

		getQtyTxtBox().click();
		getQtyTxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);;
		getQtyTxtBox().sendKeys(qty);

		getGstDropDown().click();;
		getGstDropDown().sendKeys(gst);
		getGstDropDown().sendKeys(Keys.ENTER);

		getCategoryDropDown().click();
		getCategoryDropDown().sendKeys(catogory);
		getCategoryDropDown().sendKeys(Keys.ENTER);

		getSubCatDropDown().click();
		getSubCatDropDown().sendKeys(subCat);
		getSubCatDropDown().sendKeys(Keys.ENTER);

		getAddBtn().click();

	}

}
