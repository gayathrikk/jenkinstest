package com.testing.dockertesting;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        scrollToBottom(driver);
        Thread.sleep(3000);
        scrollToTop(driver);
        Thread.sleep(2000);

        Homepage test = new Homepage();
        test.Homepagepeople();
        test.Homepageproject();
        test.Dataportal();
        test.Homenewsandevents();
        test.Homecareer();
        test.Homecontacts();
        driver.quit();
    }

  

    public void Homepagepeople() throws InterruptedException {

		  driver.findElement(By.xpath("(//a[text()='PEOPLE'])[1]")).click();
		  
		  driver.findElement(By.xpath("//button[text()='Chair Professors']")).click();
		  Homepage.scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Faculty']")).click();
		  Homepage.scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Collaborators']")).click();
		  Homepage.scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Researchers']")).click();
		  Homepage.scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Software Team']")).click();
		  Homepage.scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Analytics Team']")).click();
		  Homepage.scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Engineering Team']")).click();
		  Homepage.scroll();
	
		  driver.findElement(By.xpath("//button[text()='Optics and Imaging Team']")).click();
		  Homepage.scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Wet Lab Team']")).click();
		  Homepage.scroll();

    }

    public void Homepageproject() throws InterruptedException {
    	  driver.findElement(By.xpath("(//a[text()='PROJECT'])[1]")).click();
    	  driver.findElement(By.xpath("//a[@data-target='#HDviewer']")).click();
    	  Thread.sleep(9000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//a[@data-target='#atlascreator']")).click();
    	  Thread.sleep(7000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//a[@data-target='#cellannotation']")).click();
    	  Thread.sleep(9000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//a[@data-target='#visualizer']")).click();
    	  Thread.sleep(5000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    	  Thread.sleep(2000);
    	  Homepage.scroll();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[@data-target='#registration']")).click();
    	  Thread.sleep(7000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//a[@data-target='#seriesviewer']")).click();
    	  Thread.sleep(6000);
    	  driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    	  Thread.sleep(2000);
		  
		  	  
    }
    public void Dataportal() throws InterruptedException{
    
    driver.findElement(By.xpath("((//a[text()='NEWS & EVENTS'])//preceding::a[1])[1]")).click();
    Thread.sleep(2000);
    Homepage.windowhandle();
    }

    public void Homenewsandevents() throws InterruptedException {
    	  driver.findElement(By.xpath("(//a[text()='NEWS & EVENTS'])[1]")).click();
		  Homepage.scroll();
		  Thread.sleep(2000);
    }

    public void Homecareer()  throws InterruptedException {
    	 driver.findElement(By.xpath("(//a[text()='CAREER'])[1]")).click();
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[1]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[2]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[3]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[4]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[5]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
    	 driver.findElement(By.xpath("(//a[text()='Apply'])[6]")).click();
    	 Thread.sleep(3000);
    	 Homepage.windowhandle();
		  //Homepage.scroll();
		  Thread.sleep(2000);
		  
    }

    public void Homecontacts() throws InterruptedException  {

		 driver.findElement(By.xpath("(//a[text()='CONTACTS'])[1]")).click();
		 Homepage.scroll();
		 driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("software team");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwareteam@htic.iitm.ac.in");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123456789");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//textarea[@name='msg']")).sendKeys("Testing purpose" );
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 Thread.sleep(2000);
		  
		  
    }
    
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }
    public static void scroll() throws InterruptedException
    {
    	Thread.sleep(2000);
    	scrollToBottom(driver);
        Thread.sleep(2000);
        scrollToTop(driver);
        Thread.sleep(2000);
    }
    public static void windowhandle()  throws InterruptedException 
    {
    	String parentWindowHandle = driver.getWindowHandle();
   	    Set<String> windowHandles = driver.getWindowHandles();
           for (String windowHandle : windowHandles) {
   	    driver.switchTo().window(windowHandle);
   	    
   	    }
           Thread.sleep(2000);
           driver.close();
           Thread.sleep(2000);
           driver.switchTo().window(parentWindowHandle);
           driver.switchTo().frame(0);
    }
}