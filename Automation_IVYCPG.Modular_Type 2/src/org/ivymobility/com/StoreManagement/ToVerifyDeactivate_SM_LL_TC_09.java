package org.ivymobility.com.StoreManagement;

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

public class ToVerifyDeactivate_SM_LL_TC_09 extends TestStoreManagementSuiteBase
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
			
			Select a=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("NSM_Field")));
			a.selectByVisibleText(NSM);
			Select b=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("RSM_Field")));
			b.selectByVisibleText(RSM);
			Select c=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("SM_Field")));
			c.selectByVisibleText(SM);
			Select d=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("TM_Field")));
			d.selectByVisibleText(TM);
			Select e=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("ZM_Field")));
			e.selectByVisibleText(ZM);
			Select f=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("SE_Field")));
			f.selectByVisibleText(SE);
			Select g=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("DIST_Field")));
			g.selectByVisibleText(DIST);
			
			TestBase.getElement(driver, TestBase.OR.getProperty("select_Field")).click();
			APP_LOGS.info("Clicked on Select button");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("code_Field")).sendKeys(code);
			TestBase.getElement(driver, TestBase.OR.getProperty("name_Field")).sendKeys(name);
			
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
		
			Select s1=new Select(national_Location);
			s1.selectByVisibleText(national);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement regional_Location=TestBase.getElement(driver, TestBase.OR.getProperty("regional_Field"));
			
			Select s2=new Select(regional_Location);
			s2.selectByVisibleText(regional);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement state_Location=TestBase.getElement(driver, TestBase.OR.getProperty("state_Field"));
			
			Select s3=new Select(state_Location);
			s3.selectByVisibleText(state);
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement territory_Location=TestBase.getElement(driver, TestBase.OR.getProperty("territory_Field"));
			
			Select s4=new Select(territory_Location);
			s4.selectByVisibleText(territory);
			
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
			
			Thread.sleep(3000);
			
			driver.switchTo().frame(TestBase.getElement(driver, TestBase.OR.getProperty("frame")));
			
			Thread.sleep(1000);
			
			Select e1=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_NSM")));
			e1.selectByVisibleText(national);
			
			Select e2=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_RSM")));
			e2.selectByVisibleText(regional);
			
			Select e3=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_SM")));
			e3.selectByVisibleText(state);
			
			Select e4=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_TM")));
			e4.selectByVisibleText(territory);
			
			Select e5=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_ZM")));
			e5.selectByVisibleText(zone);
			
			Select e6=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_SZ")));
			e6.selectByVisibleText(subzone);
			
			Select e7=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_AREA")));
			e7.selectByVisibleText(area);
			
			Select e8=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("location_SUBAREA")));
			e8.selectByVisibleText(location);
			
			Thread.sleep(1000);
			TestBase.getElement(driver, TestBase.OR.getProperty("deactivate_Data-Selection")).click();
			APP_LOGS.info("Clicked on the data in grid");
			
			TestBase.getElement(driver, TestBase.OR.getProperty("deactivate_Label")).click();
			APP_LOGS.info("Clicked on Deactivate label");
			
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			
			String actual2=TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_CONTENT")).getText();
			TestBase.getElement(driver, TestBase.OR.getProperty("POPUP_BUTTON")).click();
			APP_LOGS.info("Clicked on OK button");
	
			Assert.assertEquals(actual2, "Retailer details deleted successfully!");
			
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
