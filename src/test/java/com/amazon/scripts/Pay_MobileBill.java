package com.amazon.scripts;

import org.testng.annotations.Test;

import com.amazon.config.TestBase;
import com.amazon.function.AmazonPayFunctions;
import com.amazon.function.HomePageFunctions;
import com.amazon.util.Xls_Reader;

public class Pay_MobileBill extends TestBase{
	@Test
	public void testMobile_Postpaid() throws Exception {
		Xls_Reader reader = new Xls_Reader("TestData/Data.xlsx");
		String mobileNumber=reader.getCellData("Sheet2", "MobileNumber", 2);
		HomePageFunctions hpf = new HomePageFunctions();
		AmazonPayFunctions apf = new AmazonPayFunctions();
		hpf.navigateToAmazonPay();
		apf.mobilePostPaid(mobileNumber);
//		Thread.sleep(10000);



	}
}
