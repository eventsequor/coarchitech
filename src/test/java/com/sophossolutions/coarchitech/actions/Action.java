package com.sophossolutions.coarchitech.actions;

import com.sophossolutions.coarchitech.controller.SeleniumManager;

public abstract class Action {

	protected SeleniumManager seleniumManager;

	public Action(SeleniumManager seleniumManager) {
		this.seleniumManager = seleniumManager;
	}

}
