package com.sophossolutions.coarchitech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReproductionScreen extends BasePage {

	private Boolean stopReproduction;

	private Integer timeSong;

	private By jumpAdvertisementType1 = By
			.xpath("//span[@class='ytp-ad-skip-button-container']/button/div[contains(text(),'Omitir anuncios')]");
	private By jumpAdvertisementType2 = By
			.xpath("//span[@class='ytp-ad-skip-button-container']/button/div[contains(text(),'Saltar anuncio')]");
	private By jumpAdvertisementType3 = By
			.xpath("//span[@class='ytp-ad-skip-button-container']/button/div[contains(text(),'Skip Ads')]");
	private By conditionsNoThanks = By.xpath("//yt-formatted-string[contains(text(),'No, gracias')]");

	public ReproductionScreen(WebDriver driver) {
		super(driver);
		stopReproduction = false;
		timeSong = 0;
	}

	public void removeAdvertisement(Integer timeSongL) {
		System.out.println("Time " + timeSongL);
		this.timeSong = timeSongL;
		new Thread() {
			WebElement element;
			
			@Override
			public void run() {
				while (timeSong > 0 && Boolean.FALSE.equals(stopReproduction)) {
					try {
						element = findElement(jumpAdvertisementType1);
						element.click();
					} catch (Exception e) {
					}
					try {
						element = findElement(jumpAdvertisementType2);
						element.click();
					} catch (Exception e) {
					}
					try {
						element = findElement(conditionsNoThanks);
						element.click();
					} catch (Exception e) {
					}
					try {
						element = findElement(jumpAdvertisementType3);
						element.click();
					} catch (Exception e) {
					}
					waitS(1);
					timeSong--;
				}
				System.out.println("Fin " + timeSong);
			}
		}.run();

	}

	public static void waitS(Integer time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopRemover() {
		stopReproduction = true;
	}

	public Boolean getStopReproduction() {
		return stopReproduction;
	}

	public Integer getTimeSong() {
		return timeSong;
	}

}
