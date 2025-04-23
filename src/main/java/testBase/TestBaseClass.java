package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperationClass;

public class TestBaseClass extends ActionEngine{
	
	BrowserFactory brf = new BrowserFactory();
	

	
	@BeforeMethod
	public void launchApplication() throws Exception {
		String browser = PropertiesOperationClass.getPropertyValueKey("browser");
		String url = PropertiesOperationClass.getPropertyValueKey("url");
		
		DriverFactory.getInstance().setDriver(brf.createBrowserInstance(browser));
		WebDriver driver=DriverFactory.getInstance().getDriver();
	
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.navigate().to(url);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

}
