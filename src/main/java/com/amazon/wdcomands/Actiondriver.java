package com.amazon.wdcomands;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.config.DriverFactory;
import com.amazon.config.ExtentFactory;
import com.amazon.util.ConfiguratorSupport;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Actiondriver {
	WebDriver driver;
	ConfiguratorSupport config = new ConfiguratorSupport("config.properties");
	public Actiondriver () {
		driver = DriverFactory.getInstance().getDriver();

	}
	/**
	 * This is used to navigate to application , url is reading from config.properties file
	 * @throws Exception
	 */
	public void navigatetoApplication() throws Exception {
		try {
			String url=config.getProperty("url");
			driver.get(url); 
			ExtentFactory.getInstance().getExtent().pass("Navigated to application successfully : "+url);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Navigate to application");
			throw e;
		}
	}

	/**
	 * Used to Perform click action on links, buttons, checkbox and radio buttons
	 * @param locator --Get it from OR
	 * @throws Exception 
	 */
	public void click(By element, String eleName) throws Exception
	{
		try {
			driver.findElement(element).click();
			ExtentFactory.getInstance().getExtent().pass("Performed click action successfully on :"+eleName);

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Perform click on :"+eleName ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			ExtentFactory.getInstance().getExtent().info(e);
			throw e;
		}

	}
	/**
	 * used to perform type action in textbox and Text area
	 * @param locator
	 * @param testData
	 * @throws Exception 
	 */
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			ExtentFactory.getInstance().getExtent().pass("Performed type in  :"+eleName + " with data :" +testData);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Perform type action in :"+eleName + "with data "+testData ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			ExtentFactory.getInstance().getExtent().info(e);
			throw e;
		}
	}
	/**
	 * 
	 * @param locator
	 * @return
	 */

	public String getText(By locator)
	{
		try {
			String x=driver.findElement(locator).getText();
			//ExtentFactory.getInstance().getExtent().pass("Text is   :"+x);
			return x;
		} catch (Exception e) {
			//ExtentFactory.getInstance().getExtent().fail("unable to return text");
			return null;
		}

	}
	/**
	 * Perform mouse hover on given element
	 * @param locator --- get it from Or
	 * @param eleName --for reporting
	 * @throws Exception 
	 */
	public void mouseHover(By locator, String eleName) throws Exception
	{
		try {
			Actions a = new Actions(driver);
			WebElement mo=driver.findElement(locator);
			a.moveToElement(mo).build().perform();
			ExtentFactory.getInstance().getExtent().pass("Performed mousehover on  :"+eleName );
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Performed mousehover on  :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			ExtentFactory.getInstance().getExtent().info(e);
			throw e;
		}
	}

	/**
	 * 
	 * @param locator
	 * @param expText
	 * @throws Exception
	 */
	public void verifyText(By locator, String expText) throws Exception
	{
		String actualText=getText(locator);
		if(actualText.equals(expText))
		{
			ExtentFactory.getInstance().getExtent().pass("Actual Text is equal to expected text");
		}
		else
		{
			ExtentFactory.getInstance().getExtent().fail("Actual Text : " +actualText +" is not equal to expected text :"+expText ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			throw new Exception();
		}
	}
	/**
	 * 
	 * @param locator
	 */
	public void waitForelementVisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * select By index
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void selectByIndex(By locator, int index) throws Exception
	{
		try {
			WebElement dd = driver.findElement(locator);
			Select s = new Select(dd);
			s.selectByIndex(index);
			ExtentFactory.getInstance().getExtent().pass("Selected " + index + " value from dropdown");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Select " + index + " value from dropdown",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			ExtentFactory.getInstance().getExtent().info(e);
			throw e;
		}
	}
	
	/**
	 * select By index
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void selectByVisibleText(By locator, String visibleText, String elementName) throws Exception
	{
		try {
			WebElement dd = driver.findElement(locator);
			Select s = new Select(dd);
			s.selectByVisibleText(visibleText);
			ExtentFactory.getInstance().getExtent().pass("Selected " + visibleText + " value from " +elementName);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().fail("Unable to Select " + visibleText + " value from dropdown",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			ExtentFactory.getInstance().getExtent().info(e);
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public String getParentwindow()
	{
		return driver.getWindowHandle();
	}
	/**
	 * 
	 * @param locator
	 * @param expText
	 */
	public void swittoChildWindow(By locator,String expText)
	{
		Set<String> windows=driver.getWindowHandles();
		try {
			for (String string : windows) {
				driver.switchTo().window(string);
				{
					if(getText(locator).equals(expText) )
					{
						System.out.println("I am in correct window");
						break;
					}
					else
					{
						System.out.println("I am in wrong window");
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * @param locator
	 * @param expText
	 */
	public void swittoChildWindow()
	{
		String pwin=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		try {
			for (String string : windows) {
				driver.switchTo().window(string);
				{
					if(!pwin.equals(driver.getWindowHandle()))
					{
						System.out.println("I am in correct window");
						break;
					}
					else
					{
						System.out.println("I am in wrong window");
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
/**
 * Perform mouse hover and click on submenu
 * @param menuLocator
 * @param subMenuLocator
 * @param menu
 * @param submenu
 * @throws Exception 
 */
public void mouseHoverAndClickSubMenu(By menuLocator, By subMenuLocator, String menu, String submenu) throws Exception
{
	try {
		 Actions act = new Actions(driver);
	     WebElement ele=driver.findElement(menuLocator);
	     act.moveToElement(ele).build().perform();
	     Thread.sleep(3000);
	     driver.findElement(subMenuLocator).click();
	     ExtentFactory.getInstance().getExtent().pass("Successfully mouse hover on Menu: " +menu +" and clicked on submenu :"+submenu);
	} catch (Exception e) {
		ExtentFactory.getInstance().getExtent().fail("Unable to mousehover  on Menu: " +menu +" and unable to click on submenu :"+submenu,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		ExtentFactory.getInstance().getExtent().info(e);
		throw e;

	}
}

/**
 * It will return true if the element is the present otherwise false
 * @param locator
 * @return
 * @throws IOException 
 */
public boolean isElePresent(By locator, String elementName) throws IOException
{
	try {
		
		driver.findElement(locator);
		 ExtentFactory.getInstance().getExtent().pass("Element : " +elementName +" is present");
		return true;
		
	} catch (Exception e) {
		System.out.println("Element is not present");
		ExtentFactory.getInstance().getExtent().info("Element : " +elementName +" is not present" + 
		MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		return false;
	}
}

}
