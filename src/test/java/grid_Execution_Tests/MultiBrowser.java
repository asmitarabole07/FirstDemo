package grid_Execution_Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiBrowser {

	@Test(dataProvider = "getData")
	public void Login(String username,String password,String browser) throws MalformedURLException, InterruptedException {
		
		System.out.println(browser);
		
		DesiredCapabilities cap= new DesiredCapabilities();
		WebDriver driver=null;
		String hubURL="http://192.168.43.38:4444/wd/hub";
		
		if(browser.equals("firefox"))
		{
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WINDOWS);
			FirefoxOptions options=new FirefoxOptions();
			options.merge(cap);
			
			driver=new RemoteWebDriver(new URL(hubURL), options);
		}
		else if (browser.equals("chrome")) 
		{
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions options=new ChromeOptions();
			options.merge(cap);
			
			driver=new RemoteWebDriver(new URL(hubURL), options);
		}
		else if (browser.equals("iexplore")) 
		{
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WINDOWS);
			InternetExplorerOptions options=new InternetExplorerOptions();
			options.merge(cap);
			
			driver=new RemoteWebDriver(new URL(hubURL), options);
		}
		

		
		driver.get("https://www.prepbytes.com/login");
		driver.findElement(By.xpath("//input[@name='email_input']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password_input']")).sendKeys(password);
		Thread.sleep(5000);
		driver.close();
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData() {
		
		Object[][]data=new Object[3][3];
		
		data[0][0]="aaaaa";
		data[0][1]="aaaaa";
		data[0][2]="firefox";
		
		data[1][0]="bbbbb";
		data[1][1]="bbbbb";
		data[1][2]="chrome";
		
		data[2][0]="ccccc";
		data[2][1]="ccccc";
		data[2][2]="iexplore";
		
		
		
		return data;
		
	}
	
	
	
}
