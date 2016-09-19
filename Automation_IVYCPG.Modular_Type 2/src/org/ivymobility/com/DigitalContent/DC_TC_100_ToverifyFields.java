package org.ivymobility.com.DigitalContent;

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

public class DC_TC_100_ToverifyFields extends TestDigitalContentSuitBase
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_Transaction")).click();
			APP_LOGS.info("Clicked on Digital Content Management - Transaction");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			Thread.sleep(1000);
			
			boolean name=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_Name_Text")).isDisplayed();
			if(name)
			{
				APP_LOGS.info("Name field is available");
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			
			boolean shortDescription=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_ShortDescription_Text")).isDisplayed();
			if(shortDescription)
			{
				APP_LOGS.info("Short Description field available");
			}
			else
			{
				APP_LOGS.info("Short Description field is not available");
			}
			
			boolean fulldescription=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_Full_Description_Text")).isDisplayed();
			if(fulldescription)
			{
				APP_LOGS.info("Full Description field available");
			}
			else
			{
				APP_LOGS.info("Full Description field is not available");
			}
			
			boolean fileUpload=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_Full_File_Upload_Text")).isDisplayed();
			if(fileUpload)
			{
				APP_LOGS.info("File Upload field available");
			}
			else
			{
				APP_LOGS.info("File Upload field is not available");
			}
			
			boolean uploadfile=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_UploadFile_Button")).isDisplayed();
			if(uploadfile)
			{
				APP_LOGS.info("Upload File button available");
			}
			else
			{
				APP_LOGS.info("Upload File button is not available");
			}
			
			boolean delete_Label=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_Delete_Label")).isDisplayed();
			if(delete_Label)
			{
				APP_LOGS.info("Delete label available");
			}
			else
			{
				APP_LOGS.info("Delete label is not available");
			}
			
			boolean view_configuration=TestBase.getElement(driver, TestBase.OR.getProperty("DC_DCM_View_Configuration_Label")).isDisplayed();
			if(view_configuration)
			{
				APP_LOGS.info("View Configuration label available");
			}
			else
			{
				APP_LOGS.info("View Configuration label is not available");
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
