package org.ivymobility.com.StoreManagement;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToVerifyAddressScreen_SM_LL_TC_05 extends TestStoreManagementSuiteBase
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
	
		if(!TestUtil.isTestCaseRunnable(storeManagementSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(storeManagementSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	
	@Test
	public void test1()
	{
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y"))
		{
		skip= true;
		throw new SkipException("Run mode to test data was set to NO for row #" + count);
		}

		try{
			openUrl();

			TestBase.getElement(driver, TestBase.OR.getProperty("masters")).click();
			APP_LOGS.info("Clicked on Masters");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outletManagement")).click();
			APP_LOGS.info("Clicked on OutletManagement");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outletMaster")).click();
			APP_LOGS.info("Clicked on OutletMaster");
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outlet_ADD")).click();
			APP_LOGS.info("Clicked on ADD label");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("address_Tab")).click();
			APP_LOGS.info("Clicked on Address tab");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("address_ADD")).click();
			APP_LOGS.info("Clicked on ADD label in Address tab");
			
			boolean addressType=TestBase.getElement(driver, TestBase.OR.getProperty("addressType_Text")).isDisplayed();
			
			if(addressType)
			{
				APP_LOGS.info("Address Type field available");
			}
			
			boolean address1=TestBase.getElement(driver, TestBase.OR.getProperty("address1_Text")).isDisplayed();
			if(address1)
			{
				APP_LOGS.info("Address1 field available");
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
		
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(storeManagementSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(storeManagementSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(storeManagementSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(storeManagementSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(storeManagementSuitexls,this.getClass().getSimpleName());
				
		}	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
