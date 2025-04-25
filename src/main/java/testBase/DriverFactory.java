package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	//ThreadLocal-->java.lang pkg -->Threading
	//singletone design pattern - only one instance exist ever,
	//global access to that instance by creating getInstance method

	//private constructor so no one else can create instance 
	private DriverFactory() {		
		
	}
	 private static DriverFactory driverfactinstance = new DriverFactory();
	 public static DriverFactory getInstance() {
		 return driverfactinstance;
		 
	 }
	
	 //factory design pattern --> design separate factory methods
	 //for creating objects and create objects by calling the methods
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
		
	}
	public void setDriver(WebDriver driverparam) {
		driver.set(driverparam);
	}
	
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}
	

}
