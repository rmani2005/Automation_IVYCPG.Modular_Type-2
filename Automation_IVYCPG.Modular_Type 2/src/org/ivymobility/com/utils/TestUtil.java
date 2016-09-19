package org.ivymobility.com.utils;



public class TestUtil 
{
	
	
//Case 1:- Prepare function to check  Run mode of a com.selenium.CodeManagement Suite - isSuiteRunnable	
	// find if the test suite is runnable......  where first test suite in Suite.xls is TestSuiteA
	public static boolean isSuiteRunnable(Xls_Reader excel,String suiteName)  //first test suite in Suite.xls is TestSuiteA
			
	{
	//finds if the test suite is runnable

	boolean isExecutable=false;
	for (int x=2; x<=excel.getRowCount("TestSuiteSheet"); x++)  // test sheet name is "TestSuiteSheet" in the file suite.xls
	  {
		System.out.println((excel.getCellData ("TestSuiteSheet", "TSID", x))+"------"+(excel.getCellData ("TestSuiteSheet", "Runmode", x)));
		
		String suite = excel.getCellData ("TestSuiteSheet", "TSID", x);
		String runmode = excel.getCellData ("TestSuiteSheet", "Runmode", x);

		if(suite.equals(suiteName))
		 {
		if(runmode.equalsIgnoreCase("Y"))
			{
			isExecutable=true;
			}
		else if(runmode.equalsIgnoreCase("N"))
			{
			isExecutable = false;
			}

	     }
	  }
	excel=null;
	return isExecutable ;
	}
	
 // up to this.... to get the run mode equals to true or false-------------

//-----------------------------------------------------------------------------------
	
//Case 2:-	Prepare function to check Run mode of a com.selenium.CodeManagement Case in com.selenium.CodeManagement Suite - isTestCaseRunnable
	
//returns true if run mode of the test case is equals to "y"
	//pre- requisits:
	//provide path of the TestSuiteA.xls File as --> Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+ "\\src\\com\\selenium\\xls\\TestSuiteA.xls");  
    //it returns "true" if the "Runmode" of the testCaseName ("TestCaseA3") available in the testSuite ("TestSuiteA.xls")
	
public static boolean isTestCaseRunnable(Xls_Reader excel,String testCaseName){
	  
	boolean isExecutable=false;
	//  in TestSuiteA.xls and TestSuiteB.xls should have sheet name consistent as testcase
	for (int x=2; x<=excel.getRowCount("testcase"); x++)
	{
		System.out.println((excel.getCellData ("testcase","TCID",x))+"------"+(excel.getCellData ("testcase","Runmode",x)));
				
		if(excel.getCellData("testcase","TCID",x).equalsIgnoreCase(testCaseName))
		{
			if (excel.getCellData("testcase","Runmode",x).equalsIgnoreCase("Y"))
			{
				isExecutable=true;
			}
			else if(excel.getCellData("testcase","Runmode",x).equalsIgnoreCase("N"))
			{
				isExecutable=false;	
			}	
		
		}
	}
	
	return isExecutable;
	}

// up to this.... line to check if runmode of the test case is equals to "y"


//----------------------------------------------------------------------------------------------

//Case 3:-  Prepare function to return testdata for a test case in two dim array - getData


//return the test data from a test in 2 dimensional (nxn) array


//Pre- condition's:
//provide the path of the corresponding testSuite (TestSuiteA.xls) which contains the testcasesheet from which testdata is to be obtained (testcasesheet should match testCaseName)  --> Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+ "\\src\\com\\selenium\\xls\\TestSuiteA.xls");  
//Provide the corresponding testcaseSheet name available in the testCaseName --> ("TestCaseA3") available in the testSuite ("TestSuiteA.xls") 
public static Object[][] getdata(Xls_Reader excel,String testCaseName)  // from the excel sheet with test sheet name = TestcaseName
{
//Pre- condition's:
//TestCaseA should have corresponding sheet with same name "TestCaseA" should be available in that TestSuiteA.xls
// if the test case with name TestCaseA doesn't have corresponding sheet name this means test case has no data and this program will execute only once.
// otherwise it will extract all the data from the corresponding sheet (matching testcase name: TestCaseA sheet in TestSuiteA.xls file


//   a test case will execute only n number of times, where n is the array number (number of rows) in the Object

	if(! excel.isSheetExist(testCaseName))  // if sheet with same name "TestCaseName" doesn't exists then this function will return [! false] which is true and therefore go inside the if loop )
				{
					excel=null;  // for memory clean up
					return new Object[1][0];   // and it returns and object array with one row and zero column will return  i.e hypothetical array.
					                            // we are making sure that atleast once the test will execute
				
				}


	// if sheet is existing with name testCaseName
int rows = excel.getRowCount(testCaseName);  				 // from the testcaseName= TestCaseA sheet 
int columns = excel.getColumnCount(testCaseName);


 Object[][] data =new Object[rows-1][columns-3];
// extract data from cell
 for (int rowNum =2;rowNum<= rows;rowNum++)
	{
		for (int ColNum =0;ColNum<= columns-4;ColNum++)
		{
		//System.out.print(excel.getCellData(TestCaseA, ColNum, rowNum)+ "----");
			data[rowNum-2][ColNum]= excel.getCellData(testCaseName, ColNum, rowNum); // columns-3 because last 3 columns will record runmode, results and error due to failure 
	}
		//System.out.println();
}
	
 return data;


}



// up to this to.... return the test data from a test in 2 dimensional (nxn) array

//--------------------------------------------------------
//case 4:
// Make a function to Check the runmode for datasets

public static String[] getDataSetRunmodes (Xls_Reader excel,String sheetName)
	{
	String[]Runmode= null;
		if(!excel.isSheetExist(sheetName))	
		{
			excel=null;
			sheetName=null;
			Runmode = new String [2];
			Runmode[0]= "Y";
			Runmode[1]= "N";
			
			excel=null;
			sheetName=null;
			return Runmode;
		}
		Runmode= new String [excel.getRowCount(sheetName)-1] ;
	for(int i = 2; i<=Runmode.length+1;i++)
		{
		Runmode[i-2]= excel.getCellData(sheetName, "Runmode", i);
		
		}
		excel=null;
		sheetName=null;
		return Runmode;
	}





//up to this to.... check the runmode for datasets
//--------------------------------------------------------
//case 5:
//Make a function to Update the Results column in testCaseName sheet - reportTestResult


//Update Results for a particular dataset 
public static void reportTestResult(Xls_Reader excel, String testCaseName, int rowNum, String Results)
				{
				excel.setCellData("testcase", "Results", rowNum, Results);
				}	




//up to this to.... to update the "Results" column in testcasesheet
//----------------------------------------------------------------------------

// case 6:
//Make a function to Update the result column in data sheet - reportDataSetResult


//Update Results for a particular dataset 
public static void reportDataSetResult(Xls_Reader excel, String testCaseName, int rowNum, String Results)
				{	
				excel.setCellData(testCaseName,"Results",rowNum,Results);
				}	




//up to this to.... to update the "Results" column in testcase sheet
//----------------------------------------------------------------------------


// case 7:

// return the row number for a test

public static int getRowNum(Xls_Reader excel,String id)
  {
	for (int x=2; x<=excel.getRowCount("testcase"); x++)
		{
		String tcid = excel.getCellData("testcase","TCID",x);
		
		if(tcid.equalsIgnoreCase(id))
			{
			excel= null;
			return x;
			}
		}

	return -1;
  }

}

//up to this to.... to update the "Results" column in testcasesheet
//----------------------------------------------------------------------------



