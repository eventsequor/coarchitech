package com.sophossolutions.coarchitech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sophossolutions.coarchitech.utils.Utils;

public class ResultsPage extends BasePage {

	@FindBy(xpath = "//ytd-video-renderer/div/ytd-thumbnail")
	WebElement firstSong;

	By locatorTimeSong = By.xpath("(//ytd-video-renderer/div/ytd-thumbnail//span[@id='text'])[position()=1]");

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseFirstSong() {
		clickOver(firstSong);
	}

	public Integer getTimeSong() {
		explicityWaitElementToBeClickable(firstSong);
		Utils.explicityWait(1);
		String time = findElement(locatorTimeSong).getText().trim();
		return (Integer.parseInt((time.split(":")[0])) * 60) + Integer.parseInt(time.split(":")[1]);
	}

}
