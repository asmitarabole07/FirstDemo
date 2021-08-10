package sauceLabs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTest extends BaseTest {

//	public void doLogin() {
//		driver.get("https://www.saucedemo.com/");
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
//	}
	
	
	@Test(priority = 1)
	public void ImageTest() {
		//doLogin();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='inventory_item']")).size()==6);
		
		
	}
	
	@Test(priority = 2)
	public void buttonTest() {
		//doLogin();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Assert.assertTrue(driver.findElements(By.xpath("//button[text()='Add to cart']")).size()==6);
		
	}
}
