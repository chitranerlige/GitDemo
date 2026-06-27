package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestData {

	@DataProvider(name = "excelData")
	public Object[][] getData(Method m) {

	    String sheetName = m.getName(); // dynamic mapping

	    String path = ConfigReader.getProperty("excel.path1")
	                 + ConfigReader.getProperty("login.file1");

	    return ExcelUtility.getTestData(path, sheetName, "Test_Data");
	}
}