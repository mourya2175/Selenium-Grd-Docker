package com.amazon.config;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.util.ConfiguratorSupport;


public class TestBase  {
	BrowserFactory bFactory = new BrowserFactory();
	ConfiguratorSupport config= new ConfiguratorSupport("config.properties");
	@BeforeMethod
	public void LaunchApplication() throws Exception {
		DriverFactory.getInstance().setDriver(bFactory.createBrowserInstance());
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(config.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

}
