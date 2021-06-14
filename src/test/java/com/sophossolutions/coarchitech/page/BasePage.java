package com.sophossolutions.coarchitech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sophossolutions.coarchitech.utils.Constants;

public abstract class BasePage {

	protected WebDriver driver;
	protected WebDriverWait explicityWait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.TIME_AJAX_IN_SECONDS), this);
		explicityWait = new WebDriverWait(driver, Constants.EXPLICITY_WAIT);
	}

	public WebDriverWait getExplicityWait() {
		return explicityWait;
	}

	public void setExplicityWait(WebDriverWait explicityWait) {
		this.explicityWait = explicityWait;
	}

	public WebElement explicityWaitElementToBeClickable(WebElement element) {
		explicityWait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	

	public void clickSendKeysAndEnter(WebElement element, String text) {
		element = explicityWaitElementToBeClickable(element);
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
	}

	public void clickOver(WebElement element) {
		element = explicityWaitElementToBeClickable(element);
		element.click();
	}
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	

}
