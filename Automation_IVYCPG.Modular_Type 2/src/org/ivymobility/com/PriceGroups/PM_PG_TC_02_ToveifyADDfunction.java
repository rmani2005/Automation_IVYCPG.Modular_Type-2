package org.ivymobility.com.PriceGroups;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PM_PG_TC_02_ToveifyADDfunction extends TestPriceGroupsSuiteBase 
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
	public void test1(String code_Value,String name_Value,String price_Value)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("priceGroup_Menu")).click();
			APP_LOGS.info("Clicked on Price Group");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement ADD=TestBase.getElement(driver, TestBase.OR.getProperty("PG_ADD"));
			if(ADD != null)
			{
				ADD.click();
				APP_LOGS.info("Clicked on ADD label");
				
			}
			else
			{
				APP_LOGS.info("ADD label not available");
			}
		    WebElement code=TestBase.getElement(driver, TestBase.OR.getProperty("PG_code_Field"));
			if(code != null)
			{
				code.sendKeys(code_Value);
			}
			else
			{
				APP_LOGS.info("Code Field is not available");
			}
			
			WebElement name=TestBase.getElement(driver, TestBase.OR.getProperty("PG_name_Field"));
			if(name != null)
			{
				name.sendKeys(name_Value);
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement saveandproceed=TestBase.getElement(driver, TestBase.OR.getProperty("PG_Save&Proceed_Button"));
			if(saveandproceed != null)
			{
				saveandproceed.click();
				APP_LOGS.info("Clicked on SAVE & PROCEED");
			}
			else
			{
				APP_LOGS.info("SAVE & PROCEED label is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement price_Field=TestBase.getElement(driver, TestBase.OR.getProperty("PG_PriceData_Entry"));
			if(price_Field.isDisplayed())
			{
				price_Field.click();
				TestBase.getElement(driver, TestBase.OR.getProperty("PG_PriceData_I/P")).sendKeys(price_Value);
				//driver.findElement(By.xpath(".//*[@id='_SKUPriceGrid']/div[2]/table/tbody/tr[2]/td[7]/input")).sendKeys(price_Value);
			
			}
			else
			{
				APP_LOGS.info("Price field is not available to set price");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement finish=TestBase.getElement(driver, TestBase.OR.getProperty("PG_ADD_Finish"));
			
			if(finish != null)
			{
			  finish.click();
			  APP_LOGS.info("Clicked on Finish button");
			}
			else
			{
				APP_LOGS.info("Finish button not available");
			}
			
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			
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
