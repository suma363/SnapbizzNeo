package ObjectRepository;

import WebDriverUtility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreatePurchase_Page {
    WebDriver driver;
    WebDriverUtility wu= new WebDriverUtility();
    public CreatePurchase_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg']")
    private WebElement selectStoreIdDrpdwn;

    @FindBy(xpath="//div[contains(text(),'92793-Suma test store')]")
    private WebElement storeOption;

    @FindBy(xpath="//div[contains(text(),'Warehouse')]")
    private WebElement wareHouseOption;

    @FindBy(xpath="//label[text()='Tag Distributor']/ancestor::div[@class='v-field__field']/descendant::input")
    private WebElement tagDistDrpDwn;

    @FindBy(xpath="//span[text()='Yes']")
    private WebElement AddDistPopupYes;

    @FindBy(xpath="//span[text()='No']")
    private WebElement AddDistPopupNo;

    @FindBy(xpath="//input[@placeholder='Enter Invoice Number']")
    private WebElement invoiceNum;

    @FindBy(xpath="//input[@placeholder='DD/MM/YYYY']")
    private WebElement invoiceDate;

    public void selectTodayDate() {
        JavaUtility ju = new JavaUtility();
        String today = ju.getTodayDayOfMonth();
        String dynamicXpath = "//span[text()='" + today + "']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement todayDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", todayDateElement);

        // Optionally wait a moment after scroll
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Try normal click
        try {
            todayDateElement.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click if normal click fails
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", todayDateElement);
        }
    }

    @FindBy(xpath="//label[text()='Search by Barcode']/following-sibling::div/descendant::input")
    private WebElement searchByBarcode;

    @FindBy(xpath="//label[text()='Search by Product Name']/following-sibling::div/descendant::input")
    private WebElement searchByProdName;

    @FindBy(xpath="//input[@size='1' and @value='1']")
    private WebElement prodQty;

    @FindBy(xpath="//div[@class='v-field v-field--center-affix v-field--no-label v-field--variant-outlined v-theme--light rounded-lg v-locale--is-ltr']//input")
    private WebElement purPrice;

    @FindBy(xpath="//div[@class='v-field v-field--active v-field--center-affix v-field--dirty v-field--no-label v-field--variant-outlined v-theme--light rounded-lg v-locale--is-ltr']//input[@size='1' and @value='0']")
    private WebElement sellingPrice;

    @FindBy(xpath="//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--no-label v-field--variant-outlined v-theme--light rounded-lg v-locale--is-ltr']//input")
    private WebElement gstDrpDwn;

    @FindBy(xpath="//input[@max='100' and  @class='v-field__input']")
    private WebElement flatDisc;

    @FindBy(xpath="//input[@name='radio-group-101' and @aria-label='Inclusive GST']")
    private WebElement includeGst;

    @FindBy(xpath="//input[@name='radio-group-101' and @aria-label='Exclusive GST']")
    private WebElement excludeGst;

    @FindBy(xpath="//span[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath="//span[text()='Print & Send']/ancestor::button")
    private WebElement printAndSave;

    @FindBy(xpath="//p[text()='Net Amount:']/ancestor::div[@class='v-list-item v-theme--light v-list-item--density-compact v-list-item--one-line rounded-0 v-list-item--variant-text px-0']/descendant::p[2]")
    private WebElement netAmount;

    public WebElement getNetAmount() {
        return netAmount;
    }

    public WebElement getSelectStoreIdDrpdwn() {
        return selectStoreIdDrpdwn;
    }

    public WebElement getStoreOption() {
        return storeOption;
    }

    public WebElement getWareHouseOption() {
        return wareHouseOption;
    }

    public WebElement getTagDistDrpDwn() {
        return tagDistDrpDwn;
    }

    public WebElement getAddDistPopupYes() {
        return AddDistPopupYes;
    }

    public WebElement getAddDistPopupNo() {
        return AddDistPopupNo;
    }

    public WebElement getInvoiceNum() {
        return invoiceNum;
    }

    public WebElement getInvoiceDate() {
        return invoiceDate;
    }

    public WebElement getSearchByBarcode() {
        return searchByBarcode;
    }

    public WebElement getSearchByProdName() {
        return searchByProdName;
    }

    public WebElement getProdQty() {
        return prodQty;
    }

    public WebElement getPurPrice() {
        return purPrice;
    }

    public WebElement getSellingPrice() {
        return sellingPrice;
    }


    public WebElement getGstDrpDwn() {
        return gstDrpDwn;
    }

    public WebElement getFlatDisc() {
        return flatDisc;
    }

    public WebElement getIncludeGst() {
        return includeGst;
    }

    public WebElement getExcludeGst() {
        return excludeGst;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getPrintAndSave() {
        return printAndSave;
    }
}
