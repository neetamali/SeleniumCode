package tests;

import org.testng.annotations.Test;

import pageObjects.Rahulshettyacademy_LoginpageO;
import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBaseClass;

public class TestCasesClass extends TestBaseClass {
	Rahulshettyacademy_LoginpageO login_obj = new Rahulshettyacademy_LoginpageO(DriverFactory.getInstance().getDriver());
	
	@Test
	public void TestCase1() {
		
		
		
		
System.out.println("First test case");
MyLogger.startTestCase(new Throwable().getStackTrace()[0].getModuleName());
MyLogger.info("Test case 1");
	}
	
	@Test
	public void TestCase2() {
System.out.println("Second Test case");
MyLogger.startTestCase(new Throwable().getStackTrace()[0].getModuleName());
MyLogger.info("Test case 2");
	}
}
