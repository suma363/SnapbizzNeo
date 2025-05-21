package inventoryModule;

import BaseClass.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryMenu_Page;
import ObjectRepository.StockPage;
import WebDriverUtility.WebDriverUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(ListenerUtility.ListenerImpClass.class)
public class Stock_Test extends BaseClass {
    WebDriverUtility wu= new WebDriverUtility();

    @Test
    public void wareHouseStock() throws InterruptedException {
        wu.waitForPageLoad(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Navigate to Inventory
        HomePage hp = new HomePage(driver);
        hp.getInventoryDrpdwn().click();

        // Step 2: Click on Catalogue module
        InventoryMenu_Page ip = new InventoryMenu_Page(driver);
        ip.getStockMdl().click();
        Thread.sleep(500);

        // Step 3: Click dropdown and select store
        StockPage sp= new StockPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(sp.getSelectStoreIdDrpdwn()));
        sp.getSelectStoreIdDrpdwn().click();
        Thread.sleep(1000);

        wu.waitForElementPresent(driver, sp.getWareHouseOption());
        wait.until(ExpectedConditions.elementToBeClickable(sp.getWareHouseOption())).click();

        String ivnCount= sp.getInventoryCount().getText();
        System.out.println("WareHouse inventory count is : "+ ivnCount);
    }

    @Test
    public void storeStock() throws InterruptedException {
        wu.waitForPageLoad(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Navigate to Inventory
        HomePage hp = new HomePage(driver);
        hp.getInventoryDrpdwn().click();

        // Step 2: Click on Catalogue module
        InventoryMenu_Page ip = new InventoryMenu_Page(driver);
        ip.getStockMdl().click();
        Thread.sleep(500);

        // Step 3: Click dropdown and select store
        StockPage sp= new StockPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(sp.getSelectStoreIdDrpdwn()));
        sp.getSelectStoreIdDrpdwn().click();
        Thread.sleep(1000);

        wu.waitForElementPresent(driver, sp.getStoreOption());
        wait.until(ExpectedConditions.elementToBeClickable(sp.getStoreOption())).click();

        String ivnCount= sp.getInventoryCount().getText();
        System.out.println("Store inventory count is : "+ ivnCount);
    }
}
