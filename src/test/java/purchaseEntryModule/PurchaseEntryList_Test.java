package purchaseEntryModule;

import BaseClass.BaseClass;
import FileUtility.ExcelUtility;
import ObjectRepository.HomePage;
import ObjectRepository.PurchaseEntryList_Page;
import ObjectRepository.PurchaseEntryMenu_Page;
import WebDriverUtility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PurchaseEntryList_Test extends BaseClass {

    WebDriverUtility wu = new WebDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    JavaUtility ju = new JavaUtility();

    @Test
    public void purchaseEntryListInWareHouse() throws Throwable {
        wu.waitForPageLoad(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Step 1: Navigate to purchase entry module
        HomePage hp = new HomePage(driver);
        hp.getPurchaseEntryDrpdwn().click();

        // Step 2: Create purchase entry
        PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
        pp.getPurchaseEntryListMdl().click();

        PurchaseEntryList_Page purEntryListPage = new PurchaseEntryList_Page(driver);
        wu.waitForElementTobeClickable(driver, purEntryListPage.getSelectStoreIdDrpdwn());
        purEntryListPage.getSelectStoreIdDrpdwn().click();

        wu.waitForElementPresent(driver, purEntryListPage.getWareHouseOption());
        wu.waitForElementTobeClickable(driver, purEntryListPage.getWareHouseOption());
        purEntryListPage.getWareHouseOption().click();
        Thread.sleep(1000);

        //Capture All orders
        String allOrdersCount = purEntryListPage.getAllOrdersCount().getText().trim();
        System.out.println("All orders count in warehouse is : " + allOrdersCount);

        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement row : rows) {
            String invoiceNumber = row.findElement(By.xpath("td[1]")).getText();
            String storeName = row.findElement(By.xpath("td[2]")).getText();
            String status = row.findElement(By.xpath("td[4]")).getText();

            System.out.println("Invoice: " + invoiceNumber +
                    ", Store: " + storeName +
                    ", Status: " + status);
        }

        //To capture new orders
        String newOrdersCount = purEntryListPage.getNewOrdersCount().getText().trim();
        System.out.println("New orders count in warehouse is : " + newOrdersCount);

        purEntryListPage.getNewOrdersCount().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table tbody tr")));

        // Step 3: Capture data
        List<WebElement> rowsNewOrd = driver.findElements(By.cssSelector("table tbody tr"));

        for (WebElement row : rowsNewOrd) {
            String invoiceNumber = row.findElement(By.xpath("td[1]")).getText();
            String storeName = row.findElement(By.xpath("td[2]")).getText();
            String status = row.findElement(By.xpath("td[4]")).getText();

            System.out.println("Invoice: " + invoiceNumber +
                    ", Store: " + storeName +
                    ", Status: " + status);
        }
    }

        @Test
        public void purchaseEntryListInStore() throws Throwable {
            wu.waitForPageLoad(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Step 1: Navigate to purchase entry module
            HomePage hp = new HomePage(driver);
            hp.getPurchaseEntryDrpdwn().click();

            // Step 2: Create purchase entry
            PurchaseEntryMenu_Page pp = new PurchaseEntryMenu_Page(driver);
            pp.getPurchaseEntryListMdl().click();

            PurchaseEntryList_Page purEntryListPage= new PurchaseEntryList_Page(driver);
            wu.waitForElementTobeClickable(driver, purEntryListPage.getSelectStoreIdDrpdwn());
            purEntryListPage.getSelectStoreIdDrpdwn().click();

            wu.waitForElementPresent(driver, purEntryListPage.getStoreOption());
            wu.waitForElementTobeClickable(driver, purEntryListPage.getStoreOption());
            purEntryListPage.getStoreOption().click();
            Thread.sleep(1000);

            //Capture All orders
            String allOrdersCount = purEntryListPage.getAllOrdersCount().getText().trim();
            System.out.println("All orders count in warehouse is : "+ allOrdersCount);

            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
            for (WebElement row : rows) {
                String invoiceNumber = row.findElement(By.xpath("td[1]")).getText();
                String storeName = row.findElement(By.xpath("td[2]")).getText();
                String status = row.findElement(By.xpath("td[4]")).getText();

                System.out.println("Invoice: " + invoiceNumber +
                        ", Store: " + storeName +
                        ", Status: " + status);
            }

            //To capture new orders
            String newOrdersCount = purEntryListPage.getNewOrdersCount().getText().trim();
            System.out.println("New orders count in warehouse is : "+ newOrdersCount);

            purEntryListPage.getNewOrdersCount().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table tbody tr")));

           // Capture data
            List<WebElement> rowsNewOrd = driver.findElements(By.cssSelector("table tbody tr"));

            for (WebElement row : rowsNewOrd) {
                String invoiceNumber = row.findElement(By.xpath("td[1]")).getText();
                String storeName = row.findElement(By.xpath("td[2]")).getText();
                String status = row.findElement(By.xpath("td[4]")).getText();

                System.out.println("Invoice: " + invoiceNumber +
                        ", Store: " + storeName +
                        ", Status: " + status);
            }
    }
}
