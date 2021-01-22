package com.amazon.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.config.TestBase;
import com.amazon.function.HomePageFunctions;
import com.amazon.function.ProductFunctions;
import com.amazon.function.SearchResultsFunctions;
import com.amazon.or.SearchResultsPage;
import com.amazon.util.Xls_Reader;
import com.amazon.wdcomands.Actiondriver;

public class SearchProduct_AddtoCart extends TestBase{
	@Test
	public void testSearchProduct_AddtoCart() throws Exception {
		Actiondriver aDriver = new Actiondriver();
		Xls_Reader reader = new Xls_Reader("TestData/Data.xlsx");
		String searchTerm=reader.getCellData("Sheet1", "SearchTerm", 2);
		HomePageFunctions hpf = new HomePageFunctions();
		SearchResultsFunctions srf = new SearchResultsFunctions(); 
		ProductFunctions pf = new ProductFunctions();
		hpf.searchProduct(searchTerm);
		String actualsearchTerm=aDriver.getText(SearchResultsPage.searchTerm);
		Assert.assertEquals(actualsearchTerm, "\""+searchTerm+"\"");
		srf.applyFilter();
		srf.selectBook();
		pf.addToCart();
		pf.emptyCart();
		Thread.sleep(10000);



	}
}
