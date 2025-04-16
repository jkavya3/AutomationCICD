package FrameWorkDesign.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

	int count=0;
	int maxTry=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<maxTry)//method reruns if it returns true
		{
			count++;
			return true;
		}
		return false;
	}

}
