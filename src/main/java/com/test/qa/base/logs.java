package com.test.qa.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class logs {
	private static ExtentReports extent;
	static ExtentTest test;
	public static void logsmethod(String Loginfo) {
		extent = new ExtentReports(System.getProperty("user.dir"+"\\Reports"));
		
		test=extent.startTest(Loginfo);
		
		test.log(LogStatus.INFO, "starting the report log gen");
	}
	

}
