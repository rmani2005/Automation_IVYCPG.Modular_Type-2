package org.ivymobility.com.base;

import org.testng.AssertJUnit;




import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.ivymobility.com.utils.ErrorUtil;
import org.ivymobility.com.utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;




public class TestBase
{
	public static Logger APP_LOGS = null;
	public static Properties CONFIG = null;
	public static Properties OR = null;
	
	public static Xls_Reader suitexls=null;
	
	public static Xls_Reader userManagementSuitexls=null;
	public static Xls_Reader distributorSuitexls=null;
	
	public static Xls_Reader distributorHierarchySuitexls=null;
	public static Xls_Reader taxManagementSuitexls=null;
	public static Xls_Reader storeManagementSuitexls=null;
	public static Xls_Reader priceGroupsSuitexls=null;
	public static Xls_Reader productTaggingSuitexls=null;
	public static Xls_Reader digitalContentSuitexls=null;
	public static Xls_Reader demoSuitexls=null;
	
	
	public static WebDriver driver=null;
	
	public static boolean isinitialized = false;
	public static boolean isBrowserOpened= false;

	
	public static boolean pass=false;
	public static boolean fail=false;
	public static boolean skip=false;
	public static boolean isTestPass=true;
	
	// initializing the Tests
public static  void initialize() throws Exception
	
{
	if(!isinitialized)
	{
		
	
    // -----------------Initialize logs------------------
	APP_LOGS = Logger.getLogger("devpinoyLogger");
	//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	
	// -------------------Initialize config file---------------
			// CONFIG Properties 
	APP_LOGS.debug("Loading Properties files");   // Initialize properties files and putting them into log files.
	CONFIG = new Properties();
	
	FileInputStream ip = new FileInputStream("../Automation_IVYCPG/src/org/ivymobility/com/resources/config.properties");
	CONFIG.load(ip);
	System.out.println(CONFIG.getProperty("ScreenShotPath"));
			
			// OR Properties
    OR = new Properties();
	
    FileInputStream ip1 = new FileInputStream("../Automation_IVYCPG/src/org/ivymobility/com/resources/OR.properties");
	OR.load(ip1);
	
	APP_LOGS.debug("Loaded Properties files successfully");   // indicate that properties files are successfully loaded in the log files.
	
	// ------------------Initialize excel file------------------
	//System.out.println (System.getProperty("user.dir"));
	APP_LOGS.debug("Loading All Excel files.....");   // Initialize Excel files and indicating them into log files.
	suitexls = new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/Suite.xls");   //com.selenium.CodeManagement Suite is the name of Testsuite consists of TestSuitA, TestSuiteB & TestSuiteC
	
	userManagementSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/UserManagement.xls");
	
	distributorHierarchySuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/DistributorHierarchy.xls");
	
	taxManagementSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/TaxManagement.xls");
	
	storeManagementSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/StoreManagement.xls");
	
	priceGroupsSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/PriceGroups.xls");
	
	productTaggingSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/ProductTagging.xls");
	
	digitalContentSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/DigitalContent.xls");
	
	demoSuitexls=new Xls_Reader("../Automation_IVYCPG/src/org/ivymobility/com/xlsfiles/Demo.xls");
	
	APP_LOGS.debug("Loaded All Excel files successfully");   // indicate that Excel files are successfully loaded in the log files.
	
	isinitialized= true;
	pass = false;
	fail = false;
	skip = false;
	}
	
	
	
}
public static WebElement getElement(WebDriver driver, String locator){
	String[] objects=locator.split("-");
	
	String locatorType=objects[0];
	String locatorValue=objects[1];
	WebElement element = null;
	By by = null;
	
	if(locatorType.equals("clsName")){
		by=By.className(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
	}else if(locatorType.equals("cssSel")){
		by=By.cssSelector(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
	}else if(locatorType.equals("IDE")){
		by=By.id(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
	}else if(locatorType.equals("lnkTxt")){
		by=By.linkText(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
   }else if(locatorType.equals("name")){
		by=By.name(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
   }else if(locatorType.equals("plLinkTxt")){
		by=By.partialLinkText(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
   }else if(locatorType.equals("tagName")){
		by=By.tagName(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  
   }else if(locatorType.equals("XPH")){
		by=By.xpath(locatorValue);
		APP_LOGS.info("Element Identified : : " + by );  	
   }else {
	   APP_LOGS.error("Element not Identified");  
   }
	
	
   for(int i=0; i<10; i++){
	   if(driver.findElements(by).size()>0){
		   element =driver.findElement(by);
		   break;
		   
		   } else {
			   
		    
		
			}
	   }

	   return element;
   }



//-------------------Initialize WebDriver----------------

//Case 1:
// opening browser as per Config property file
public void openBrowser() throws InterruptedException
{
if (!isBrowserOpened)
	{
		if (CONFIG.getProperty("browserType").equals("firefox"))
		{
			driver=new FirefoxDriver();
			
	        driver.manage().window().maximize();
	       // loginCM();
		}
		else if (CONFIG.getProperty("browserType").equals("IE"))
		{
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        driver = new InternetExplorerDriver(ieCapabilities);
	       
		}
		else if (CONFIG.getProperty("browserType").equals("Chrome"))
			driver=new ChromeDriver();
		
		isBrowserOpened= true;
		
		String waitTime=CONFIG.getProperty("default_implicitlyWait");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime),TimeUnit.SECONDS);
	}
}

//***********************
// case 2:
//Closing the opened browser
//************************
public void closeBrowser()
	{
		driver.quit();	
		isinitialized = false;
		isBrowserOpened = false;
		
	}



//***********************
//case 3:
//function to check the Element Presence by string xpathkey available in config.proprty file
//************************



	public boolean checkElementPresence(String XpathKey)
{
	List<WebElement> elements=driver.findElements(By.xpath(CONFIG.getProperty(XpathKey)));
	 int count = elements.size();
	try
		{
		AssertJUnit.assertTrue(count>0);
		}
	catch (Throwable t)
	{
		ErrorUtil.addVerificationFailure(t);
		APP_LOGS.debug("No Element Present");
		return false;
	}
	
	return true;
	
}



//***********************
//case 4:
//function to check the Title of the webpage
//************************
public boolean compareTitle(String expectedVal)
{
	try
		{
		AssertJUnit.assertEquals(expectedVal, driver.getTitle());
		}
	catch (Throwable t)
	{
		ErrorUtil.addVerificationFailure(t);
		APP_LOGS.debug("Title of webElement Doesn't Matches");
		return false;
	}
	
	return true;
	
}


//***********************
//case 5:
//function to compare two numbers. 
//************************


public boolean compareNumbers(int expectedVal, int actualVal)
{
	try
		{
		AssertJUnit.assertEquals(expectedVal,actualVal);
		}
	catch (Throwable t)
	{
		ErrorUtil.addVerificationFailure(t);
		APP_LOGS.debug("Values of two numbers doesn't Matches");
		return false;
	}
	
	return true;
	
}
//***********************
//case 6:
//function to check 
//************************






//***********************
//case 10:
//function to getVerificationFailures 
//************************




	public static List<Throwable> getVerificationFailures()
	{
		return null;
	}

// Case: 11 - Login

public void adminLogin() throws InterruptedException
{
    driver.get(CONFIG.getProperty("baseUrl"));
   
    //"Code Map List".equals(driver.getTitle());
    WebElement usernameElement=TestBase.getElement(driver,TestBase.OR.getProperty("username"));
    if(usernameElement != null){
    usernameElement.sendKeys(CONFIG.getProperty("adminUsername"));
    APP_LOGS.info("Entered Data in username Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in username Input Field");	
	}
    
    
    
    WebElement passwordElement=TestBase.getElement(driver,TestBase.OR.getProperty("password"));
    if(passwordElement != null){
    passwordElement.sendKeys(CONFIG.getProperty("adminPassword"));
    APP_LOGS.info("Entered Data in Password Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in Password Input Field");	
	}
    
    WebElement loginButtonElement=TestBase.getElement(driver,TestBase.OR.getProperty("loginButton"));
    if(loginButtonElement != null){
    loginButtonElement.click(); 
    APP_LOGS.info("Clicked on Login Button");
	}else{
	APP_LOGS.error("Unable to Click on Login Button");	
	}
   
}

public void distributorLogin() throws InterruptedException
{
    driver.get(CONFIG.getProperty("baseUrl"));
   
    //"Code Map List".equals(driver.getTitle());
    WebElement usernameElement=TestBase.getElement(driver,TestBase.OR.getProperty("username"));
    if(usernameElement != null){
    usernameElement.sendKeys(CONFIG.getProperty("distributorUsername"));
    APP_LOGS.info("Entered Data in username Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in username Input Field");	
	}
    
    
    
    WebElement passwordElement=TestBase.getElement(driver,TestBase.OR.getProperty("password"));
    if(passwordElement != null){
    passwordElement.sendKeys(CONFIG.getProperty("distributorPassword"));
    APP_LOGS.info("Entered Data in Password Input Field");
	}else{
	APP_LOGS.error("Unable to Enter Data in Password Input Field");	
	}
    
    WebElement loginButtonElement=TestBase.getElement(driver,TestBase.OR.getProperty("loginButton"));
    if(loginButtonElement != null){
    loginButtonElement.click(); 
    APP_LOGS.info("Clicked on Login Button");
	}else{
	APP_LOGS.error("Unable to Click on Login Button");	
	}
   
}
public void openUrl(){
	driver.get(CONFIG.getProperty("url"));
}

// Case: 12 - TestLinkResults Updation


}