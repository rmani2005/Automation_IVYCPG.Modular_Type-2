package org.ivymobility.com.PriceGroups;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PGM_LL_TC_01_ToverifySAVE extends TestPriceGroupsSuiteBase
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
	public void test1(String pgm_loc,String group_Name)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("PGM_MENU")).click();
			APP_LOGS.info("Clicked on Price Group Mapping");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			Thread.sleep(1000);
			
			WebElement PGM_LOC_SEARCH=TestBase.getElement(driver, TestBase.OR.getProperty("PGM_LOCATION_SEARCH"));
			if(PGM_LOC_SEARCH != null)
			{
				PGM_LOC_SEARCH.sendKeys(pgm_loc);
				APP_LOGS.info("value is sent to search field ");
			}
			else
			{
				APP_LOGS.error("Search field is not available");
			}
			
			Thread.sleep(2000);
			
			WebElement data=TestBase.getElement(driver, TestBase.OR.getProperty("PGM_DATA"));
			if(data != null)
			{
				Actions action=new Actions(driver);
				action.doubleClick(data).build().perform();
				APP_LOGS.info("Double clicked on the data in the grid");
			}
			else
			{
				APP_LOGS.error("Data is not available in the grid");
			}
			
			/*Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id("iContent")));
			WebElement ele=driver.findElement(By.className("dhx_combo_select"));
			Select select =new Select(ele);
			select.selectByIndex(1);
	
		
			
		
	
			System.out.println(group_Name);
			Thread.sleep(2000);*/
			
			
			
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement save_button=TestBase.getElement(driver, TestBase.OR.getProperty("PGM_SAVE"));
			
			if(save_button != null)
			{
				save_button.click();
				APP_LOGS.info("Clicked on Save  button in popup");
			}
			else
			{
				APP_LOGS.error("OK button is not available");
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
				APP_LOGS.error("OK button is not available");
			}
			
			
			Assert.assertEquals(actual, "Product Price GroupSaved Successfully");
			
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
