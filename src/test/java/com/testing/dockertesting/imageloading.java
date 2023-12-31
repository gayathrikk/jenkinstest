package com.testing.dockertesting;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class imageloading {
	private WebDriver driver;
	
	@BeforeTest
	
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//a[@title='Viewer']")).click();
		 
		 String parentWindow = driver.getWindowHandle();
		 driver.findElement(By.xpath("//button[text()=' Log In ']")).click();
		 Thread.sleep(4000);
		 Set<String> allWindows = driver.getWindowHandles();
		 for (String window : allWindows) {
			    if (!window.equals(parentWindow)) {
			        driver.switchTo().window(window);
			        break;
			    }
			}
		 Thread.sleep(4000);	
		 Properties properties = new Properties();

	        try (FileInputStream fis = new FileInputStream("/home/nathan/Desktop/autamationTesting/jenkinstest/config.properties/imageloading")) {
	            properties.load(fis);

	            String email = properties.getProperty("email");
	            String password = properties.getProperty("password");

	            // Perform actions using the retrieved values
	            driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	            driver.findElement(By.xpath("//span[text()='Next']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys(password);
	            driver.findElement(By.xpath("//span[text()='Next']")).click();
	            Thread.sleep(5000);
	            driver.switchTo().window(parentWindow);
	            Thread.sleep(5000);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	@Test(priority=2)
	public void sectionselect() throws InterruptedException
	{
	     WebElement tableElement = driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[6]"));
	     tableElement.click();
	     Thread.sleep(3000);
	     WebElement tableElement1=driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[7]//td[2]"));
	     tableElement1.click();
	     Thread.sleep(3000);
	     ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 600);");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[19]//td[3]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//span[text()='1069'])[1]")).click();
	}
	@Test(priority=3,enabled=false)
	public void imagelaodingatlas() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='View High Resolution Image']")).click();
		Thread.sleep(4000);
		WebElement file=driver.findElement(By.xpath("(//div[@class='paragraph'])[4]"));
		String filenamehd=file.getText();
		System.out.println("filename HD-"+filenamehd);
		driver.findElement(By.xpath("//a[@title='back']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='NISSL']")).click();
		Thread.sleep(4000);
		WebElement section=driver.findElement(By.xpath("//input[@placeholder='Go To Section']"));
		section.sendKeys("1078");
		Thread.sleep(1000);
		 Actions actions = new Actions(driver);
	     actions.sendKeys(section, Keys.ENTER).perform();
		driver.findElement(By.xpath("//a[@title='Atlas Editor']")).click();
		Thread.sleep(5000);
		WebElement file2=driver.findElement(By.xpath("(//div[@class='paragraph'])[6] "));
		String filenameatlas=file2.getText();
		System.out.println("filename atlas-"+filenameatlas);
		Assert.assertNotEquals(filenamehd, filenameatlas);
		
		}
	@Test(priority=4)
	public void imagelaodingcell() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='View High Resolution Image']")).click();
		Thread.sleep(4000);
		WebElement file=driver.findElement(By.xpath("(//div[@class='paragraph'])[4]"));
		String filenamehd=file.getText();
		System.out.println("filename HD-"+filenamehd);
		driver.findElement(By.xpath("//a[@title='back']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='NISSL']")).click();
		Thread.sleep(4000);
		WebElement section=driver.findElement(By.xpath("//input[@placeholder='Go To Section']"));
		section.sendKeys("1078");
		Thread.sleep(1000);
		 Actions actions = new Actions(driver);
	     actions.sendKeys(section, Keys.ENTER).perform();
		driver.findElement(By.xpath("//a[@title='Cell Annotation']")).click();
		Thread.sleep(5000);
		WebElement file2=driver.findElement(By.xpath("(//div[@class='paragraph'])[4] "));
		String filenamecell=file2.getText();
		System.out.println("filename cellannotation-"+filenamecell);
		Assert.assertNotEquals(filenamehd, filenamecell);
		
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();

}
}