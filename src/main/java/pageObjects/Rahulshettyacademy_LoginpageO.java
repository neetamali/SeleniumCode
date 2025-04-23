package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Logical_program.SendKeys_Alternative;
import testBase.TestBaseClass;

public class Rahulshettyacademy_LoginpageO {
	//@FindBy(id="userEmail") WebElement username;
	//@FindBy(id="userPassword") WebElement password;
	//@FindBy(id="login") WebElement loginbtn;
	
	By username = By.id("userEmail");
	By password = By.id("userPassword");
	By loginbtn = By.id("login");
	
	
	public Rahulshettyacademy_LoginpageO(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

//to initialise all page objects for given driver
public 	void Rahulshettyacademy_LoginpageObjects(WebDriver driver){
	//instead of this we can use classname.class
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username1, String password1) {
		//SendKeys_CustomMethod
		
	}
	

}
