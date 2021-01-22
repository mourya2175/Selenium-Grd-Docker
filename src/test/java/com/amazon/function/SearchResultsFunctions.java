package com.amazon.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.amazon.or.SearchResultsPage;
import com.amazon.wdcomands.Actiondriver;

public class SearchResultsFunctions {
	WebDriver driver;
	Actiondriver aDriver;
	public SearchResultsFunctions() {
		//driver= WebDriverManager.getInstance().getDriver();
		aDriver= new Actiondriver();
	}


	public void applyFilter() throws Exception
	{
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Apply filters to select book SW testing, paperback" );
		aDriver.click(SearchResultsPage.booksFilter("Software Testing"), "Software Testing link");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(SearchResultsPage.chckPaperback));
		//StartBrowser.childTest.pass("Applied Filter Paperback");
		
		/*//click sw testing
		aDriver.click(SearchResultsPage.booksFilter("Software Testing"), "Software Testing link");
		String booksFilter=aDriver.getText(SearchResultsPage.lnkbreadcrumb);
		Assert.assertEquals(booksFilter, "Software Testing");
		//click paperback
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(SearchResultsPage.chckPaperback));
		String formatFilter=aDriver.getText(SearchResultsPage.lnkbreadcrumb);
		Assert.assertEquals(formatFilter, "Paperback");
*/
	}
	public void selectBook() throws Exception
	{
		//StartBrowser.childTest = StartBrowser.parentTest.createNode("Select book after filtering" );
		aDriver.click(SearchResultsPage.lnkBook, "Select Book");
	}















}
