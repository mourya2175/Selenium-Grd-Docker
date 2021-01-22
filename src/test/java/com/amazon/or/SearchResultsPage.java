package com.amazon.or;

import org.openqa.selenium.By;

public class SearchResultsPage {
	
	public static By lnkbreadcrumb = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/a[last()]");
	
	//public static By lnkSoftwareTesting = By.xpath("//span[text()='Software Testing']");
	public static By lnkBook=By.xpath("((//div[@class='a-section a-spacing-medium'])[2]//div[@class='a-section a-spacing-none'])[2]/h2/a");
	
	public static By searchTerm = By.xpath("//span[@class='a-color-state a-text-bold']");
	
	public static By booksFilter(String filter)
	{
		return By.xpath("//span[text()='"+filter+"']");
	}
	
	public static By chckPaperback = By.xpath("//span[text()='Paperback']/preceding-sibling::div/label/i");
	
	
}
