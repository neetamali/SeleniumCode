package reusableComponents;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtendFactory;
import testBase.ExtentReportNGClass;

public class ListenersImplementations implements ITestListener {
static ExtentReports report;
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
test = report.createTest("Test1");
ExtendFactory.getInstance().setExtent(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtendFactory.getInstance().getExtent().log(Status.PASS, "Test case "+result.getMethod()+" is passed.");
		ExtendFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtendFactory.getInstance().getExtent().log(Status.FAIL, "Test case "+result.getMethod()+" is failed.");
		ExtendFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

	//add screenshot for failed test
		File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
	
	
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtendFactory.getInstance().getExtent().log(Status.SKIP, "Test case "+result.getMethod()+" is skipped.");
		ExtendFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 try {
			report = ExtentReportNGClass.setupExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
