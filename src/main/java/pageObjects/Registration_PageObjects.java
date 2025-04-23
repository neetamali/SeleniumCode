package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration_PageObjects {
	WebDriver driver = null;
@FindBy(xpath="//a[text() ='Register']") WebElement registrationLnk;
@FindBy(id="firstName") WebElement firstnamefld;
@FindBy(id="lastName") WebElement lastNamefld;
@FindBy(id="userEmail") WebElement usernamefld;
@FindBy(id="userMobile") WebElement mobilenumber;
@FindBy(xpath="//select[@class='custom-select ng-untouched ng-pristine ng-valid']") 
WebElement OccupationDroDown;
@FindBy(xpath = "//input[@value='Female']") WebElement femaleRadioBtn;
@FindBy(xpath = "//input[@value='Male']") WebElement maleRadioBtn;
@FindBy(id="userPassword") WebElement userpassword;
@FindBy(id="confirmPassword") WebElement confirmpassword;
@FindBy(xpath = "//input[@type='checkbox']") WebElement agecheckbox;
@FindBy(id="login") WebElement registerbut;

public Registration_PageObjects(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}
public void registration_form() {
	registrationLnk.click();
	
}
public void fill_registration_form(String firstname, String lastname, String email, String mobnum, String pass) {
	firstnamefld.sendKeys(firstname);
	lastNamefld.sendKeys(lastname);
	usernamefld.sendKeys(email);
	mobilenumber.sendKeys(mobnum);
	 Select sel = new Select(OccupationDroDown);
	 sel.selectByVisibleText("Doctor");
	 femaleRadioBtn.click();
	 userpassword.sendKeys(pass);
	 confirmpassword.sendKeys(pass);
	 agecheckbox.click();
	 registerbut.click();
}


}
