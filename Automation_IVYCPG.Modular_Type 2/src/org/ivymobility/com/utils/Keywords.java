package org.ivymobility.com.utils;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;




public class Keywords {
	public static Properties CONFIG = null;
    public WebDriver driver;


    

    public void navigate(String object,String data){
       
        try{
            driver.navigate().to(data);
        }catch(Exception e){
         
        }
       
    }

    public void clickLink(String object,String data){
       
        try{
            driver.findElement(By.xpath(object)).click();
        }catch(Exception e){
            
        }

       
    }

    public void clickLinkCss(String object){
       
        try{
            driver.findElement(By.cssSelector(object)).click();
        }catch(Exception e){
           
        }

       
    }

    public void clickLink_linkText(String object){
    	  try{
        driver.findElement(By.linkText((object))).click();

    	  }catch(Exception e){
              
          }
    
    

    
}


    public  void verifyLinkText(String object,String data){
        
        try{
            String actual=driver.findElement(By.xpath((object))).getText();
            String expected=data;

            if(actual.equals(expected));
                
             
        }catch(Exception e){
            

        }

    }


    public  void clickButton(String object,String data){
       
        try{
            driver.findElement(By.xpath(object)).click();
        }catch(Exception e){
           
        }


       
    }

    public  void clickButtonCss(String object,String data){
       
        try{
            driver.findElement(By.cssSelector(object)).click();
        }catch(Exception e){
            
        }
		


       
    }

    public  void verifyButtonText(String object,String data){
     
        try{
            String actual=driver.findElement(By.xpath(object)).getText();
            String expected=data;

            if(actual.equals(expected));
               
        }catch(Exception e){
           
        }

    }

    public  void selectList(String object, String data){
     
        try{
          
                // logic to find a random value in list
                WebElement droplist= driver.findElement(By.xpath(object));
                List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
                Random num = new Random();
                int index=num.nextInt(droplist_cotents.size());
                String selectedVal=droplist_cotents.get(index).getText();

                driver.findElement(By.xpath(object)).sendKeys(selectedVal);
            
        }catch(Exception e){
            

        }}

       
    

    public void verifyAllListElements(String object, String data){
       
        try{
            WebElement droplist= driver.findElement(By.xpath(object));
            List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));

            // extract the expected values from OR. properties
            String temp=data;
            String allElements[]=temp.split(",");
            // check if size of array == size if list
            if(allElements.length != droplist_cotents.size())
                

            for(int i=0;i<droplist_cotents.size();i++){
                if(!allElements[i].equals(droplist_cotents.get(i).getText())){
                   
                }
            }
        }catch(Exception e){
           

        }


       
    }

    public  void verifyListSelection(String object,String data){
        
        try{
            String expectedVal=data;
            //System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
            WebElement droplist= driver.findElement(By.xpath(object));
            List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
            String actualVal=null;
            for(int i=0;i<droplist_cotents.size();i++){
                String selected_status=droplist_cotents.get(i).getAttribute("selected");
                if(selected_status!=null)
                    actualVal = droplist_cotents.get(i).getText();
            }

            if(!actualVal.equals(expectedVal));
               

        }catch(Exception e){
            

        }
       

    }

    public  void selectRadio(String object, String data){
        
        try{
          
            driver.findElement(By.xpath(object)).click();
        }catch(Exception e){
        

        }

       

    }

    public  void verifyRadioSelected(String object, String data){
     
        try{
            String temp[]=object.split("");
            String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
        
               


        }catch(Exception e){


        }

       

    }


    public  void checkCheckBox(String object,String data){
        
        try{
            // true or null
            String checked=driver.findElement(By.id(object)).getAttribute("checked");
            if(checked==null)// checkbox is unchecked
                driver.findElement(By.xpath((object))).click();
        }catch(Exception e){
          
        }
      

    }

    public void unCheckCheckBox(String object,String data){
      
        try{
            String checked=driver.findElement(By.xpath((object))).getAttribute("checked");
            if(checked!=null)
                driver.findElement(By.xpath((object))).click();
        }catch(Exception e){
          
        }
     

    }


    public  void verifyCheckBoxSelected(String object,String data){
       
        try{
            String checked=driver.findElement(By.xpath((object))).getAttribute("checked");
          
           
            

        }catch(Exception e){
            

        }


    }


    public void verifyText(String object, String data){
        
        try{
            String actual=driver.findElement(By.xpath(object)).getText();
            String expected=data;

           Assert.assertEquals(actual, expected);
                
            
        }catch(Exception e){
           
        }

    }

    public  void writeInInput(String object,String data){
    

        try{
            driver.findElement(By.xpath((object))).sendKeys(data);
        }catch(Exception e){
           

        }
        

    }

    public  void writeInInputCss(String object,String data){
       

        try{
            driver.findElement(By.cssSelector((object))).sendKeys(data);
        }catch(Exception e){
           

        }
       

    }

    public  void verifyTextinInput(String object,String data){
     
        try{
            String actual = driver.findElement(By.xpath(object)).getAttribute("value");
            String expected=data;

            
             
           

        }catch(Exception e){
            

        }
    }

    



    public  void verifyTitle(String object, String data){
       
        try{
            String actualTitle= driver.getTitle();
            String expectedTitle=data;
           
             
           
        }catch(Exception e){
            
        }
    }

    public void exist(String object,String data){
        
        try{
            driver.findElement(By.xpath(object));
        }catch(Exception e){
           
        }


       
    }

    public  void click(String object,String data){
     
        try{
            driver.findElement(By.xpath((object))).click();
        }catch(Exception e){
           
        }
       
    }

    public  void clickCss(String object,String data){
      
        try{
            driver.findElement(By.cssSelector(object)).click();
        }catch(Exception e){
          
        }
        
    }

    public  void synchronize(String object,String data){
       
        ((JavascriptExecutor) driver).executeScript(
                "function pageloadingtime()"+
                        "{"+
                        "return 'Page has completely loaded'"+
                        "}"+
                        "return (window.onload=pageloadingtime());");

    }

    public  void waitForElementVisibility(String object,String data){
       
        int start=0;
        int time=(int)Double.parseDouble(data);
        try{
            while(time == start){
                if(driver.findElements(By.xpath(object)).size() == 0){
                    Thread.sleep(1000L);
                    start++;
                }else{
                    break;
                }
            }
        }catch(Exception e){
            
        }
        
    }

    public  void closeBrowser(String object, String data){
     
        try{
            driver.close();
        }catch(Exception e){
           
        }
        

    }

    public  void deleteAllCookies(String object, String data){
       
        try{
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        }catch(Exception e){
           
        }
       

    }



    public  void quitBrowser(String object, String data){
      
        try{
            driver.quit();
        }catch(Exception e){
            
        }
       

    }

    public void pause(String object, String data) throws NumberFormatException, InterruptedException{
        long time = (long)Double.parseDouble(object);
        Thread.sleep(time*1000L);
       
    }


    /************************APPLICATION SPECIFIC KEYWORDS********************************/
    public  void myAccountDropList(String object, String data){
       
        try {
            WebElement myAccountDropList = driver.findElement(By.cssSelector("#userAccount"));
            List<WebElement> list = myAccountDropList.findElements(By.cssSelector(".dropdown-menu>li>a"));
            list.get(1).click();

        }catch(Exception e){
           

        }

        
    }


    public  void selectCreditCard(String object, String data){
        

        int num = Integer.parseInt(data);

        try {
            List<WebElement> selectSize = driver.findElements(By.xpath(object));
            selectSize.get(num).click();

        }catch(Exception e){
            

        }

       
    }

    public  void enter(String object, String data){
       
        try{
            driver.findElement(By.xpath(object)).sendKeys(Keys.ENTER);
        }catch(Exception e){
            
        }
        

    }

    public  void tab(String object, String data){
       
        try{
            driver.findElement(By.xpath(object)).sendKeys(Keys.TAB);
        }catch(Exception e){
            
        }
       

    }

    public  void enterCss(String object, String data){
       
        try{
            driver.findElement(By.cssSelector(object)).sendKeys(Keys.ENTER);
        }catch(Exception e){
            
        }
       

    }


    public void windowHandler(String object, String data){
       
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try{
            String mainWindowHandle=driver.getWindowHandle();
            driver.findElement(By.xpath(object)).click();
            Set<String> window = driver.getWindowHandles();
            Iterator<String> iterator= window.iterator();

            while(iterator.hasNext())
            {
                String popupHandle=iterator.next().toString();
                if(!popupHandle.contains(mainWindowHandle))
                {
                    driver.switchTo().window(popupHandle);
                }
            }

            // Back to main window
            // driver.switchTo().window(mainWindowHandle);

        }catch(Exception e){
           
        }
        

    }

    public  void click_JS(String object,String data){
        
        try {
            ((JavascriptExecutor)driver).executeScript("document.getElementById('"+object+"').click()");
        } catch (Exception e) {
            
        }
        
    }

    public  void writeInInput_JS(String object,String data){
        
        try {
            ((JavascriptExecutor)driver).executeScript("document.getElementById('"+object+"').value='"+data+"'");
        } catch (Exception e) {
           
        }
        
    }

    // << Go back one page
    public  void goBack(String object, String data){
       
        try{
            driver.navigate().back();
        }catch(Exception e){
           
        }
       

    }

    // >> Go to forward one page
    public  void goForward(String object, String data){
       
        try{
            driver.navigate().forward();
        }catch(Exception e){
           
        }
       

    }

    // Verify list of items after clicking on drop-down list like Newborn, Shoes etc.
    public  void verifyAllItems(String object,String data){
       
        try{
            for (int i = 0; i <=150; i++) {
                List<WebElement> gridBoxes = driver.findElements(By.className("events-div"));
                System.out.println("Number of boxes " + gridBoxes.size());
                // Pick random link box
                Random gridnum = new Random();
                int grids = gridnum.nextInt(gridBoxes.size());
                WebElement grid = gridBoxes.get(grids);
                //WebElement box = link_boxes.get(0);
                List<WebElement> ItemBoxes = grid.findElements(By.className("product-image"));
                System.out.println("Total links are -- " + ItemBoxes.size());
                // Pick random item
                Random itemnum = new Random();
                int items = itemnum.nextInt(ItemBoxes.size());
                WebElement item = ItemBoxes.get(items);
                item.click();
                Thread.sleep(4000L);
                System.out.println(driver.getTitle());
                driver.navigate().back();

            }
        }catch(Exception e){
            
        }
       
    }

    // Credit Card functionality at the CheckOut
    public  void selectExpMonth(String object, String data){
        
        try {
            WebElement states = driver.findElement(By.xpath(object));
            List<WebElement> state = states.findElements(By.tagName("option"));
            Random num = new Random();
            int index=num.nextInt(state.size());
            state.get(index).click();
        }catch(Exception e){
            

        }

        
    }
    // Credit Card functionality at the CheckOut
    public  void selectExpYear(String object, String data){
        
        try {
            WebElement states = driver.findElement(By.xpath(object));
            List<WebElement> state = states.findElements(By.tagName("option"));
            Random num = new Random();
            int index=num.nextInt(state.size());
            state.get(index).click();
        }catch(Exception e){
            

        }

        
    }
    // Credit Card functionality at the CheckOut
    public  void selectAmex(String object, String data){
        
        try {
            WebElement size = driver.findElement(By.xpath(object));
            List<WebElement> selectSize = size.findElements(By.tagName("option"));
            selectSize.get(0).click();

        }catch(Exception e){
            

        }

       
    }
    // Credit Card functionality at the CheckOut
    public  void selectVisa(String object, String data){
        
        try {
            WebElement size = driver.findElement(By.xpath(object));
            List<WebElement> selectSize = size.findElements(By.tagName("option"));
            selectSize.get(1).click();

        }catch(Exception e){
            

        }

        
    }
    // Credit Card functionality at the CheckOut
    public  void selectMasterCard(String object, String data){
       
        try {
            WebElement size = driver.findElement(By.xpath(object));
            List<WebElement> selectSize = size.findElements(By.tagName("option"));
            selectSize.get(2).click();

        }catch(Exception e){
            

        }

      
    }

    public  void selectRandomState(String object, String data){
       
        try {
            WebElement states = driver.findElement(By.xpath(object));
            List<WebElement> state = states.findElements(By.tagName("option"));
            Random num = new Random();
            int index=num.nextInt(state.size());
            state.get(index++).click();
        }catch(Exception e){
           

        }

      
    }

    public  void selectEvent(String object, String data){
       
        try {
            WebElement eventList = driver.findElement(By.xpath("//*[@id='events-live']/ul"));
            List<WebElement> events = eventList.findElements(By.xpath("//*[@class='event-link']"));

            int time = Integer.parseInt(object);

            if (events.size() == 0) {
               

            }else{
                events.get(time).click();
            }

        }catch(Exception e){
           

        }

        
    }

    public  void selectRandomEvent(String object, String data){
       
        try {
            List<WebElement> events = driver.findElements(By.xpath("//*[@id='events-live']/ul/li[not(@style)]/a"));
            Random num = new Random();
            int index=num.nextInt(events.size());
            WebElement menu = events.get(index);
            Actions builder = new Actions(driver);
            builder.moveToElement(menu).build().perform();
            menu.click();


        }catch(Exception e){
           

        }

        
    }

    public  void selectProduct(String object, String data){
        

        int time = Integer.parseInt(object);

        try {
            List<WebElement> items = driver.findElements(By.xpath("//*[@class='product-image']"));
            if (items.size() == 0) {
               
                driver.navigate().back();
                selectRandomEvent(object, data);
                selectRandomProduct(object, data);

            }else{
                items.get(time).click();
            }
        }catch(Exception e){
            

        }

        
    }

    public  void selectRandomProduct(String object, String data){
        
        try {
            List<WebElement> items = driver.findElements(By.xpath("//*[@class='thumbnail'][not(@status_sold_out)]/a"));
            Random num = new Random();
            int index=num.nextInt(items.size());
            items.get(index).click();

        }catch(Exception e){
            

        }

        
    }

    public  void selectRandomColor(String object, String data){
       
        try {
            WebElement color = driver.findElement(By.xpath("//*[@id='attribute85']"));
            List<WebElement> selectColor = color.findElements(By.tagName("option"));
            selectColor.get(1).click();

        }catch(Exception e){
            

        }

        
    }

    public  void selectRandomSize(String object, String data){
       
        try {
            WebElement size = driver.findElement(By.xpath("//*[@id='attribute169']"));
            List<WebElement> selectSize = size.findElements(By.tagName("option"));
            selectSize.get(1).click();

        }catch(Exception e){
           

        }

       
    }


    public  void chrodKeys(String object,String data){
       

        try{
            driver.findElement(By.xpath(object)).sendKeys(Keys.chord(data));
        }catch(Exception e){
            

        }
       

    }

    public  void chrodKeysCss(String object,String data){
       

        try{
            driver.findElement(By.cssSelector(object)).sendKeys(Keys.chord(data));
        }catch(Exception e){
           

        }
        

    }

    public  void clearInputText(String object,String data){
       

        try{
            driver.findElement(By.xpath(object)).clear();
        }catch(Exception e){
            

        }
       

    }

    public  void clearInputText_css(String object,String data){
       

        try{
            driver.findElement(By.cssSelector(object)).clear();
        }catch(Exception e){
           

        }
       

    }

    public  void mouseHover(String object, String data){
       
        try{

            Thread.sleep(3000L);
            WebElement menu = driver.findElement(By.xpath(object));
            Actions builder = new Actions(driver);
            builder.moveToElement(menu).build().perform();

        }catch(Exception e){
           
        }
       

    }

    public  void mouseHoverCss(String object, String data){
        
        try{

            Thread.sleep(3000L);
            WebElement menu = driver.findElement(By.cssSelector(object));
            Actions builder = new Actions(driver);
            builder.moveToElement(menu).build().perform();

        }catch(Exception e){
            
        }
       

    }

    public  void doubleClick(String object, String data){
       
        try{

            Thread.sleep(3000L);
            WebElement menu = driver.findElement(By.xpath(object));
            Actions builder = new Actions(driver);
            builder.doubleClick(menu).build().perform();

        }catch(Exception e){
            
        }
       

    }

  


    
     




    


    public void verifySearchResults(String object,String data){
        
        try{
            data=data.toLowerCase();
            for(int i=3;i<=5;i++){
                String text=driver.findElement(By.xpath("search_result_heading_start")).getText();
                if(text.indexOf(data) == -1){
                   
                }
            }

        }catch(Exception e){
           
        }

       


    }


    // not a keyword

    public void captureScreenshot(String filename, String keyword_execution_result) throws IOException{
        // take screen shots
        if(CONFIG.getProperty("screenshot_everystep").equals("Y")){
            // capturescreen

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));

        }else if (keyword_execution_result.startsWith("KEYWORD_FAIL") && CONFIG.getProperty("screenshot_error").equals("Y") ){
            // capture screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
        }
    }
}
