package org.ivymobility.com.usermanagementsuite;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class TestUserManagementSuiteBase extends  TestBase

{
	@BeforeSuite

	public void checkSuiteSkip() throws Exception
	{ 
		initialize();
		openBrowser();
		distributorLogin();
		
		
		
	
	   
	    
	    APP_LOGS.debug("Checking Runmode of suitexls");
	    if (!TestUtil.isSuiteRunnable(suitexls,"UserManagement"))
		{
	    	
			//System.out.println(Smoketestsuitexls.getRowCount("testcase"));
			APP_LOGS.debug("Skipping the execution of userManagementSuitexls as the runmode of the suite was set to NO");
			throw new SkipException(" RunMode of userManagementSuitexls  is set to No, therefore skipping all test cases in userManagementSuitexls");
			
		}

		}
		
		@AfterSuite
		public void tearDown(){
			driver.close();
		}

}
