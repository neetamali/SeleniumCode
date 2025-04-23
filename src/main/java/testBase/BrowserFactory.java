package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//always start session in private mode
public class BrowserFactory {
	//this method will create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) {

		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chrmopt = new ChromeOptions();
			chrmopt.addArguments("--incognito");
			driver = new ChromeDriver(chrmopt);
		
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions intopt = new InternetExplorerOptions();
			intopt.addCommandSwitches("--private");
			driver = new InternetExplorerDriver(intopt);
		
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fofopt = new FirefoxOptions();
			fofopt.addArguments("--private");
			driver = new FirefoxDriver(fofopt);
		}

		return driver;
	}


}
