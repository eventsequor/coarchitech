package com.sophossolutions.coarchitech.actions;


import javax.swing.JOptionPane;

import com.sophossolutions.coarchitech.controller.SeleniumManager;
import com.sophossolutions.coarchitech.page.ReproductionScreen;

public class RemoveAdvertisement extends Action {

	public RemoveAdvertisement(SeleniumManager seleniumManager) {
		super(seleniumManager);
		seleniumManager.setBasePage(new ReproductionScreen(seleniumManager.getDriver()));
	}

	public void remove(Integer time) {
		seleniumManager.getPage(ReproductionScreen.class).removeAdvertisement(time);
//		JOptionPane.showMessageDialog(null,"De click en aceptar para finalizar el robot");
//		seleniumManager.getPage(ReproductionScreen.class).stopRemover();
	}

}
