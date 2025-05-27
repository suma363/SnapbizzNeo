package ObjectRepository;

import WebDriverUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseEntryList_Page {
    WebDriver driver;

    WebDriverUtility wu = new WebDriverUtility();

    public PurchaseEntryList_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg']")
    private WebElement selectStoreIdDrpdwn;

    @FindBy(xpath="//div[contains(text(),'92793-Suma test store')]")
    private WebElement storeOption;

    @FindBy(xpath="//div[contains(text(),'Warehouse')]")
    private WebElement wareHouseOption;

    @FindBy(xpath="//span[text()='All Orders ']//ancestor::span[@class='v-btn__content']//descendant::div[@class='v-chip__content']")
    private WebElement allOrdersCount;

    @FindBy(xpath="//span[text()='New Orders ']//ancestor::span[@class='v-btn__content']//descendant::div[@class='v-chip__content']")
    private WebElement newOrdersCount;

    public WebElement getSelectStoreIdDrpdwn() {
        return selectStoreIdDrpdwn;
    }

    public WebElement getStoreOption() {
        return storeOption;
    }

    public WebElement getWareHouseOption() {
        return wareHouseOption;
    }

    public WebElement getAllOrdersCount() {
        return allOrdersCount;
    }

    public WebElement getNewOrdersCount() {
        return newOrdersCount;
    }
}
