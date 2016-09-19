package org.ivymobility.com.PriceGroups;

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

public class PD_TC_01_ToverifySAVE extends TestPriceGroupsSuiteBase 
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
	
		if(!TestUtil.isTestCaseRunnable(priceGroupsSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(priceGroupsSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	
	@Test(dataProvider="getTestData")
	public void test1(String dist_code,String Products)
	{
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y"))
		{
		skip= true;
		throw new SkipException("Run mode to test data was set to NO for row #" + count);
		}

		try{
			openUrl();

			driver.switchTo().defaultContent();
			TestBase.getElement(driver, TestBase.OR.getProperty("masters")).click();
			APP_LOGS.info("Clicked on Masters");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("productManagement")).click();
			APP_LOGS.info("Clicked on ProductManagement");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PD_MENU")).click();
			APP_LOGS.info("Clicked on Product Distribution");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			Thread.sleep(2000);
			
			WebElement PD=TestBase.getElement(driver, TestBase.OR.getProperty("PD_Search_Field"));
			if(PD != null)
			{
				PD.sendKeys(dist_code);
				APP_LOGS.info("value is sent to search field ");
			}
			else
			{
				APP_LOGS.info("Search field is not available");
			}
			
			Thread.sleep(2000);
			
			WebElement data=TestBase.getElement(driver, TestBase.OR.getProperty("PD_GRID_DATA"));
			if(data != null)
			{
				data.click();
				APP_LOGS.info("Clicked on the data in the grid");
			}
			else
			{
				APP_LOGS.info("Data is not available in the grid");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement MAP=TestBase.getElement(driver, TestBase.OR.getProperty("PD_MAP"));
			if(MAP != null)
			{
				MAP.click();
				APP_LOGS.info("Clicked on MAP label");
				
			}
			else
			{
				APP_LOGS.info("MAP label not available");
			}
		 
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement search=TestBase.getElement(driver, TestBase.OR.getProperty("PD_MAP_Search"));
			if(search != null)
			{
				search.sendKeys(Products);
				APP_LOGS.info("Values is sent to Search field");
			}
			else
			{
				APP_LOGS.info("Search field is not available");
			}
			
			Thread.sleep(2000);
			
			WebElement product_IMG=TestBase.getElement(driver, TestBase.OR.getProperty("PD_PRODUCTDIST_IMG"));
			if(product_IMG != null)
			{
				product_IMG.click();
				APP_LOGS.info("Clicked on DATA in the grid");
			}
			else
			{
				APP_LOGS.error("Data is not available in the grid");
			}
			
			WebElement save_button=TestBase.getElement(driver, TestBase.OR.getProperty("PD_SAVE"));
			if(save_button != null)
			{
				save_button.click();
				APP_LOGS.info("Clicked on the SAVE button");
			}
			else
			{
				APP_LOGS.error("SAVE button is not available");
			}
			
			driver.switchTo().defaultContent();
			
			Thread.sleep(2000);
			String actual=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			
			WebElement popup_button=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
			
			if(popup_button != null)
			{
				popup_button.click();
				APP_LOGS.info("Clicked on ok  button in popup");
			}
			else
			{
				APP_LOGS.info("OK button is not available");
			}
			APP_LOGS.info("Clicked on OK button in the popup");
			
			Assert.assertEquals(actual, "Saved Successfully");
			
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
		
			TestUtil.reportDataSetResult(priceGroupsSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(priceGroupsSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(priceGroupsSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
 

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(priceGroupsSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(priceGroupsSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(priceGroupsSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(priceGroupsSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(priceGroupsSuitexls,this.getClass().getSimpleName());
				
		}	
	

}
