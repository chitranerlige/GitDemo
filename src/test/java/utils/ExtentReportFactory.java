package utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportFactory {
	
	private static ExtentReports report;
	
	public static ExtentReports getInstance() {
		
		if(report == null) {

			String relativePath = ConfigReader.getProperty("report.path");
			String systemWorkspace = System.getProperty("user.dir");
	        String finalReportPath = systemWorkspace + File.separator + relativePath;
	        

            ExtentSparkReporter spark =
                new ExtentSparkReporter(finalReportPath);

            report = new ExtentReports();
            report.attachReporter(spark);

            report.setSystemInfo("Tester", "Your Name");
            report.setSystemInfo("Framework", "TestNG");
        }

        return report;

	}
}
