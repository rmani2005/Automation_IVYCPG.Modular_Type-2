package org.ivymobility.com.ProductTagging;

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

public class PT_FB_TC_02_ToverifyADD extends TestProductTaggingSuiteBase
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
	
	
	
	
	@Test(dataProvider = "getTestData")
	public void test1(String code,String name,String group_code,String group_desc,String sku_code,String channel,String area_code)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PDT_FB_MENU")).click();
			APP_LOGS.info("Clicked on Focus Brand");
			
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
			
			WebElement add_GP1=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_ADD"));
			if(add_GP1.isDisplayed())
			{
				add_GP1.click();
				APP_LOGS.info("Clikced on Add to date");
			}
			else
			{
				APP_LOGS.info("Add button is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement code_GP=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Code"));
			if(code_GP.isDisplayed())
			{
				code_GP.sendKeys(group_code);
				APP_LOGS.info("Code field is available");
			}
			else
			{
				APP_LOGS.info("Code field is not available");
			}
			
			WebElement name_GP=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Name"));
			if(name_GP.isDisplayed())
			{
				name_GP.sendKeys(group_desc);
				APP_LOGS.info("Name field is available");
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			
			WebElement search_GP=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_SKU_SearchField"));
			if(search_GP.isDisplayed())
			{
				search_GP.sendKeys(sku_code);
				APP_LOGS.info("Sku search field is available");
			}
			else
			{
				APP_LOGS.info("Sku search field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement data_SKU=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_SKU_Select"));
			if(data_SKU.isDisplayed())
			{
				data_SKU.click();
				APP_LOGS.info("Sku is selected");
			}
			else
			{
				APP_LOGS.info("Sku is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement save_GP=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_SAVE"));
			if(save_GP.isDisplayed())
			{
				save_GP.click();
				APP_LOGS.info("Clicked on SAVE button");
			}
			else
			{
				APP_LOGS.info("SAVE button is not available");
			}
			
            Thread.sleep(1000);
            
            WebElement search_GP2=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_SearchField"));
			if(search_GP2.isDisplayed())
			{
				search_GP2.sendKeys(group_code);
				APP_LOGS.info("Group search field is available");
			}
			else
			{
				APP_LOGS.info("Group search field is not available");
			}
			
            Thread.sleep(1000);
            
            WebElement data_GP2=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Select"));
			if(data_GP2.isDisplayed())
			{
				data_GP2.click();
				APP_LOGS.info("Group data selected in the grid");
			}
			else
			{
				APP_LOGS.info("Group data is not available");
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
            
			Thread.sleep(1000);
			
			WebElement search_GP3=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Search"));
			if(search_GP3.isDisplayed())
			{
				search_GP3.sendKeys(group_code);
				APP_LOGS.info("Group search field is available");
			}
			else
			{
				APP_LOGS.info("Group search field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement data_GP=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_GP_Data"));
			if(data_GP.isDisplayed())
			{
				data_GP.click();
				APP_LOGS.info("Group data is selected");
			}
			else
			{
				APP_LOGS.info("Group data is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS); 
			
			WebElement chl=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_CHL_Search"));
			if(chl.isDisplayed())
			{
				chl.sendKeys(channel);
				APP_LOGS.info("Search Field is available");
			}
			else
			{
				APP_LOGS.info("Search Field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement chl_data=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL-CHL_Select"));
			if(chl_data.isDisplayed())
			{
				chl_data.click();
				APP_LOGS.info("Search Field is available");
			}
			else
			{
				APP_LOGS.info("Search Field is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement area_search=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Area_Search"));
			if(area_search.isDisplayed())
			{
				area_search.sendKeys(area_code);
				APP_LOGS.info("area Search Field is available");
			}
			else
			{
				APP_LOGS.info("area Search Field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement area_select=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_Area_Select"));
			if(area_select.isDisplayed())
			{
				area_select.click();
				APP_LOGS.info("area selected");
			}
			else
			{
				APP_LOGS.info("area is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement finish=TestBase.getElement(driver, TestBase.OR.getProperty("PDT_MSL_FINISH"));
			if(finish.isDisplayed())
			{
				finish.click();
				APP_LOGS.info("Clicked on finish button");
			}
			else
			{
				APP_LOGS.info("finish is not available");
			}
			
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			String actual=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			WebElement popup_button=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
			if(popup_button.isDisplayed())
			{
				popup_button.click();
				APP_LOGS.info("Clicked on ok button in the popup");
			}
			else
			{
				APP_LOGS.error("Ok button is not available in the popup");
			}
			
			
			Assert.assertEquals("Focus Brand 1 Saved Successfully", actual);

		
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
