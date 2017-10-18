/**
 * 
 */
package gaurav.devops.selenium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;

/**
 * @author SNEHASISH_SHITH
 *
 */
@SuppressWarnings("deprecation")
public class WebAppSeleniumTest {

    @Test
    public void verifyTest() throws InterruptedException, MalformedURLException {
    	
		DesiredCapabilities capability = DesiredCapabilities.chrome();
    	capability.setBrowserName("chrome");
    	capability.setPlatform(Platform.LINUX);
    	WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capability);
		driver.get("http://192.168.99.100:8085/CounterWebApp/");
    	WebElement body = driver.findElement(By.tagName("h1"));
    	String header = body.getText();
    	if(!header.startsWith("Gaurav"))
    	{
    		System.out.println("Test Case Failed !!!!");
    		System.out.println("Header text is "+ header);
    		Assert.assertTrue(false);
    	}
    	else
    	{
    		System.out.println("Test Case Passed ........");
    		System.out.println("Header text is "+ header);
    		Assert.assertTrue(true);
    	}
    	
    	Thread.sleep(20);
          driver.quit();
    	
    }
    
    @Test
    public void firefoxTest() throws MalformedURLException
    {
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setBrowserName("firefox");
    	capability.setPlatform(Platform.LINUX);
    	WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capability);
    	driver.get("http://192.168.99.100:8085/CounterWebApp/");
    	WebElement body = driver.findElement(By.tagName("h1"));
    	String header = body.getText();
    	if(!header.startsWith("Gaurav"))
    	{
    		System.out.println("Firefox Test Case Failed !!!!");
    		System.out.println("Header text is "+ header);
    		Assert.assertTrue(false);
    	}
    	else
    	{
    		System.out.println("Firefox Test Case Passed ........");
    		System.out.println("Header text is "+ header);
    		Assert.assertTrue(true);
    	}
    }

}
