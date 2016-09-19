package org.ivymobility.com.usermanagementsuite;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.ivymobility.com.utils.ErrorUtil;
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



public class TestUserManagement extends TestUserManagementSuiteBase{
	
	
	
	

	// Run Mode of a test in a suite
	String runmodes[]=null; 
	static int count=-1;
	static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	
	
	@BeforeTest
	public void checkTestSkip() throws InterruptedException
	{
	
		if(!TestUtil.isTestCaseRunnable(userManagementSuitexls,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO "); // this information will appear in Log files generated.
			throw new SkipException("Skipping execution of"+this.getClass().getSimpleName()+" because runmode of test case set to NO ");  // this information will appear in TestNg report files generated.
		}
		// load the runmodes of the tests
		runmodes = TestUtil.getDataSetRunmodes(userManagementSuitexls,this.getClass().getSimpleName() );
		
		
	}
	
	@Test
	public void test1(){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y"))
		{
		skip= true;
		throw new SkipException("Run mode to test data was set to NO for row #" + count);
		}
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			WebElement element=driver.findElement(By.linkText("Tenant"));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.linkText("Master")).click();
		driver.switchTo().frame(driver.findElement(By.id("iContent")));
		
		driver.findElement(By.xpath(".//*[@id='treeboxbox_tree']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[4]/span")).click();
		
		driver.switchTo().frame(driver.findElement(By.id("iContent")));
	   List<WebElement> list=	driver.findElements(By.xpath("//td[contains(@class,'Ico')]"));
		System.out.println("" + list.size());
	   for (WebElement webElement : list) {
		   
		   
		   webElement.click();
		   System.out.println("Clicked on : : " + webElement.getText());
		   Thread.sleep(2000);
		  
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
		
			TestUtil.reportDataSetResult(userManagementSuitexls,this.getClass().getSimpleName(), count+2, "Skipped");
			
		
		else if(fail)
		{
			TestUtil.reportDataSetResult(userManagementSuitexls,this.getClass().getSimpleName(), count+2, "Fail");
			isTestPass= false;
		}
		else 
			TestUtil.reportDataSetResult(userManagementSuitexls,this.getClass().getSimpleName(), count+2, "Pass");
		skip = false;
		fail= false;
		pass= false;
		
	}

	@AfterTest


	public void reportTestResult()
	{
		
	
		
		if(isTestPass)
			TestUtil.reportTestResult(userManagementSuitexls, this.getClass().getSimpleName(),TestUtil.getRowNum(userManagementSuitexls, this.getClass().getSimpleName()), "Pass");
		else
			TestUtil.reportTestResult(userManagementSuitexls,this.getClass().getSimpleName(), TestUtil.getRowNum(userManagementSuitexls, this.getClass().getSimpleName()), "Fail");

	}


	@DataProvider
		
		public Object[][] getTestData()
		{
			return TestUtil.getdata(userManagementSuitexls,this.getClass().getSimpleName());
				
		}
	
	
	

}
