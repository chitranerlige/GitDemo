package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;



public class TestListeners implements ITestListener{
	private static final Logger log = LogManager.getLogger(TestListeners.class);

	@Override
	public void onTestStart(ITestResult result) {
	
		log.info("Test started " + result.getMethod().getMethodName());
		BaseTest.getTest().info("Test started" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		log.info("Test is successfull " + result.getMethod().getMethodName());
		BaseTest.getTest().info("Test is successfull " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		log.error("Test is failed " + result.getMethod().getMethodName());
		BaseTest.getTest().info("Test is failed " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.info("Test is skipped " + result.getMethod().getMethodName());
		BaseTest.getTest().info("Test is skipped " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Test suite started ");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Test suite finished ");
	}
	
	

}
