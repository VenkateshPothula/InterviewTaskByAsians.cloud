package com.test.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.qa.ExtentReportListener.ExtentReporterNG;
import com.test.qa.base.TestBase;
import com.test.qa.base.logs;
import com.test.qa.pages.LoginPage;


public class UserLogin extends TestBase {
	
	
	
	

	LoginPage loginPage;
	
	String sheetName = "CreateDomainData";
	
	logs log;
	
 //static ExcelUtil_old excel = new ExcelUtil_old();
	
	String systmpath=System.getProperty("user.dir");
	
	String path=systmpath+"\\src\\main\\java\\com\\test\\qa\\testdata\\FreeCrmTestData.xlsx";
   
     


	
	public UserLogin() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();
	}

	
	
	  @Test public void AppLogin() throws Exception {
	  
	  
	  LoginPage loginPage2 = new LoginPage();
	  
	  String UserID=prop.getProperty("username"); String
	  Password=prop.getProperty("password");
	  
	  loginPage2.LoginFunction(UserID, Password);
	  
	  
	  }
	 
	
	
	  @AfterClass
	  public void tearDown() throws IOException
	  { 
		
		  //takeScreenshot("AddDomainAndDomainCreation");
		  driver.quit();
		  }
	 
	
}
