package com.test.qa.testcases;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

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


public class RegisterNewUserAndLogin extends TestBase {
	
	
	
	

	LoginPage loginPage;
	
	String sheetName = "CreateDomainData";
	
	logs log;
	
 //static ExcelUtil_old excel = new ExcelUtil_old();
	
	String systmpath=System.getProperty("user.dir");
	
	String path=systmpath+"\\src\\main\\java\\com\\test\\qa\\testdata\\FreeCrmTestData.xlsx";
   
     


	
	public RegisterNewUserAndLogin() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();
	}

@Test	
public  void Register() throws Exception {
		
		
		LoginPage loginPage2 = new LoginPage();
		  Random random=new Random();
		int abc =  10+random.nextInt(90);

		String NewEmailUD = "test123"+abc+"@test.com";
		
		System.out.println("NewEmailUD ::- "+NewEmailUD);
		String NewPassword="testing";
		
		loginPage2.RegisterFunction(NewEmailUD, NewPassword);
		
		
	}
	
	
	 
	
	
	  @AfterClass
	  public void tearDown() throws IOException
	  { 
		
		  //takeScreenshot("AddDomainAndDomainCreation");
		  driver.quit();
		  }
	 
	
}
