package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockTransfer_Page {
    WebDriver driver;

    public StockTransfer_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//ancestor::div[@class='v-input__control']/descendant::*[local-name()='svg']")
    private WebElement selectStoreIdDrpdwn;

    @FindBy(xpath="//div[contains(text(),'92793-Suma test store')]")
    private WebElement storeOption;

    @FindBy(xpath="//div[contains(text(),'Warehouse')]")
    private WebElement wareHouseOption;

    @FindBy(xpath="//span[text()=' Create New Stock Transfer']/ancestor::button")
    private WebElement createNewStockTransfer;


    public WebElement getSelectStoreIdDrpdwn() {
        return selectStoreIdDrpdwn;
    }

    public WebElement getStoreOption() {
        return storeOption;
    }

    public WebElement getWareHouseOption() {
        return wareHouseOption;
    }

    public WebElement getCreateNewStockTransfer() {
        return createNewStockTransfer;
    }
}
