package org.ivymobility.com.TaxManagement;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TM_TG_TC_01 extends TestTaxManagementSuiteBase
{
	
	String runmodes[]=null; 
	static int count=-1;
	static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	
	
	@BeforeTest
	public void checkTestSkip() throws InterruptedException
	{
	
		if(!TestUtil.isTestCaseRunnable(taxManagementSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(taxManagementSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	
	@Test
	public void test1()
	{

		try{

			TestBase.getElement(driver, TestBase.OR.getProperty("masters")).click();
			APP_LOGS.info("Clicked on Masters");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TaxManagement")).click();
			APP_LOGS.info("Clicked on TaxManagement");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TaxGroup")).click();
			APP_LOGS.info("Clicked on TaxGroup");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TAX_ADD")).click();
			APP_LOGS.info("Clicked on ADD label");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			boolean groupName=TestBase.getElement(driver, TestBase.OR.getProperty("GroupNameText")).isDisplayed();
			if(groupName)
			{
				APP_LOGS.info("Element visible");
			}
			else
			{
				APP_LOGS.info("Element is not visible");
			}
			
			boolean startDate=TestBase.getElement(driver, TestBase.OR.getProperty("StartDate")).isDisplayed();
			if(startDate)
			{
				APP_LOGS.info("Element visible");
			}
			else
			{
				APP_LOGS.info("Element is not visible");
			}
			
			boolean endDate=TestBase.getElement(driver, TestBase.OR.getProperty("EndDate")).isDisplayed();
			if(endDate)
			{
				APP_LOGS.info("Element visible");
			}
			else
			{
				APP_LOGS.info("Element is not visible");
			}
		
		}catch (Throwable t)
		{
		
		//code to report the error in testng
		//ErrorUtil.addVerificationFailure(t);			
		// report the error in excel file
		fail=true;
		//return; // this is optional &is return will make the test case stop!! if you don't want to stop the test case here and go further don't use return here.
		}
		
	}
	
	
	
	@AfterMethod
	public void reportDatasetResult()  //after method will be executed for each dataset every time test case is executed....
	{
		if(skip)
		
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(taxManagementSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(taxManagementSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(taxManagementSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(taxManagementSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(taxManagementSuitexls,this.getClass().getSimpleName());
				
		}	
	

}
