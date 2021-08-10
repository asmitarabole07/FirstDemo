package sauceLabs;

import java.lang.StackWalker.Option;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) throws MalformedURLException {
		
		System.out.println("Browser : "+browserName);
		
		MutableCapabilities sauceOpts=new MutableCapabilities();
		
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "oauth-asmitarabole07-3d408");
		sauceOpts.setCapability("accessKey", "436567ec-27eb-47c6-9911-d26dd1c1eec3");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", "windows 10");
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
			ChromeOptions options=new ChromeOptions();
			options.merge(cap);
			
			driver=new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
			
			FirefoxOptions options=new FirefoxOptions();
			options.merge(cap);
			
			
			driver=new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		//https://oauth-asmitarabole07-3d408:436567ec-27eb-47c6-9911-d26dd1c1eec3@ondemand.eu-central-1.saucelabs.com:443/wd/hub
		
//		driver=new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}

