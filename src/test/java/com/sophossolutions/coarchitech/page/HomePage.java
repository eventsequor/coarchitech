package com.sophossolutions.coarchitech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(id = "search")
	WebElement textBoxSearch;
	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void lookForSong(String nameOF_TheSong) {
		clickSendKeysAndEnter(textBoxSearch, nameOF_TheSong);
	}

}
