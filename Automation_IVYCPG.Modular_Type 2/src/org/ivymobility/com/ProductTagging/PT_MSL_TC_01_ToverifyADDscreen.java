package org.ivymobility.com.ProductTagging;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PT_MSL_TC_01_ToverifyADDscreen extends TestProductTaggingSuiteBase
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
	
		if(!TestUtil.isTestCaseRunnable(productTaggingSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(productTaggingSuitexls,this.getClass().getSimpleName() );
		
		
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MENU")).click();
			APP_LOGS.info("Clicked on ProductTagging");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_MENU")).click();
			APP_LOGS.info("Clicked on Must sell");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_ADD")).click();
			APP_LOGS.info("Clicked on ADD label");
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			boolean code=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Code_Text")).isDisplayed();
			if(code)
			{
				APP_LOGS.info("Code Field is available");
			}
			else
			{
				APP_LOGS.info("Code Field is not available");
			}
			
			boolean name=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Name_Text")).isDisplayed();
			if(name)
			{
				APP_LOGS.info("Name field available");
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			
			boolean PDT_MSL_Effective_From_Text=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Effective_From_Text")).isDisplayed();
			if(PDT_MSL_Effective_From_Text)
			{
				APP_LOGS.info("Effective From field available");
			}
			else
			{
				APP_LOGS.info("Effective From field is not available");
			}
			
			boolean PDT_MSL_Effective_To_Text=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Effective_To_Text")).isDisplayed();
			if(PDT_MSL_Effective_To_Text)
			{
				APP_LOGS.info("Effective To field available");
			}
			else
			{
				APP_LOGS.info("Effective To field is not available");
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
		
			TestUtil.reportDataSetResult(productTaggingSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(productTaggingSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(productTaggingSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(productTaggingSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(productTaggingSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(productTaggingSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(productTaggingSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(productTaggingSuitexls,this.getClass().getSimpleName());
				
		}	
	

	
	

}
