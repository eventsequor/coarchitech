package com.sophossolutions.coarchitech.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sophossolutions.coarchitech.page.BasePage;
import com.sophossolutions.coarchitech.utils.Constants;
import com.sophossolutions.coarchitech.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumManager {

	private WebDriver driver;

	private Integer timeVideo;
	private BasePage basePage;
	private Map<String, Object> dataOptions;

	public void launchBrowser() {
		switch (Constants.BROWSER.toLowerCase()) {
		case "google":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
//			options.addArguments("--no-sandbox");
//            options.addArguments("--headless");
//            options.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(options);
			break;
		default:
			throw new RuntimeException("No has been implemented the automation for the browser " + Constants.BROWSER);
		}
		driver.get(Constants.URL_PAGE);
		driver.manage().timeouts().pageLoadTimeout(Constants.TIME_PAGE_LOAD, TimeUnit.SECONDS);
		dataOptions = new HashMap<String, Object>();
		Utils.explicityWait(8);
	}

	public void closeBrowser() {
		Utils.explicityWait(5);
		if (driver != null) {
			driver.quit();
		}
	}

	public void closeCurrentlyBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	public void addDataOptions(String name, Object objectToSave) {
		dataOptions.put(name.toLowerCase(), objectToSave);
	}

	public Object getValueDataOptions(String name) {
		return dataOptions.get(name.toLowerCase());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Integer getTimeVideo() {
		return timeVideo;
	}

	public void setTimeVideo(Integer timeVideo) {
		this.timeVideo = timeVideo;
	}

	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}

	public <T extends BasePage> T getPage(Class<T> basePageStep) {
		return basePageStep.cast(basePage);
	}

}
