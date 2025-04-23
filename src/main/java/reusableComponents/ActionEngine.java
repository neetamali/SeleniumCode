package reusableComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import testBase.DriverFactory;
import testBase.ExtendFactory;

public class ActionEngine {
//sendkeys
//click
//mousehover
//selectClass
//radio button
	public void SendKeys_CustomMethod(WebElement ele, String val) {
//log success message
//log failure message
try {
	ele.sendKeys(val);	 
	ExtendFactory.getInstance().getExtent().log(Status.PASS, val+" is pass to "+ ele.getText()) ;
}catch(Exception e) {
	ExtendFactory.getInstance().getExtent().log(Status.FAIL, "Value entered in the field is failed "+val + " due to exception");
}
	}

	public void click_custom(WebElement ele, String fieldname) {
		try {
			ExtendFactory.getInstance().getExtent().log(Status.PASS, fieldname+"-- clicked");
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, fieldname+" unable to click on due to exception "+e);
		}
		
	}
	
	public void clear_custom(WebElement ele, String fieldname) {
		try {
			ele.clear();
			Thread.sleep(250);
			ExtendFactory.getInstance().getExtent().log(Status.PASS, fieldname+"-- data cliered successfully");
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, fieldname+" unable to clear due to exception "+e);
		}
		
	}
	
	public void moveToElement_custom(WebElement ele, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions act = new Actions(DriverFactory.getInstance().getDriver());
			act.moveToElement(ele).build().perform();
			ExtendFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Mouse hovered successfully");
			Thread.sleep(1000);
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" Unable to mouse hovered.");
		}
	}
	
	public boolean isElementPresent_custom(WebElement ele, String fieldname) {
		
		boolean flag= false;
		try {
		flag=ele.isDisplayed();
		ExtendFactory.getInstance().getExtent().log(Status.PASS, fieldname+" present");
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, fieldname+" not present "+e);
			
		}
		return flag;
	}
	public void selectDropDownValue(WebElement ele, String fieldname, String ddValue)
	{
		try {
			Select sel = new Select(ele);
			sel.selectByValue(ddValue);
			ExtendFactory.getInstance().getExtent().log(Status.PASS, ddValue+" value selected");
			
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, ddValue+" not present "+e);
		}
		
	}
	
	public void assertEqualmethod(String actualvalue, String expectedval, String locatorname)
	{
		try {
			org.testng.Assert.assertEquals(expectedval, actualvalue);
			ExtendFactory.getInstance().getExtent().log(Status.PASS, actualvalue+" matches the expected value "+expectedval);
			
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, actualvalue+" not matching with  "+expectedval+e);
		}
		
	}

	
public String getText_custom(WebElement ele, String fieldname) {
		
		String text= "";
		try {
		text=ele.getText();
		ExtendFactory.getInstance().getExtent().log(Status.PASS, fieldname+" has text "+text);
		}catch(Exception e) {
			ExtendFactory.getInstance().getExtent().log(Status.FAIL, fieldname+" has text "+text+e);
			
		}
		return text;
	}
	
}
