package Boutiqaat.Uttils.test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.crm.qa.utill.TestUtil;

import Boutiqaat.Uttils.test.TestUtills;
import Boutiqaat.Boutiqaat.TestBaseBoutiqaat;

 
public class TestListner extends TestBaseBoutiqaat implements ITestListener {
	//TestUtills testutill = new TestUtills(driver);
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println(result.getName()+" test case started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Passed is :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		// System.out.println("The name of the testcase failed is :" +result.getName());
		 try {
				TestUtills.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Skipped is :" +result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case percentage==" + result.compareTo(result));
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
