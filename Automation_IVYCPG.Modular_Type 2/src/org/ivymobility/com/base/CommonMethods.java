package org.ivymobility.com.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonMethods {


    

    public static void navigate(WebDriver driver,String data)  // for navigation
    {
       
        try{
            driver.navigate().to(data);
        }catch(Exception e){
         e.printStackTrace();
        }
       
    }

    public static void actionsMoveTo(WebDriver driver,String object)    // to move the mouse pointer on specific webelement
    {
    	try{
    		
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    		  Actions a=new Actions(driver);
    		  a.moveToElement(element).build().perform();
    		}
    		else
    		{
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void actionsDoubleClick(WebDriver driver,String object)  // to double click on the webelement
    {
    	try{
    		
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    			Actions a=new Actions(driver);
    			a.doubleClick(element).build().perform();
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void actionsContextClick(WebDriver driver,String object)  // to right click on the webelement 
    {
    	try{
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    			Actions a=new Actions(driver);
    			a.contextClick(element).build().perform();
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void click(WebDriver driver,String object)    // for single click on webelement
    {
  	  try{
  		  
  		  WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
  		  
  		  if(element.isDisplayed())
  		  {
  			  element.click();
  		  }
  		  
  		  else
  		  {
  			  System.out.println("Element is not available");
  		  } 
  		  
  	  }
  	  catch(Exception e){
  		  
  		  e.printStackTrace();
            
        }
	
    }
    
    
    public static void fieldVerification(WebDriver driver,String object)   // for field verification
    {
    	try{
    		WebElement field=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(field.isDisplayed())
    		{
    			
    		}
    		else
    		{
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    public static void switchToFrame(WebDriver driver,String object)     // for switching into frame
    {
    
    	try{
    		WebElement frame=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		driver.switchTo().frame(frame);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void textField(WebDriver driver,String object,String data)  // for performing operations on text field
    {
    	try{
    		
    		WebElement field=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(field.isDisplayed())
    		{
    			field.clear();
        		field.sendKeys(data);
    		}
    		else
    		{
    			
    		}
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void buttonClick(WebDriver driver,String object)   // to click on button
    {
    	try{
    		
    		WebElement button=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    	    
    		if(button.isDisplayed())
    		{
    			button.click();
    		}
    		else
    		{
    			
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		
    	}
    }
    
    public static void isSelected(WebDriver driver,String object)     // to verify the radio button is selected or not
    {
    	try{
    		
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    		    if(element.isSelected())
    		    {
    		    	
    		    }
    		    else
    		    {
    		    	
    		    }
    		}
    		else
    		{
    			
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void selectDropDownByVisibletext(WebDriver driver,String object,String data)  // to select dropdown value based on visible text
    {
    	try
    	{
    		WebElement dropdown=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(dropdown.isDisplayed())
    		{
    			Select s=new Select(dropdown);
    			s.selectByVisibleText(data);
    		}
    		else
    		{
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void selectDropDownByValue(WebDriver driver,String object,String value)  // to select dropdown value based on value
    {
    	try{
    		
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    			Select s=new Select(element);
    			s.selectByValue(value);
    		}
    		else
    		{
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void selectDropDownByIndex(WebDriver driver,String object,int index)    // to select dropdown value based on index
    {
    	try{
    		
    		WebElement element=TestBase.getElement(driver, TestBase.OR.getProperty(object));
    		
    		if(element.isDisplayed())
    		{
    			Select s=new Select(element);
    			s.selectByIndex(index);
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void implicityWait(WebDriver driver,int time)   // for implicit wait
    {
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void threadSleep(int time)   // for explicit wait
    {
    	try
    	{
    		Thread.sleep(time);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void alertPopupAccept(WebDriver driver)  // to click on default button in alert popup
    {
    	try{
    		
    		Alert alert=driver.switchTo().alert();
    		alert.accept();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void alertPopupDismiss(WebDriver driver)  // to click on non default button in the popup
    {
    	try{
    		
    		Alert alert=driver.switchTo().alert();
    		alert.dismiss();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    public static void alertPopupContent(WebDriver driver,String data)  // to take text from the alert popup
    {
    	try{
    		Alert alert=driver.switchTo().alert();
    		String alertText=alert.getText();
    		
    		Assert.assertEquals(alertText, data);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void switchToDefaultContent(WebDriver driver)     // for switching into default content
    {
    	try{
    		driver.switchTo().defaultContent();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
	public static void popupTextVerification(WebDriver driver,String object,String data)  // to verify text in the popup
	{
		try{
			
			WebElement popupText=TestBase.getElement(driver, TestBase.OR.getProperty(object));
			
			if(popupText.isDisplayed())
			{
				String popupdata=popupText.getText();
				Assert.assertEquals(popupdata, data);
			}
			else
			{
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void clickonPopupButton(WebDriver driver,String object)     // to click button in the popup
	{
		try
		{
			WebElement popupButton=TestBase.getElement(driver, TestBase.OR.getProperty(object));
			
			if(popupButton.isDisplayed())
			{
				popupButton.click();
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	
}
