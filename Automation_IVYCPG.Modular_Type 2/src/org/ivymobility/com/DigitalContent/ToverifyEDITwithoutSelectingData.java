package org.ivymobility.com.DigitalContent;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToverifyEDITwithoutSelectingData extends TestDigitalContentSuitBase
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
	
		if(!TestUtil.isTestCaseRunnable(digitalContentSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(digitalContentSuitexls,this.getClass().getSimpleName() );
		
		
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("DC_MENU")).click();
			APP_LOGS.info("Clicked on Digital Content");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("DCM_MENU")).click();
			APP_LOGS.info("Clicked on Digital Content Mapping");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement EDIT=TestBase.getElement(driver, TestBase.OR.getProperty("DCM_EDIT"));
			if(EDIT.isDisplayed())
			{
			
				EDIT.click();
				APP_LOGS.info("Clicked on EDIT label");
			}
			else
			{
				APP_LOGS.info("EDIT label is not available");
			}
						
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			String actual1=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			WebElement popup_button1=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
			if(popup_button1.isDisplayed())
			{
				popup_button1.click();
				APP_LOGS.info("Clicked on ok button in the popup");
			}
			else
			{
				APP_LOGS.error("Ok button is not available in the popup");
			}
			
			
			Assert.assertEquals("Need Selection", actual1);
			
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
		
			TestUtil.reportDataSetResult(digitalContentSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(digitalContentSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(digitalContentSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(digitalContentSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(digitalContentSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(digitalContentSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(digitalContentSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(digitalContentSuitexls,this.getClass().getSimpleName());
				
		}	
	
	
	
	
	
}
