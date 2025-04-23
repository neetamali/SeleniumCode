package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtendFactory {
	//ThreadLocal-->java.lang pkg -->Threading
		//singletone design pattern - only one instance exist ever,
		//global access to that instance by creating getInstance method

		//private constructor so no one else can create instance 
		private ExtendFactory() {
			
			
			
		}
		 private static ExtendFactory extentfactinstance = new ExtendFactory();
		 public static ExtendFactory getInstance() {
			 return extentfactinstance;
			 
		 }
		
		 //factory design pattern --> design separate factory methods
		 //for creating objects and create objects by calling the methods
		ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
		
		public ExtentTest getExtent() {
			return extent.get();
			
		}
		public void setExtent(ExtentTest extentTestObject) {
			extent.set(extentTestObject);
		}
		
		public void removeExtentObject() {
			extent.remove();
		}
}
