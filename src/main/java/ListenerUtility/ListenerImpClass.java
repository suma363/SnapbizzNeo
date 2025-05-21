package ListenerUtility;

import java.io.File;
import java.util.Date;

import BaseClass.BaseClass;
import WebDriverUtility.UtilityClassObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener, ISuiteListener {

	
/**	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "").replace(":", "");


		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("WareHousePortal Report");
		spark.config().setReportName("WHP Report");
		spark.config().setTheme(Theme.DARK);

		// add envi information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-7");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");

		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=======>" + result.getMethod().getMethodName() + ">=====START====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<===");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======>" + result.getMethod().getMethodName() + ">=====END====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>COMPLETED<===");

	}

	@Override
	public void onTestFailure(ITestResult result) {		
		String testName = result.getMethod().getMethodName();		
		// Take screenshot
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = edriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "").replace(":", "");
		
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===>FAILED<===");
		
		test.log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}**/

public static ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");

		// Ensure report folder exists
		new File("./AdvanceReport").mkdirs();

		String time = new Date().toString().replace(" ", "").replace(":", "");

		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + time + ".html");
		spark.config().setDocumentTitle("WareHousePortal Report");
		spark.config().setReportName("WHP Report");
		spark.config().setTheme(Theme.DARK);

		// Attach reporter
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-7");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=======>" + result.getMethod().getMethodName() + ">=====START====");

		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);

		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + " ===> STARTED <===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======>" + result.getMethod().getMethodName() + ">=====END====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + " ===> COMPLETED <===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		// Take screenshot
		TakesScreenshot edriver = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = edriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "").replace(":", "");

		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, testName + " ===> FAILED <===");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// Not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		// Not implemented
	}

}
