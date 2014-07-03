package com.intellisqa.app;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
public class AppTest {  	    	   
	         WebDriver driver;  
	         @BeforeTest  
	         public void setUpDriver() {  
	        	 driver = new FirefoxDriver();
	        	 //DesiredCapabilities caps = new DesiredCapabilities();
	        	 //caps.setJavascriptEnabled(true);
	        	 //caps.setCapability("takesScreenshot", true);
	        	 //caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"selenium_standalone_binaries\\windows\\phantomjs\\64bit\\1.9.7\\phantomjs.exe");
	        	 //this.driver = new PhantomJSDriver(caps);  
	        	 driver.manage().window().maximize();
	        	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        	 //Open the URL
	        	 driver.get("http://webapp.idikudi.com/");
	         } 
	         // quit from WebDriver
	         @AfterClass
	         	public void tearDown(){
	        	 driver.quit();
	         }	
	         @Test  
	         public  void testSignup() throws InterruptedException, IOException{  
	   
	        	 int  time, day;
	        	 GregorianCalendar date = new GregorianCalendar(); 
	        	 day = date.get(Calendar.DAY_OF_MONTH);
	        	 time = date.get(Calendar.MILLISECOND);
	        	 String emailAdd = "testqa"+day+time+"@gmail.com";
	        	 System.out.println("${emailAdd}");
	        	 driver.findElement(By.linkText("Sign Up")).click();
	        	 driver.findElement(By.id("email")).clear();
			   
	        	 driver.findElement(By.id("email")).sendKeys(emailAdd);
	        	 driver.findElement(By.id("password")).clear();
	        	 driver.findElement(By.id("password")).sendKeys("123456");
	        	 driver.findElement(By.id("name")).clear();
	        	 driver.findElement(By.id("name")).sendKeys("intellisqa");
	        	 driver.findElement(By.id("gender-0")).click();
	        	 driver.findElement(By.id("submit")).click();
	        	 Thread.sleep(2000);
	        	 driver.findElement(By.linkText("Logout")).click();
	    	  }
			}
			                             