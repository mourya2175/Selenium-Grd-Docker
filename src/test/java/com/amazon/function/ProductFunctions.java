package com.amazon.function;

import org.openqa.selenium.WebDriver;

import com.amazon.or.ProductDetailsPage;
import com.amazon.wdcomands.Actiondriver;

public class ProductFunctions {
	WebDriver driver;
	Actiondriver aDriver;
	public ProductFunctions() {
//		driver= WebDriverManager.getInstance().getDriver();
		aDriver= new Actiondriver();
	}
	

	public void addToCart() throws Exception
	{
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Add to Cart");
		aDriver.swittoChildWindow();
		aDriver.click(ProductDetailsPage.btnAddToCart, "Add to Cart button");
		aDriver.click(ProductDetailsPage.btnAddToCart1, "Cart button");
		//StartBrowser.childTest.pass("Product is added to cart : "+aDriver.getText(ProductDetailsPage.textTitle));
		
	}
	
	public void emptyCart() throws Exception
	{
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Empty Cart");
		aDriver.click(ProductDetailsPage.btnDelete, "Delete Button");
		//StartBrowser.childTest.pass("Product is deleted from cart");
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
