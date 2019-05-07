package com.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TecAdminSeleniumTest {

	 public static void main(String[] args) throws IOException, InterruptedException {
         System.setProperty("webdriver.chrome.driver", "/opt/workspace/workspace-selenium/selenium/drivers/chromedriver");
         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.setBinary("/usr/bin/google-chrome");
         
         //   chromeOptions.addArguments("--headless");
         chromeOptions.addArguments("--no-sandbox");
         chromeOptions.addArguments("window-size=800,600");
         //chromeOptions.addArguments("screenshot");
         
         
         WebDriver driver = new ChromeDriver(chromeOptions);
         send(driver, "087886246004", "hello world");
	 }

	 public static void elionsLogin(WebDriver driver) throws IOException {

         driver.get("https://elions.sinarmasmsiglife.co.id");
//         driver.manage().window().maximize();
         

         WebElement user = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='name']")));
         WebElement pass = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pass']")));
         WebElement button = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));
         
         
         
		/*
		 * WebElement user = driver.findElement(By.xpath("//*[@id='name']")); WebElement
		 * pass = driver.findElement(By.xpath("//*[@id='pass']")); WebElement button =
		 * driver.findElement(By.name("btnLogin"));
		 */ 
         user.sendKeys("TITIS");
         pass.sendKeys("Titis101185");
         button.click();
		/*
		 * Thread.sleep(1000);
		 * 
		 * 
		 * if (driver.getPageSource().contains("I'm Feeling Lucky")) {
		 * System.out.println("Pass"); } else {
		 * System.out.println("Fail"+driver.getPageSource()); }
		 * 
		 */
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(scrFile, new File("elions.png"));

         driver.quit();
 
		 
	 }
	 
	 public static boolean send(WebDriver driver,String phoneNb, String message) {
	        
	        try {
	            driver.get("https://api.whatsapp.com/send?phone="+phoneNb+"&text="+message);

	            WebElement mySendButton = (new WebDriverWait(driver, 10))
	                    .until(ExpectedConditions.presenceOfElementLocated(By.id("action-button")));      
	            // Click Send button in API page and wait for main Whatsapp Interface page with new Send button
	            mySendButton.click();      
	            WebElement myDynamicElement = (new WebDriverWait(driver, 100))
	                    .until(ExpectedConditions.presenceOfElementLocated(By.className("compose-btn-send")));        
	            myDynamicElement.click();
	            return true;
	        }
	        catch (TimeoutException ex) {
	           System.out.println("Timeout Sending message");
	           return false;
	        }
	        
	}
}
