package org.ivymobility.com.PriceGroups;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestPriceGroupsSuiteBase extends TestBase
{

	
@BeforeSuite
public void checkSuiteSkip() throws Exception
{
	initialize();
	openBrowser();
	distributorLogin();
	
	
	APP_LOGS.debug("Checking Runmode of suitexls");
    if (!TestUtil.isSuiteRunnable(suitexls,"PriceGroups"))
	{
    	
		//System.out.println(Smoketestsuitexls.getRowCount("testcase"));
		APP_LOGS.debug("Skipping the execution of priceGroupsSuitexls as the runmode of the suite was set to NO");
		throw new SkipException(" RunMode of priceGroupsSuitexls  is set to No, therefore skipping all test cases in priceGroupsSuitexls");
		
	}
	
}
@AfterSuite
public void tearDown(){
	driver.close();
	driver.quit();
}

}
