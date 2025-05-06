package ObjectRepository;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class Add_ProductsPage {
	
	private WindowsDriver<WebElement> driver;

    public Add_ProductsPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }

    public WebElement getBarcodeField() {
        return driver.findElementByAccessibilityId("BarcodeText");
    }

    public WebElement getProductNameField() {
        return driver.findElementByAccessibilityId("ProductNameTextBox");
    }

    public WebElement getShortNameField() {
        return driver.findElementByName("Short Name");
    }

    public WebElement getCategoryDropdown() {
        return driver.findElementByAccessibilityId("parentCategoryComboBox");
    }

    public WebElement getSubCategoryDropdown() {
        return driver.findElementByAccessibilityId("subCategoryComboBox");
    }

    public WebElement getPurchasePriceField() {
        return driver.findElementByName("Purchase Price");
    }

    public WebElement getMrpField() {
        return driver.findElementByName("MRP");
    }

    public WebElement getUomField() {
        return driver.findElementByAccessibilityId("UomCombobox");
    }

    public WebElement getSellingPrice1Field() {
        return driver.findElementByName("Selling Price 1");
    }

    public WebElement getHsnCodeField() {
        return driver.findElementByName("HSN Code");
    }

    public WebElement getQuickAddButton() {
        return driver.findElementByAccessibilityId("quickAdd");
    }

    public WebElement getSaveButton() {
        return driver.findElementByName("Save");
    }

    public WebElement getCancelButton() {
        return driver.findElementByName("Cancel");
    }
    
   
   /** public void typeWithRobot(String text) throws Exception {
        Robot robot = new Robot();
        for (char c : text.toCharArray()) {
            int keycode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keycode) continue;
            robot.keyPress(keycode);
            robot.keyRelease(keycode);
            Thread.sleep(50); // slight delay between keys
        }
    }

    
    public void createProducts(String barcode,String productName,  String mrp, String uom) throws Exception {
        Actions act = new Actions(driver);

        getBarcodeField().click();
        getBarcodeField().clear();
        getBarcodeField().sendKeys(barcode);
        Thread.sleep(300);

        getProductNameField().click();
        getProductNameField().clear();
        getProductNameField().sendKeys(productName);
        Thread.sleep(300);

        // MRP - use Robot to force native keystroke input
        WebElement mrpField = getMrpField();
       // mrpField.click();  // set focus
        act.doubleClick(mrpField).perform();
        Thread.sleep(300);
        typeWithRobot(mrp); // type using Robot class
        Thread.sleep(300);

        // UOM
        WebElement dropdown = getUomField();
        dropdown.click();
        dropdown.sendKeys(uom);
        dropdown.sendKeys(Keys.ENTER);

        getSaveButton().click();
    }

    
    
    
   /**public void createProducts(String barcode,String productName,  String mrp, String uom ) throws Throwable {
    	getBarcodeField().sendKeys(barcode);
    	getProductNameField().sendKeys(productName);
    	Thread.sleep(500);
    	
    	//act.moveToElement(getBarcodeField()).sendKeys(mrp);
    	
    	//getProductNameField().click();
    	///getMrpField().clear();	
		//getMrpField().sendKeys(mrp);
		
		 // MRP - force focus using Actions
	    WebElement mrpField = getMrpField();
	    Actions act= new Actions(driver);
	    act.moveToElement(mrpField).click().perform();
	    Thread.sleep(300); // Ensure focus moved
	    mrpField.clear();
	    mrpField.sendKeys(mrp);
	    System.out.println("Focused on: " + driver.switchTo().activeElement().getAttribute("Name"));


    	WebElement dropdown = driver.findElementByAccessibilityId("UomCombobox"); 
    	dropdown.click(); 
    	dropdown.sendKeys(uom);
    	dropdown.sendKeys(Keys.ENTER); // confirm selection
    	
    	getSaveButton().click();
    	
    }
    **/    
    public void createProducts( String barcode, String productName, String mrp, String uom ) throws InterruptedException {
    
        getBarcodeField().sendKeys(barcode);
        getProductNameField().sendKeys(productName);

        // Optional short wait
        Thread.sleep(500);

//        getMrpField().click();  // Ensure it gets focus
//        getMrpField().clear();
//        getMrpField().sendKeys(mrp);
//        System.out.println("MRP element: " + getMrpField().getText());
//        
        WebElement mrpField = driver.findElementByName("MRP");
        mrpField.click();
        Thread.sleep(500); // Give time to focus
        mrpField.clear();  // In case default "0" is there
        mrpField.sendKeys(Keys.CONTROL + "a"); // Select all
        mrpField.sendKeys(Keys.BACK_SPACE);    // Clear properly
        mrpField.sendKeys(mrp);                // Send MRP value



        Thread.sleep(500);  // Wait to stabilize focus

        getUomField().click();
        getUomField().sendKeys(uom);
        getUomField().sendKeys(Keys.ENTER);

        Thread.sleep(200);
        getSaveButton().click();
    }
    
    

    public void createProducts(String barcode, String productName,String purchasePrice , String mrp, String uom, String sellingPrice ) {
    	
    	getBarcodeField().sendKeys(barcode);
    	
    	getProductNameField().sendKeys(productName);
    	
    	getPurchasePriceField().clear();
    	getPurchasePriceField().sendKeys(purchasePrice);
    	
    	getMrpField().clear();
    	getMrpField().sendKeys(mrp);
    	
    	WebElement dropdown = driver.findElementByAccessibilityId("UomCombobox"); 
    	dropdown.click(); 
    	dropdown.sendKeys(uom);
    	dropdown.sendKeys(Keys.ENTER); // confirm selection
    	
    	getSellingPrice1Field().clear();
    	getSellingPrice1Field().sendKeys(sellingPrice);
    	
    	
    	getSaveButton().click();
      
  }
}
