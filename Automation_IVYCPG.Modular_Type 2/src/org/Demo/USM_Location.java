package org.Demo;

import org.ivymobility.com.base.CommonMethods;
import org.ivymobility.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class USM_Location extends TestDemoSuiteBase{
	
	String runmodes[]=null; 
	static int count=-1;
	static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	
	
	@BeforeTest
	public void checkTestSkip() throws InterruptedException
	{
	
		if(!TestUtil.isTestCaseRunnable(demoSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(demoSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void test1(String code,String name)
	{
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y"))
		{
		skip= true;
		throw new SkipException("Run mode to test data was set to NO for row #" + count);
		}
		
		try{
		
		openUrl();
		
		CommonMethods.click(driver, "Masters");
		CommonMethods.click(driver, "UserManagement");
		CommonMethods.implicityWait(driver,400);
		CommonMethods.switchToFrame(driver, "frame");
	    CommonMethods.implicityWait(driver,400);
		CommonMethods.click(driver, "Location");
		CommonMethods.implicityWait(driver,400);
		CommonMethods.switchToFrame(driver, "frame");
		CommonMethods.threadSleep(2000);
		CommonMethods.click(driver, "National");
		CommonMethods.threadSleep(2000);
		CommonMethods.click(driver, "USM_ADD");
		CommonMethods.threadSleep(2000);
		CommonMethods.textField(driver, "USM_CODE", code);
		CommonMethods.textField(driver, "USM_NAME", name);
		CommonMethods.buttonClick(driver, "USM_SAVE");
		CommonMethods.threadSleep(2000);
		CommonMethods.switchToDefaultContent(driver);
		CommonMethods.popupTextVerification(driver, "POPUP_CONTENT", "Location details added successfully!");
		CommonMethods.clickonPopupButton(driver, "POPUP_BUTTON");
		
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
		
			TestUtil.reportDataSetResult(demoSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(demoSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(demoSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
 

	@AfterTest
	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(demoSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(demoSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(demoSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(demoSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(demoSuitexls,this.getClass().getSimpleName());
				
		}	
	
	
	
	
}
