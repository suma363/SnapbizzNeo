package ObjectRepository;

import WebDriverUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDistributors_Page {

    WebDriver driver;
    WebDriverUtility wu = new WebDriverUtility();

    public AddDistributors_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    private WebElement nameTxtBox;

    @FindBy(name = "number")
    private WebElement phnNoTxtBox;

    @FindBy(name = "address")
    private WebElement addressTxtBox;

    @FindBy(name = "gstin")
    private WebElement gstNoTxtBox;

    @FindBy(name = "email")
    private WebElement emailTxtBox;

    @FindBy(name = "landLine")
    private WebElement landLineNoTxtBox;

    @FindBy(xpath = "//span[text()='Cancel ']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//span[text()='Add ']")
    private WebElement addBtn;

    public WebElement getNameTxtBox() {
        return nameTxtBox;
    }

    public WebElement getPhnNoTxtBox() {
        return phnNoTxtBox;
    }

    public WebElement getAddressTxtBox() {
        return addressTxtBox;
    }

    public WebElement getGstNoTxtBox() {
        return gstNoTxtBox;
    }

    public WebElement getLandLineNoTxtBox() {
        return landLineNoTxtBox;
    }

    public WebElement getEmailTxtBox() {
        return emailTxtBox;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public void addDistributor(String name,String phnNo,String address,String gst){
        getNameTxtBox().sendKeys(name);
        getPhnNoTxtBox().sendKeys(phnNo);
        getAddressTxtBox().sendKeys(address);
        getGstNoTxtBox().sendKeys(gst);
        getAddBtn().click();
    }

    public void addDistributorWithAllDetails(String name,String phnNo,String address,String gst, String landLine, String email){
        getNameTxtBox().sendKeys(name);
        getPhnNoTxtBox().sendKeys(phnNo);
        getAddressTxtBox().sendKeys(address);
        getGstNoTxtBox().sendKeys(gst);
        getLandLineNoTxtBox().sendKeys(landLine);
        getEmailTxtBox().sendKeys(email);
        getAddBtn().click();
    }
}
