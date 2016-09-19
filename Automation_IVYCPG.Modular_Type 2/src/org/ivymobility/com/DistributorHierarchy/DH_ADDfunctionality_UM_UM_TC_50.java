package org.ivymobility.com.DistributorHierarchy;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DH_ADDfunctionality_UM_UM_TC_50 extends TestDistributorHierarchyBase
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
	
		if(!TestUtil.isTestCaseRunnable(distributorHierarchySuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(distributorHierarchySuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	@Test
	public void test1()
	{
		try{
			
			WebElement masters=TestBase.getElement(driver, TestBase.OR.getProperty("masters"));
			masters.click();
			APP_LOGS.info("Clicked on Masters menu");
			
			
			WebElement distributorHierarchy=TestBase.getElement(driver, TestBase.OR.getProperty("DistributorHierarchy"));
			distributorHierarchy.click();
			APP_LOGS.info("Clicked on Distributor Hierarchy");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("ADD")).click();
			APP_LOGS.info("Clicked on ADD label");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			
			
			
			
			
		}
		catch (Throwable t)
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
		
			TestUtil.reportDataSetResult(distributorHierarchySuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(distributorHierarchySuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(distributorHierarchySuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(distributorHierarchySuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(distributorHierarchySuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(distributorHierarchySuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(distributorHierarchySuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(distributorHierarchySuitexls,this.getClass().getSimpleName());
				
		}

	

}
