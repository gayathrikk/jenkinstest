package com.testing.dockertesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;


import java.net.MalformedURLException;
import java.net.URL;

public class dockertest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities dc= DesiredCapabilities.chrome();
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		driver.get("http://public.humanbrain.in");
		System.out.println("title"+driver.getTitle());
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
//		driver.findElement(By.xpath("//a[text()='New to Flipkart? Create an account']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("9941253687");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
		driver.quit();
		

	}

}
