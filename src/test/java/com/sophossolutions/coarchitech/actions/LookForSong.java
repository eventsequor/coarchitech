package com.sophossolutions.coarchitech.actions;

import com.sophossolutions.coarchitech.controller.SeleniumManager;
import com.sophossolutions.coarchitech.page.HomePage;
import com.sophossolutions.coarchitech.page.ResultsPage;

public class LookForSong extends Action {

	HomePage home;
	ResultsPage resultsPage;

	public LookForSong(SeleniumManager seleniumManager) {
		super(seleniumManager);
		home = new HomePage(seleniumManager.getDriver());
		seleniumManager.setBasePage(home);
	}

	public void searchSongGetTimeSong(String nameSong) {
		seleniumManager.getPage(HomePage.class).lookForSong(nameSong);
		setPageResultsPage();
		Integer timeSongInSeconds = seleniumManager.getPage(ResultsPage.class).getTimeSong();
		System.out.println("Tiempo canción " + timeSongInSeconds);
		seleniumManager.addDataOptions("time song", timeSongInSeconds);
		seleniumManager.getPage(ResultsPage.class).chooseFirstSong();
	}

	private void setPageResultsPage() {
		resultsPage = new ResultsPage(seleniumManager.getDriver());
		seleniumManager.setBasePage(resultsPage);
	}

}
