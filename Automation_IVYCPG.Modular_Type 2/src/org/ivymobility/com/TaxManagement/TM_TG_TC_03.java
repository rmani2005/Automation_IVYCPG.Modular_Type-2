package org.ivymobility.com.TaxManagement;

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

public class TM_TG_TC_03 extends TestTaxManagementSuiteBase
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
	
		if(!TestUtil.isTestCaseRunnable(taxManagementSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(taxManagementSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	
	@Test(dataProvider="getTestData")
	public void test1(String groupName,String taxRate,String editingValue)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TaxManagement")).click();
			APP_LOGS.info("Clicked on TaxManagement");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TaxGroup")).click();
			APP_LOGS.info("Clicked on TaxGroup");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement ADD=TestBase.getElement(driver, TestBase.OR.getProperty("TAX_ADD"));
			if(ADD != null)
			{
				ADD.click();
				APP_LOGS.info("Clicked on ADD label");
			}
			else
			{
				APP_LOGS.error("ADD label is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			WebElement groupName_Fieled=TestBase.getElement(driver, TestBase.OR.getProperty("GroupNameField"));
			
			if(groupName_Fieled != null)
			{
				groupName_Fieled.sendKeys(groupName);                  
			}
			else
			{
				APP_LOGS.error("Group Name Field is not available");
			}
				
			WebElement startdate_Field = TestBase.getElement(driver, TestBase.OR.getProperty("StartDateField"));
			if(startdate_Field != null)
			{
				startdate_Field.click();
				APP_LOGS.info("Clicked on Start date field");
			}
			else
			{
				APP_LOGS.error("Start date field is not available");    
			}
			
			Thread.sleep(1000);
			
			WebElement startdate_Calendar=TestBase.getElement(driver, TestBase.OR.getProperty("StartDateValue_E"));
			if(startdate_Calendar != null)
			{
				//startdate_Calendar.sendKeys(startingDate);	
				startdate_Calendar.click();
				APP_LOGS.error("Selected Start Date");
			}
			else
			{
				APP_LOGS.error("Start date is not selected");
			}
			
			Thread.sleep(1000);
			WebElement enddate_Field=TestBase.getElement(driver, TestBase.OR.getProperty("EndDateField"));
			if(enddate_Field != null)
			{
				enddate_Field.click();
				APP_LOGS.info("Clicked on End Date field");
			}
			else
			{
				APP_LOGS.error("End Date field is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement enddateValue = TestBase.getElement(driver, TestBase.OR.getProperty("EndDateValue_E"));
			
			if(enddateValue != null)
			{
				enddateValue.click();
				//enddateValue.sendKeys(endingDate);
				APP_LOGS.info("Selected end date");
			}
			else
			{
				APP_LOGS.error("End Date is not selected");
			}
				
		
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement  taxGroup = TestBase.getElement(driver, TestBase.OR.getProperty("TaxGroupType"));
			if(taxGroup != null)
			{
				taxGroup.click();
				APP_LOGS.info("Clicked on Group Type");
			}
			WebElement taxValue=TestBase.getElement(driver, TestBase.OR.getProperty("TaxValue"));
			if(taxValue != null)
			{
				taxValue.click();
				WebElement taxValue1=TestBase.getElement(driver, TestBase.OR.getProperty("TaxVlaue_INPUT"));
				taxValue1.clear();
				taxValue1.sendKeys(taxRate);
			}
			else
			{
				APP_LOGS.info("taxvalue is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement save=TestBase.getElement(driver, TestBase.OR.getProperty("SaveInADDscrn"));
			if(save != null)
			{
				save.click();
				APP_LOGS.info("Clicked on Save button");
			}
			else
			{
				APP_LOGS.info("Save button is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			driver.switchTo().defaultContent();
			
			String actual=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			System.out.println(actual);
			TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON")).click();
			APP_LOGS.info("Clicked on ok button in popup");
			Assert.assertEquals(actual, "Tax group saved successfully");
			
			Thread.sleep(1000);
			
			WebElement frame1=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame1);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement searchField=TestBase.getElement(driver, TestBase.OR.getProperty("TaxSearch_Field"));
			if(searchField != null)
			{
				searchField.sendKeys(groupName);
			}
			else
			{
				APP_LOGS.error("Search Field is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement data_Grid=TestBase.getElement(driver, TestBase.OR.getProperty("SelectDataIntheGrid"));
			if(data_Grid != null)
			{
				data_Grid.click();
				APP_LOGS.info("Selected DATA in the grid");
			}
			
			else
			{
				APP_LOGS.info("Data is not available in the grid");
			}
			
			WebElement tax_Edit=TestBase.getElement(driver, TestBase.OR.getProperty("TAX_EDIT"));
			if(tax_Edit != null)
			{
				tax_Edit.click();
				APP_LOGS.info("Clicked on EDIT label");
			}
			else
			{
				APP_LOGS.info("EDIT label is not available");
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			//TestBase.getElement(driver, TestBase.OR.getProperty("TaxGroupType")).click();
			TestBase.getElement(driver, TestBase.OR.getProperty("TaxValue")).click();
			WebElement taxValue2=TestBase.getElement(driver, TestBase.OR.getProperty("TaxVlaue_INPUT"));
	
			if(taxValue2 != null)
		    {
			   taxValue2.click();
			   taxValue2.clear();
			   taxValue2.sendKeys(editingValue);
			
	     	}
			
			WebElement Save_EDIT=TestBase.getElement(driver, TestBase.OR.getProperty("SaveInADDscrn"));
			if(Save_EDIT != null)
			{
				Save_EDIT.click();
				APP_LOGS.info("Clicked on Save button");
			}
			else
			{
				APP_LOGS.info("Save button is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			
			String actual1=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			WebElement ok_popup=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
			if(ok_popup != null)
			{
				ok_popup.click();
				APP_LOGS.info("Clicked on ok button in popup");
			}
			else
			{
				APP_LOGS.info("OK button in popup is not available in the popup");
			}
			
			Assert.assertEquals(actual1, "Tax group updated successfully");
			
			
			
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
		
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(taxManagementSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(taxManagementSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(taxManagementSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(taxManagementSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(taxManagementSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(taxManagementSuitexls,this.getClass().getSimpleName());
				
		}	
	
	
	
	
	
}
