package base;

import utils.ConfigReader;
import utils.ExtentReportFactory;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.AfterSuite;

public class BaseTest {

	private static ExtentReports report;
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentTest getTest() {
		return extentTest.get();
	}

	@BeforeSuite
	public void beforeSuite() {

		ConfigReader.loadProperties();
		String path = ConfigReader.getProperty("report.path");

	    report = ExtentReportFactory.getInstance(path);

	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTest t = report.createTest(getClass().getSimpleName() + " - " + method.getName());
		extentTest.set(t);
	}

	@AfterMethod
	public void afterMethod() {
	    extentTest.remove();
	}

	@AfterSuite
	public void afterSuite() {
		if (report != null) {
	        report.flush();
	    } else {
	        System.out.println("Report is null - skipping flush");
	    }
	}

}
