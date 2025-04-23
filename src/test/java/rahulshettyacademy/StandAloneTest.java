package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	//implicitly wait at global level
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client");
	driver.findElement(By.id("userEmail")).sendKeys("neetamali@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
	driver.findElement(By.id("login")).click();
	List<WebElement> prodlist = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
	for(WebElement ele : prodlist) {
		System.out.println(prodlist);
		
	}
	driver.close();
	
}
}
