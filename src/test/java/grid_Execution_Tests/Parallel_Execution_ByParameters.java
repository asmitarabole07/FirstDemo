package grid_Execution_Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel_Execution_ByParameters {

	@Parameters({"browser"})
	@Test
	public void GoogleLogin(String browser) throws MalformedURLException, InterruptedException {
		
		Date d=new Date();
		System.out.println(browser+"--"+d.toString());
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		WebDriver driver;
		String hubURL="http://192.168.43.38:4444/wd/hub";
		if (browser.equals("chrome"))
		{
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("chrome");
			
			ChromeOptions options=new ChromeOptions();
			options.merge(cap);
		}
		else if (browser.equals("firefox")) 
		{
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("firefox");
			
			FirefoxOptions options=new FirefoxOptions();
			options.merge(cap);
			
		}
		
		driver=new RemoteWebDriver(new URL(hubURL), cap);
		
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("Successssss");
		Thread.sleep(2000);
		driver.quit();
		
	}
}
