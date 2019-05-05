package com.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TecAdminSeleniumTest {

	 public static void main(String[] args) throws IOException, InterruptedException {
         System.setProperty("webdriver.chrome.driver", "/opt/workspace/workspace-selenium/selenium/drivers/chromedriver");
         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.setBinary("/usr/bin/google-chrome");
         
            chromeOptions.addArguments("--headless");
         chromeOptions.addArguments("--no-sandbox");
         chromeOptions.addArguments("window-size=800,600");
         //chromeOptions.addArguments("screenshot");
         
         
         WebDriver driver = new ChromeDriver(chromeOptions);

         driver.get("https://www.detik.com");
//         driver.manage().window().maximize();
         

         Thread.sleep(1000);

         if (driver.getPageSource().contains("I'm Feeling Lucky")) {
                 System.out.println("Pass");
         } else {
                 System.out.println("Fail"+driver.getPageSource());
         }


         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(scrFile, new File("failed-test1.png"));

         driver.quit();
 }
}
