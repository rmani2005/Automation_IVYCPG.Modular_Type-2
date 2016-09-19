package org.ivymobility.com.ProductTagging;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

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

public class PT_MSL_TC_06_ToverifyPCM extends TestProductTaggingSuiteBase
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
			
			WebElement code_Field=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_CODE_Field"));
			if(code_Field.isDisplayed())
			{
				code_Field.sendKeys(code);
				APP_LOGS.info("Code field is available");
			}
			else
			{
				APP_LOGS.info("Code field is not available");
			}
		
			WebElement name_Field=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_NAME_Field"));
			if(name_Field.isDisplayed())
			{
				name_Field.sendKeys(name);
				APP_LOGS.info("Name field is available");
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			WebElement effectivefrom_Field=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Effective_From_Field"));
			if(effectivefrom_Field.isDisplayed())
			{
				effectivefrom_Field.click();
				APP_LOGS.info("Clikced on Effective from field");
			}
			else
			{
				APP_LOGS.info("Effective from field is not available");
			}
			
			Thread.sleep(1000);
			WebElement effectivefrom_Date=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_EffectiveFrom_Date"));
			if(effectivefrom_Date.isDisplayed())
			{
				effectivefrom_Date.click();
				APP_LOGS.info("Clikced on Effective from date");
			}
			else
			{
				APP_LOGS.info("Effective from date is not available");
			}
		
			
			WebElement effectiveto_Field=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Effective_To_Field"));
			if(effectiveto_Field.isDisplayed())
			{
				effectiveto_Field.click();
				APP_LOGS.info("Clikced on Effective to Field");
			}
			else
			{
				APP_LOGS.info("Effective to Field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement effectiveto_Date=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_EffectiveTo_Date"));
			if(effectiveto_Date.isDisplayed())
			{
				effectiveto_Date.click();
				APP_LOGS.info("Clikced on Effective to date");
			}
			else
			{
				APP_LOGS.info("Effective to date is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement next_Button1=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Next"));
			if(next_Button1.isDisplayed())
			{
				next_Button1.click();
				APP_LOGS.info("Clikced on Next to date");
			}
			else
			{
				APP_LOGS.info("Next button is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement next_GP2=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Next"));
			if(next_GP2.isDisplayed())
			{
				next_GP2.click();
				APP_LOGS.info("Clicked on next button");
			}
			else
			{
				APP_LOGS.info("Next button is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			String pcm_hearder=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_PCM_Hearder")).getText();
			
			Assert.assertEquals("Product Criteria Mapping", pcm_hearder);
			
			
			
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
