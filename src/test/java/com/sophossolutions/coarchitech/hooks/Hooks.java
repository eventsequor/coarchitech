package com.sophossolutions.coarchitech.hooks;

import com.sophossolutions.coarchitech.controller.SeleniumManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	SeleniumManager seleniumManager;

	
	public Hooks(SeleniumManager seleniumManager) {
		this.seleniumManager = seleniumManager;
	}

	@Before
	public void precondiciones() {
		seleniumManager.launchBrowser();
	}

	@After
	public void postconditions() {
		seleniumManager.closeBrowser();
	}

}
