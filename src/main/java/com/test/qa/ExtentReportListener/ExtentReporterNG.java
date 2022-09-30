
package com.test.qa.ExtentReportListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	
	public static ExtentTest test;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
	//	extent = new ExtentReports(outputDirectory + File.separator	+ "Extent.html", true);
		
		String fileSuffix = new SimpleDateFormat("MMM_dd_yy_HH_mm_ss").format(new Date());
		String reportfolderpath=System.getProperty("user.dir");
		System.out.println("reportfolderpath::- "+reportfolderpath);
		extent = new ExtentReports(reportfolderpath+"\\Reports"+"\\"+fileSuffix+"_Test_Result.html");
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
					String reportfolderpath2=System.getProperty("user.dir");
					test.addScreenCapture(reportfolderpath2+"\\screenshots");
					
				}

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	//Method for adding logs passed from test cases
	 public void reportLog(String message) {    
	    test.log(LogStatus.INFO, message);//For extentTest HTML report
	   // logger.info("Message: " + message);
	    Reporter.log(message);

	}
}