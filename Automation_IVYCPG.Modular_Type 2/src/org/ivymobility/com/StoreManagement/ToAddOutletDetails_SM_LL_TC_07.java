package org.ivymobility.com.StoreManagement;

import java.util.concurrent.TimeUnit;

import org.ivymobility.com.base.TestBase;
import org.ivymobility.com.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToAddOutletDetails_SM_LL_TC_07 extends TestStoreManagementSuiteBase
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
	
		if(!TestUtil.isTestCaseRunnable(storeManagementSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(storeManagementSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	
	
	
	@Test(dataProvider="getTestData")
	public void test1(String NSM,String RSM,String SM,String TM,String ZM,String SE,String DIST,String code,String name,String national,String regional,String state,String territory,String zone,
			String subzone,String area,String location,String globalchannel,String channel,String subchannel,String retailertype,String firstName,String lastName,String addressType,String address1)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outletManagement")).click();
			APP_LOGS.info("Clicked on OutletManagement");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outletMaster")).click();
			APP_LOGS.info("Clicked on OutletMaster");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("outlet_ADD")).click();
			APP_LOGS.info("Clicked on ADD label");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("distributor_Filter")).click();
			APP_LOGS.info("Clicked on Distributor Filter");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			WebElement field_NSM=TestBase.getElement(driver, TestBase.OR.getProperty("NSM_Field"));
			
			if(field_NSM.isDisplayed())
			{
				Select a=new Select(field_NSM);
				a.selectByVisibleText(NSM);
				APP_LOGS.info("NSM field is available");
			}
			else
			{
				APP_LOGS.error("NSM field is not available");
			}
			
			
			
            WebElement field_RSM=TestBase.getElement(driver, TestBase.OR.getProperty("RSM_Field"));
			
			if(field_RSM.isDisplayed())
			{
				Select b=new Select(field_RSM);
				b.selectByVisibleText(RSM);
				APP_LOGS.info("RSM field is available");
			}
			else
			{
				APP_LOGS.error("RSM field is not available");
			}
			
			
            WebElement field_SM=TestBase.getElement(driver, TestBase.OR.getProperty("SM_Field"));
			
			if(field_SM.isDisplayed())
			{
				Select c=new Select(field_SM);
				c.selectByVisibleText(SM);
				APP_LOGS.info("SM field is available");
			}
			else
			{
				APP_LOGS.error("SM field is not available");
			}
			
           WebElement field_TM=TestBase.getElement(driver, TestBase.OR.getProperty("TM_Field"));
			
			if(field_TM.isDisplayed())
			{
				Select d=new Select(field_TM);
				d.selectByVisibleText(TM);
				APP_LOGS.info("TM field is available");
			}
			else
			{
				APP_LOGS.error("TM field is not available");
			}
			

	        WebElement field_ZM=TestBase.getElement(driver, TestBase.OR.getProperty("ZM_Field"));
				
			if(field_ZM.isDisplayed())
			{
				Select e=new Select(field_ZM);
				e.selectByVisibleText(ZM);
				APP_LOGS.info("ZM field is available");
			}
			else
			{
				APP_LOGS.error("ZM field is not available");
			}
				
			
			WebElement field_SE=TestBase.getElement(driver, TestBase.OR.getProperty("SE_Field"));
			
			if(field_SE.isDisplayed())
			{
				Select f=new Select(field_SE);
				f.selectByVisibleText(SE);
				APP_LOGS.info("SE field is available");
			}
			else
			{
				APP_LOGS.error("SE field is not available");
			}
			
	        WebElement field_DIST=TestBase.getElement(driver, TestBase.OR.getProperty("DIST_Field"));
			
			if(field_DIST.isDisplayed())
			{
				Select g=new Select(field_DIST);
				g.selectByVisibleText(DIST);
				APP_LOGS.info("DIST field is available");
			}
			else
			{
				APP_LOGS.error("DIST field is not available");
			}
				
			WebElement select_Button=TestBase.getElement(driver, TestBase.OR.getProperty("select_Field"));
			
			if(select_Button.isDisplayed())
			{
				select_Button.click();
				APP_LOGS.info("Clicked on Select button");
			}
			else
			{
				APP_LOGS.info("Select button is not available");
			}
			
			WebElement code_Field=TestBase.getElement(driver, TestBase.OR.getProperty("code_Field"));
			if(code_Field.isDisplayed())
			{
				code_Field.sendKeys(code);
			}
			else
			{
				APP_LOGS.info("code field is not available");
			}
			
			WebElement name_Field=TestBase.getElement(driver, TestBase.OR.getProperty("name_Field"));
			
			if(name_Field.isDisplayed())
			{
				name_Field.sendKeys(name);
			}
			else
			{
				APP_LOGS.info("Name field is not available");
			}
			
			
			Thread.sleep(3000);						
			WebElement loc_filter=TestBase.getElement(driver, TestBase.OR.getProperty("location_Filter"));
			if(loc_filter.isDisplayed())
			{
			  loc_filter.click();
			  APP_LOGS.info("Clicked on Location Filters");
			}
			else
			{
				APP_LOGS.info("Unable to click on Location Filters");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement national_Location=TestBase.getElement(driver, TestBase.OR.getProperty("national_Field"));
		
			if(national_Location.isDisplayed())
			{
				Select s1=new Select(national_Location);
				s1.selectByVisibleText(national);
			}
			else
			{
				APP_LOGS.info("National location field is not available");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement regional_Location=TestBase.getElement(driver, TestBase.OR.getProperty("regional_Field"));
			
			if(regional_Location.isDisplayed())
			{
				Select s2=new Select(regional_Location);
				s2.selectByVisibleText(regional);
			}
			else
			{
				APP_LOGS.info("Regional location field is not available");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement state_Location=TestBase.getElement(driver, TestBase.OR.getProperty("state_Field"));
			
			if(state_Location.isDisplayed())
			{
			  Select s3=new Select(state_Location);
			  s3.selectByVisibleText(state);
			}
			else
			{
				APP_LOGS.info("State location field is not available");
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement territory_Location=TestBase.getElement(driver, TestBase.OR.getProperty("territory_Field"));
			
			if(territory_Location.isDisplayed())
			{
			  Select s4=new Select(territory_Location);
			  s4.selectByVisibleText(territory);
			}
			else
			{
				APP_LOGS.info("Territory location field is not available");
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement zone_Location=TestBase.getElement(driver, TestBase.OR.getProperty("zone_FIeld"));
			
			Select s5=new Select(zone_Location);
			s5.selectByVisibleText(zone);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement subzone_Location=TestBase.getElement(driver, TestBase.OR.getProperty("subZone_Field"));
			
			Select s6=new Select(subzone_Location);
			s6.selectByVisibleText(subzone);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement area_Location=TestBase.getElement(driver, TestBase.OR.getProperty("area_Field"));
			
			Select s7=new Select(area_Location);
			s7.selectByVisibleText(area);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("location_Filter_button")).click();
			APP_LOGS.info("Clicked on Filter button in the Location screen");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
            WebElement location_Field=TestBase.getElement(driver, TestBase.OR.getProperty("location_Field"));
			
			/*Select s8=new Select(location_Field);
			s8.selectByVisibleText(location);*/
			
			Select s8=new Select(location_Field);
			s8.selectByVisibleText("1");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("subChannel_Filter")).click();
			APP_LOGS.info("Clicked on subChannel_Filter");
			
			
			WebElement global_Field=TestBase.getElement(driver, TestBase.OR.getProperty("global_Channel"));
				
			Select s9=new Select(global_Field);
			s9.selectByVisibleText(globalchannel);
				
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
			WebElement channel_Field=TestBase.getElement(driver, TestBase.OR.getProperty("channel"));
					
			Select s10=new Select(channel_Field);
			s10.selectByVisibleText(channel);
					
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("subChannel_Filter_Button")).click();
			APP_LOGS.info("Clicked on Filter button in the Channel filters screen");
			
			Thread.sleep(1000);
			
			WebElement subchannel_Field=TestBase.getElement(driver, TestBase.OR.getProperty("subChannel_Field"));

			Select s11=new Select(subchannel_Field);
			
			System.out.println(subchannel);
			s11.selectByVisibleText(subchannel);
			
			Thread.sleep(1000);
			
			WebElement retailertype_Field=TestBase.getElement(driver, TestBase.OR.getProperty("retailerType_Field"));
			
			Select s12=new Select(retailertype_Field);
			s12.selectByVisibleText(retailertype);
			
			Thread.sleep(1000);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("contact_Person_Tab")).click();
			APP_LOGS.info("Clicked on Contact person Tab");
			
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			TestBase.getElement(driver, TestBase.OR.getProperty("contact_Person_ADD")).click();
			APP_LOGS.info("Clicked on Contact person ADD label");
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("firstName_Field")).sendKeys(firstName);
			TestBase.getElement(driver, TestBase.OR.getProperty("latstName_Field")).sendKeys(lastName);
			TestBase.getElement(driver, TestBase.OR.getProperty("primary_contact_Person")).click();
			TestBase.getElement(driver, TestBase.OR.getProperty("saveButton_Contact_person")).click();
			APP_LOGS.info("Clicked on SAVE label in contact person add screen");
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			TestBase.getElement(driver, TestBase.OR.getProperty("address_Tab")).click();
			APP_LOGS.info("Clicked on Address tab");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("address_ADD")).click();
			APP_LOGS.info("Clicked on ADD label in Address tab");
			
			WebElement addressType_Field=TestBase.getElement(driver, TestBase.OR.getProperty("addressType_Field"));
			Select s13=new Select(addressType_Field);
			s13.selectByVisibleText(addressType);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("address1_Field")).sendKeys(address1);
			TestBase.getElement(driver, TestBase.OR.getProperty("primary_address")).click();
			TestBase.getElement(driver, TestBase.OR.getProperty("saveButton_Address")).click();
			APP_LOGS.info("Clicked on SAVE button in Address tab");
			
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			TestBase.getElement(driver, TestBase.OR.getProperty("SAVE")).click();
			APP_LOGS.info("Clicked on SAVE button");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			
			String actual=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON")).click();
			APP_LOGS.info("Clicked on OK button");
	
			Assert.assertEquals(actual, "Retailer details added successfully!");
			
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
		
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(storeManagementSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}
	

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(storeManagementSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(storeManagementSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(storeManagementSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(storeManagementSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(storeManagementSuitexls,this.getClass().getSimpleName());
				
		}	
	

	
	
}
