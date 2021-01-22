package com.amazon.or;

import org.openqa.selenium.By;

public class ProductDetailsPage {
	
	public static By btnAddToCart= By.id("add-to-cart-button");
	public static By txtAddToCart= By.id("submit.add-to-cart-announce");
	
	public static By textProductTitle= By.id("productTitle");
	public static By btnAddToCart1 = By.id("hlb-view-cart-announce");
	public static By btnDelete = By.xpath("//input[@value='Delete']");
	public static By textEmpty = By.className("sc-empty-cart-header");
	public static By textTitle = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");
	
	
}
