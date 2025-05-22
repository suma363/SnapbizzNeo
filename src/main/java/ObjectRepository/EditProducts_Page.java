package ObjectRepository;

import WebDriverUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProducts_Page {
    WebDriver driver;

    WebDriverUtility wu = new WebDriverUtility();

    public EditProducts_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@tabindex='1' and @class='v-field__input']")
    private WebElement mrpTxtBox;

    @FindBy(xpath = "//input[@tabindex='2' and @class='v-field__input']")
    private WebElement sp1TxtBox;

    @FindBy(xpath = "//input[@tabindex='3' and @class='v-field__input']")
    private WebElement prodNameTxtBox;

    @FindBy(xpath = "//input[@tabindex='4' and @class='v-field__input']")
    private WebElement sp2TxtBox;

    @FindBy(xpath = "//input[@tabindex='5' and @class='v-field__input']")
    private WebElement qtyTxtBox;

    @FindBy(xpath = "//input[@tabindex='6' and @class='v-field__input']")
    private WebElement sp3TxtBox;

    @FindBy(xpath = "//input[@tabindex='7' and @class='v-field__input']")
    private WebElement purPriceTxtBox;

    @FindBy(xpath = "//input[@tabindex='8']")
    private WebElement subCatDropDown;

    @FindBy(xpath = "//input[@tabindex='9']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//input[@tabindex='10']")
    private WebElement uomDropDown;

    @FindBy(xpath = "//input[@tabindex='11']")
    private WebElement gstDropDown;

    @FindBy(xpath = "//span[text()='Update ']")
    private WebElement updateBtn;

    @FindBy(xpath = "//span[text()='Cancel ']")
    private WebElement cancelBtn;


    public WebDriverUtility getWu() {
        return wu;
    }

    public WebElement getMrpTxtBox() {
        return mrpTxtBox;
    }

    public WebElement getSp1TxtBox() {
        return sp1TxtBox;
    }

    public WebElement getProdNameTxtBox() {
        return prodNameTxtBox;
    }

    public WebElement getSp2TxtBox() {
        return sp2TxtBox;
    }

    public WebElement getQtyTxtBox() {
        return qtyTxtBox;
    }

    public WebElement getSp3TxtBox() {
        return sp3TxtBox;
    }

    public WebElement getPurPriceTxtBox() {
        return purPriceTxtBox;
    }

    public WebElement getSubCatDropDown() {
        return subCatDropDown;
    }

    public WebElement getCategoryDropDown() {
        return categoryDropDown;
    }

    public WebElement getUomDropDown() {
        return uomDropDown;
    }

    public WebElement getGstDropDown() {
        return gstDropDown;
    }

    public WebElement getUpdateBtn() {
        return updateBtn;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getUpdatedMrpByBarcode(String barcode) {
        String xpath = "//td[text()='" + barcode + "']/following-sibling::td[10]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getUpdatedSp1ByBarcode(String barcode) {
        String xpath = "//td[text()='" + barcode + "']/following-sibling::td[12]";
        return driver.findElement(By.xpath(xpath));
    }


    //Edit mrp and sp1
    public void editMrpAndSp1(String upMrp, String upSp1){

        getMrpTxtBox().click();
        getMrpTxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
         getMrpTxtBox().sendKeys(upMrp);

         getSp1TxtBox().click();
         getSp1TxtBox().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
         getSp1TxtBox().sendKeys(upSp1);

         wu.waitForElementTobeClickable(driver, getUpdateBtn());
         getUpdateBtn().click();
    }

}
