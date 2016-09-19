package org.ivymobility.com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorUtil 
{

@SuppressWarnings("rawtypes")
private static Map<ITestResult,List> VerificationFailureMaps = new HashMap<ITestResult,List>();
@SuppressWarnings({ "rawtypes", "unused" })
private static Map<ITestResult,List> skipMap = new HashMap<ITestResult,List>();



public static void addVerificationFailure (Throwable e)
{
	//System.out.println("*******************add verification failure**************");
	List<Throwable> verificationFailures = getVerificationFailures();
	VerificationFailureMaps.put(Reporter.getCurrentTestResult(), verificationFailures);
	verificationFailures.add(e);
}



public static List<Throwable> getVerificationFailures()
{
	System.out.println("******************** get verification failures********************");
	List<Throwable> verificationFailures = getVerificationFailures();
return verificationFailures;
	


}

}


















