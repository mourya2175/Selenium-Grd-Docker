/**
 * Author: Prakash Narkhede
 * Blog: www.AutomationTalks.com
 * LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */
package com.amazon.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amazon.util.ConfiguratorSupport;

public class BrowserFactory {
	ConfiguratorSupport config= new ConfiguratorSupport("config.properties");

	//create webdriver object for given browser
	public WebDriver createBrowserInstance() throws MalformedURLException {

		RemoteWebDriver driver = null;
		if(config.getProperty("browser").equals("chrome")) {
			DesiredCapabilities capability= new DesiredCapabilities();
	        capability.setBrowserName(config.getProperty("browser"));
	        System.out.println(config.getProperty("browser"));
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
	}
		return driver;

	}
}
