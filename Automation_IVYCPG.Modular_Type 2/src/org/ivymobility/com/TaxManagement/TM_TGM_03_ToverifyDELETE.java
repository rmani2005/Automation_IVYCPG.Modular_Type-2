package org.ivymobility.com.TaxManagement;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TM_TGM_03_ToverifyDELETE extends TestTaxManagementSuiteBase
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
	
	
	
	
	@Test(dataProvider = "getTestData")
	public void test1(String location,String destination_location,String taxapply_Type,String certificate_Type,String periodfrom_Month,
			String periodto_Month,String TaxGroup)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("TGM_MENU")).click();
			APP_LOGS.info("Clicked on TaxGroup Mapping");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement ADD=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_ADD"));
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
		
			WebElement location_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Location_Field"));
			
			if(location_Field.isDisplayed())
			{	
				Select s1=new Select(location_Field);
				s1.selectByVisibleText(location);	
				APP_LOGS.info("Location Field displayed");
			}
			else
			{
				APP_LOGS.error("Location Field is not displayed");
			}
			
			WebElement destination_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Destination_Location_Field"));
			
			if(destination_Field.isDisplayed())
			{
				Select s2=new Select(destination_Field);
				s2.selectByVisibleText(destination_location);
				
				APP_LOGS.info("Destination Location field is available");
			}
			else
			{
				APP_LOGS.error("Destination Location field is not available");
			}
			
			WebElement taxApply_Type_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Tax_Apply_Type_Field"));
			
			if(taxApply_Type_Field.isDisplayed())
			{
			//	taxApply_Type_Field.sendKeys(taxapply_Type);
				Select s3=new Select(taxApply_Type_Field);
				s3.selectByVisibleText(taxapply_Type);	
				
				APP_LOGS.info("Tax Apply Type Field is available");
			}
			else
			{
				APP_LOGS.error("Tax Apply Type Field is not available");
			}
			
            WebElement certificateType_Type_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Certificate_Type_Field"));
			
			if(certificateType_Type_Field.isDisplayed())
			{
				//certifaicateType_Type_Field.sendKeys(certificater_Type);
				Select s4=new Select(certificateType_Type_Field);
				s4.selectByVisibleText(certificate_Type);
				APP_LOGS.info("Certificate Type Field is available");
			}
			else
			{
				APP_LOGS.error("Certificate Type Field is not available");
			} 
			
			WebElement periodFrom_Month_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_PeriodFrom_Month_Field"));
				
			if(periodFrom_Month_Field.isDisplayed())
			{
				//periodFrom_Month_Field.sendKeys(periodfrom_Month);
				Select s5=new Select(periodFrom_Month_Field);
				s5.selectByVisibleText(periodfrom_Month);
				
				APP_LOGS.info("Period From Month Field is available");
			}
			else
			{
				APP_LOGS.error("Period From Month Field is not available");
			} 
				
			WebElement periodFrom_Year_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_PeriodFrom_Year_Field"));
			
			if(periodFrom_Year_Field.isDisplayed())
			{
			/*	
			//	System.out.println(periodfrom_Year);
				//periodFrom_Year_Field.sendKeys(periodfrom_Year);
				
				DataFormatter df=new DataFormatter();
				String s=df.formatCellValue(periodfrom_Year);*/
				
				Select s6=new Select(periodFrom_Year_Field);
				s6.selectByVisibleText("2016");
				APP_LOGS.info("Period From Year Field is available");
			}
			else
			{
				APP_LOGS.error("Period From Year Field is not available");
			} 
			
            WebElement periodTo_Month_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_PeriodTo_Month_Field"));
			
			if(periodTo_Month_Field.isDisplayed())
			{
				//periodTo_Month_Field.sendKeys(periodto_Month);
				Select s7=new Select(periodTo_Month_Field);
				s7.selectByVisibleText(periodto_Month);
				APP_LOGS.info("Period To Month Field is available");
			}
			else
			{
				APP_LOGS.error("Period To Month Field is not available");
			} 
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
            WebElement periodTo_Year_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_PeriodTo_Year_Field"));
			
			if(periodTo_Year_Field.isDisplayed())
			{
				//periodTo_Year_Field.sendKeys(periodto_Year);
				Select s8=new Select(periodTo_Year_Field);
				s8.selectByVisibleText("2016");
				
				APP_LOGS.info("Period To Year Field is available");
			}
			else
			{
				APP_LOGS.error("Period To Year Field is not available");
			} 
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			
			 WebElement TGM_Tax_Group_Field=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Tax_Group"));
				
				if(TGM_Tax_Group_Field.isDisplayed())
				{
					//periodTo_Year_Field.sendKeys(periodto_Year);
					Select s9=new Select(TGM_Tax_Group_Field);
					s9.selectByVisibleText(TaxGroup);
					
					APP_LOGS.info("Period To Year Field is available");
				}
				else
				{
					APP_LOGS.error("Period To Year Field is not available");
				} 
				
				driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
            WebElement TGM_Finish_Button=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Finish_Button"));
			
			if(TGM_Finish_Button.isDisplayed())
			{
				TGM_Finish_Button.click();
				APP_LOGS.info("Clicked on the Finish button");
			}
			else
			{
				APP_LOGS.error("Finish button is not available");
			} 
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			String actual=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			
			WebElement ok=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
			
			if(ok.isDisplayed())
			{
				ok.click();
				APP_LOGS.info("Clicked on the ok button in the popup");
			}
			else
			{
				APP_LOGS.error("Ok button is not available in the popup");
			}
			
			Assert.assertEquals(actual, "Details added successfully!");
			
			Thread.sleep(1000);
			
	        
			driver.switchTo().frame(TestBase.getElement(driver, TestBase.OR.getProperty("frame")));
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			

			WebElement data=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_Search_Data_DELETE"));
			if(data != null)
			{
				data.click();
				APP_LOGS.info("Selected Data in the grid");
			}
			else
			{
				APP_LOGS.error("Unable to select data in the grid");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement DELETE=TestBase.getElement(driver, TestBase.OR.getProperty("TGM_DELETE"));
			if(DELETE != null)
			{
				DELETE.click();
				APP_LOGS.info("Clicked on DELETE label");
			}
			else
			{
				APP_LOGS.error("DELETE label is not available");
			}
			
			Thread.sleep(1000);
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
				
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				String actual1=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
				
				WebElement ok1=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON"));
				
				if(ok1.isDisplayed())
				{
					ok1.click();
					APP_LOGS.info("Clicked on the ok button in the popup");
				}
				else
				{
					APP_LOGS.error("Ok button is not available in the popup");
				}
				
				Assert.assertEquals(actual1, "Details deleted successfully!");
				
			
			
			
			
			
			
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
