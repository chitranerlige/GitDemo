package utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportFactory {
	
	private static ExtentReports report;
	
	public static ExtentReports getInstance(String path) {
		
		if(report == null) {

			

            ExtentSparkReporter spark =
                new ExtentSparkReporter(path);

            report = new ExtentReports();
            report.attachReporter(spark);

            report.setSystemInfo("Tester", "Your Name");
            report.setSystemInfo("Framework", "TestNG");
        }

        return report;

	}
}
