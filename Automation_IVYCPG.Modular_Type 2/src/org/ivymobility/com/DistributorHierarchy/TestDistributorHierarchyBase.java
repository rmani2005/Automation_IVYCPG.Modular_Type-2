package org.ivymobility.com.DistributorHierarchy;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestDistributorHierarchyBase extends TestBase
{

	
@BeforeSuite
public void checkSuiteSkip() throws Exception
{
	initialize();
	openBrowser();
	adminLogin();
	
	
	APP_LOGS.debug("Checking Runmode of suitexls");
    if (!TestUtil.isSuiteRunnable(suitexls,"DistributorHierarchy"))
	{
    	
		//System.out.println(Smoketestsuitexls.getRowCount("testcase"));
		APP_LOGS.debug("Skipping the execution of distributorHierarchySuitexls as the runmode of the suite was set to NO");
		throw new SkipException(" RunMode of distributorHierarchySuitexls  is set to No, therefore skipping all test cases in distributorHierarchySuitexls");
		
	}
	
}
@AfterSuite
public void tearDown(){
	driver.close();
}

	
	
	
	
	
	
	
	
	
}
