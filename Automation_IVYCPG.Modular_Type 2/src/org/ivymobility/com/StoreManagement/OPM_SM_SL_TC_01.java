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

public class OPM_SM_SL_TC_01 extends TestStoreManagementSuiteBase
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
	public void test1(String NSM,String RSM,String SM,String TM,String ZM,String SE,String DIST,
			String globalchannel,String channel,String subchannel,String national,String regional,
			String state,String territory,String zone,String subzone,String area,String location)
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
			
			TestBase.getElement(driver, TestBase.OR.getProperty("OPM_MENU")).click();
			APP_LOGS.info("Clicked on OutletPosition Mapping");
			
			WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty("frame"));
			driver.switchTo().frame(frame);
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement nsm=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_NSM"));
			
			if(nsm.isDisplayed())
			{
				Select a=new Select(nsm);
				a.selectByVisibleText(NSM);
				APP_LOGS.info("NSM is available");
			}
			else
			{
				APP_LOGS.error("NSM is not available");
			}
			
			
			
            WebElement rsm=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_RSM"));
			
			if(rsm.isDisplayed())
			{
				Select b=new Select(rsm);
				b.selectByVisibleText(RSM);
				APP_LOGS.info("RSM is available");
			}
			else
			{
				APP_LOGS.error("RSM is not available");
			}
			
			
			
            WebElement sm=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_SM"));
			
			if(sm.isDisplayed())
			{
				Select c=new Select(sm);
				c.selectByVisibleText(SM);
				APP_LOGS.info("SM is available");
			}
			else
			{
				APP_LOGS.error("SM is not available");
			}
			
			
			
            WebElement tm=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_TM"));
			
			if(tm.isDisplayed())
			{
				Select d=new Select(tm);
				d.selectByVisibleText(TM);
				APP_LOGS.info("TM is available");
			}
			else
			{
				APP_LOGS.error("TM is not available");
			}
			
			
            WebElement zm=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_ZM"));
			
			if(zm.isDisplayed())
			{
				Select e=new Select(zm);
				e.selectByVisibleText(ZM);
				
				APP_LOGS.info("ZM is available");
			}
			else
			{
				APP_LOGS.error("ZM is not available");
			}
	
			
            WebElement se=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_SE"));
			
			if(se.isDisplayed())
			{
				Select f=new Select(se);
				f.selectByVisibleText(SE);
				
				APP_LOGS.info("SE is available");
			}
			else
			{
				APP_LOGS.error("SE is not available");
			}
			
			
			
			
            WebElement dist=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_DIST"));
			
			if(dist.isDisplayed())
			{
				Select g=new Select(dist);
				g.selectByVisibleText(DIST);
				APP_LOGS.info("DIST is available");
			}
			else
			{
				APP_LOGS.error("DIST is not available");
			}
			
			
			Thread.sleep(3000);						
			WebElement channel_filter=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_channel_?"));
			if(channel_filter.isDisplayed())
			{
			  channel_filter.click();
			  APP_LOGS.info("Clicked on Channel Filters_?");
			}
			else
			{
				APP_LOGS.info("Unable to click on Channel Filters_?");
			}
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		
				
			
			WebElement gchl=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_GHCL"));
			
			if(gchl.isDisplayed())
			{
				Select s9=new Select(gchl);
				s9.selectByVisibleText(globalchannel);
				APP_LOGS.info("GCHL is available");
			}
			else
			{
				APP_LOGS.error("GCHL is not available");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
            WebElement chl=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_CHL"));
			
			if(chl.isDisplayed())
			{
				Select s10=new Select(chl);
				s10.selectByVisibleText(channel);
				APP_LOGS.info("CHL is available");
			}
			else
			{
				APP_LOGS.error("CHL is not available");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
			
			
			WebElement chl_Filter=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_channel_filter"));
				
			if(chl_Filter.isDisplayed())
			{
				chl_Filter.click();
				APP_LOGS.info("Clicked on Filters button in Channel filter screen");
			}
			else
			{
				APP_LOGS.info("Unavailable Filters button in Channel filter screen");
			}
				
			WebElement subchl=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_channel_Field"));
			
			if(subchl.isDisplayed())
			{
				Select s12=new Select(subchl);
				s12.selectByVisibleText(subchannel);
				APP_LOGS.info("Data is selected in subchannel dropdown");
			}
			else
			{
				APP_LOGS.info("Unavailable Filters field");
			}
		
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			APP_LOGS.info("Clicked on Location filter_? button");
			
            WebElement channel_Field=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_location_?"));
			
			if(channel_Field.isDisplayed())
			{
				channel_Field.click();
				APP_LOGS.info("Clicked on channel field");
			}
			else
			{
				APP_LOGS.info("Unavailable click on channel field");
			}
			
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			
			WebElement opm_National=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_NAT"));
				
			if(opm_National.isDisplayed())
			{
				Select s1=new Select(opm_National);
				s1.selectByVisibleText(national);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("National field is not available");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement opm_Regional=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_REG"));
			
			if(opm_Regional.isDisplayed())
			{
				Select s2=new Select(opm_Regional);
				s2.selectByVisibleText(regional);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("Regional field is not available");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
            WebElement opm_State=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_STATE"));
			
			if(opm_State.isDisplayed())
			{
				Select s3=new Select(opm_State);
				s3.selectByVisibleText(state);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("State field is not available");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			

            WebElement opm_Territory=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_TER"));
			
			if(opm_Territory.isDisplayed())
			{
				Select s4=new Select(opm_Territory);
				s4.selectByVisibleText(territory);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("Territory field is not available");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
            WebElement opm_Zone=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_ZONE"));
			
			if(opm_Zone.isDisplayed())
			{
				Select s5=new Select(opm_Zone);
				s5.selectByVisibleText(zone);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("Zone field is not available");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
            WebElement opm_SZ=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_SZ"));
			
			if(opm_SZ.isDisplayed())
			{
				Select s6=new Select(opm_SZ);
				s6.selectByVisibleText(subzone);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("Sub-Zone field is not available");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
            WebElement opm_AREA=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_AREA"));
			
			if(opm_AREA.isDisplayed())
			{
				Select s7=new Select(opm_AREA);
				s7.selectByVisibleText(area);
				APP_LOGS.info("Selected data in the dropdown");
			}
			else
			{
				APP_LOGS.info("Area field is not available");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
			
			WebElement location_Filter=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_LOC_FILTER"));
			
			if(location_Filter.isDisplayed())
			{
				location_Filter.click();
				APP_LOGS.info("Clicked on Filter button in the Location screen");
			}
			else
			{
				APP_LOGS.info("Unable Filter button in the Location screen");
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			/*Select s8=new Select(TestBase.getElement(driver, TestBase.OR.getProperty("OPM_LOC_Field")));
			s8.selectByVisibleText(location);
			*/
			
            WebElement location_Field=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_LOC_FILTER"));
			
			if(location_Field.isDisplayed())
			{
				Select s8=new Select(location_Field);
				s8.selectByVisibleText("1");
				APP_LOGS.info("Data is seleted in location field dropdown");
			}
			else
			{
				APP_LOGS.info("Unavailable to filter data  in the location field");
			}
			
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			WebElement load=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_LOAD"));
			
			if(load.isDisplayed())
			{
			
				load.click();
				APP_LOGS.info("Clicked on LOAD button");
			}
			else
			{
				APP_LOGS.info("LOAD button is not available");
			}
			
			Thread.sleep(1000);
			
			WebElement seller=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_SELLER"));
			
			if(seller.isDisplayed())
			{
			
				seller.click();
				APP_LOGS.info("Selected Seller in the grid");
			}
			
			else
			{
				APP_LOGS.info("Seller is not available in the grid");
			}
			
			WebElement position=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_POSITION"));
			
			if(position.isDisplayed())
			{
				position.click();
				APP_LOGS.info("Selected position in the position screen");

			}
			else
			{
				APP_LOGS.info("Position is not available");
			}
						
			WebElement apply=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_APPLY"));
			
			if(apply.isDisplayed())
			{
				apply.click();
				APP_LOGS.info("Clicked on the Apply label");
			}
			else
			{
				APP_LOGS.info("Apply label is not avaible in the grid");
			}
			
			Thread.sleep(1000);
			
			WebElement save_Label=TestBase.getElement(driver, TestBase.OR.getProperty("OPM_SAVE"));
			
			if(save_Label != null)
			{
			
				save_Label.click();
				APP_LOGS.info("Clicked on the SAVE label");
				
			}
			
			else
			{
				APP_LOGS.info("SAVE label unavailable");
			}
			
			
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
