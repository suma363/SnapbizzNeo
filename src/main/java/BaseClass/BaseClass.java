package BaseClass;

import java.io.IOException;
import java.sql.SQLException;

import ObjectRepository.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import WebDriverUtility.UtilityClassObject;
import DataBaseUtility.DataBaseClass;
import FileUtility.ExcelUtility;
import FileUtility.FileUtility;
import ObjectRepository.LoginPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class BaseClass {
		/*Create Object */
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
	    public DataBaseClass dbLib = new DataBaseClass();
	    public WebDriver driver = null;
	    public static WebDriver sdriver = null; // if it is non static batch execution is not possible
	  
				
		@BeforeSuite(groups = {"smokeTest", "regressionTest"})
		public void configBS() throws SQLException {
			System.out.println("=== Report Config ====");
//			dbLib.getConnection();
//			
		}
		
		@BeforeClass(groups = {"smokeTest", "regressionTest"})
		public void configBC() throws IOException {
			System.out.println("===Launch the browser===");	
			String BROWSER =fLib.getDataFromPropertiesFile("browser");
					
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			} else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if(BROWSER.equals("edge")) {
					driver= new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
			sdriver = driver;

  		   UtilityClassObject.setDriver(driver);

		}
		
		/**@Parameters("BROWSER")
		 * @throws Throwable 
		@BeforeClass(groups = {"smokeTest", "regressionTest"})
		public void configBC( String browser) throws IOException {
			System.out.println("===Launch the browser===");	
			String BROWSER = browser;
					//fLib.getDataFromPropertiesFile("browser");
					
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			} else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if(BROWSER.equals("edge")) {
					driver= new EdgeDriver();
			} **/
			

		
		@BeforeMethod(groups = {"smokeTest", "regressionTest"})
		public void configBM() throws IOException, Throwable {
			System.out.println("Login");
		    String URL = fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile( "username");
			Thread.sleep(1000);
			String PASSWORD = fLib.getDataFromPropertiesFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(URL, USERNAME, PASSWORD);
		}

		@AfterMethod(groups = {"smokeTest", "regressionTest"})
		public void configAM() {
//			System.out.println("Logout");
//			DashboardPage dp = new DashboardPage(driver);
//			dp.logout();
		}

		@AfterClass(groups = {"smokeTest", "regressionTest"})
		public void configAC() {
//			System.out.println("===Close the browser===");
//			driver.quit();
		}
		
		@AfterSuite(groups = {"smokeTest", "regressionTest"})
		public void configAS() throws SQLException {
//			System.out.println("===Close  DB , Report backup ====");
//			dbLib.closeDbConnection();
//			
			
		}
}
