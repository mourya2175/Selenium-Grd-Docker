package com.amazon.function;

import org.openqa.selenium.WebDriver;

import com.amazon.or.AmazonPayPage;
import com.amazon.wdcomands.Actiondriver;

public class AmazonPayFunctions {
	WebDriver driver;
	Actiondriver aDriver;
	public AmazonPayFunctions() {
//		driver= WebDriverManager.getInstance().getDriver();
		aDriver= new Actiondriver();
	}
	

	
	
	public void mobilePostPaid(String mobileNumber) throws Exception
	{
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Mobile postpaid");
		aDriver.click(AmazonPayPage.textMobilePostpaid, "Mobile Postpaid link");
		aDriver.type(AmazonPayPage.txtMobileNumber, mobileNumber, "Mobile number text box");
		aDriver.click(AmazonPayPage.btnFetchBill, "Fetch bill button");
		Thread.sleep(5000);
		aDriver.getText(AmazonPayPage.textMessage);
		//StartBrowser.childTest.pass("Mobile postpaid message :"+aDriver.getText(AmazonPayPage.textMessage));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(HomePage.txtSearchBox));*/
	/*JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='rugs'", driver.findElement(HomePage.txtSearchBox));*/
	/*aDriver.click(HomePage.btnSearch, "Search Button");
	js.executeScript("arguments[0].click();", driver.findElement(HomePage.btnSearch));*/
	/*Actions a =new Actions(driver);
	//a.moveToElement(driver.findElement(HomePage.btnSearch)).click().build().perform();
	a.click(driver.findElement(HomePage.txtSearchBox)).perform();
	a.sendKeys(driver.findElement(HomePage.btnSearch), Keys.ENTER).build().perform();*/
	/*aDriver.click(HomePage.txtSearchBox, "search box");
	aDriver.type(HomePage.txtSearchBox, searchTerm, "search box");*/
	//aDriver.click(HomePage.btnSearch, "Search Button");
	/* a.sendKeys(Keys.PAGE_DOWN).perform();
	a.moveToElement(driver.findElement(By.xpath("//img[@class='product-card__image']"))).perform();
	driver.findElement(By.xpath("//button[@class='product-card__action-button product-card__action-button--trigger']")).click();*/
	
}
