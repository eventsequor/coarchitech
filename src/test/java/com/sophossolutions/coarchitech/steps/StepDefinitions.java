package com.sophossolutions.coarchitech.steps;

import com.sophossolutions.coarchitech.actions.LookForSong;
import com.sophossolutions.coarchitech.actions.RemoveAdvertisement;
import com.sophossolutions.coarchitech.controller.SeleniumManager;
import com.sophossolutions.coarchitech.hooks.Steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;

public class StepDefinitions extends Steps {

	public StepDefinitions(SeleniumManager seleniumManager) {
		super(seleniumManager);
	}

	@Dado("el nombre de la canción {string}")
	public void el_nombre_de_la_canción(String nameSong) {
		seleniumManager.addDataOptions("name song", nameSong);
		System.out.println("Paso dado");
	}

	@Cuando("el sistema hace la busqueda de la canción en youtube")
	public void el_sistema_hace_la_busqueda_de_la_canción_en_youtube() {
		new LookForSong(seleniumManager)
				.searchSongGetTimeSong((String) seleniumManager.getValueDataOptions("name song"));
		System.out.println("Paso cuando");
	}

	@Y("si tiene anuncios publicitarios quitar les")
	public void si_tiene_anuncios_publicitarios_quitar_les() {
		System.out.println("Paso cuando");
		Integer timeSong = Integer.parseInt(String.valueOf(seleniumManager.getValueDataOptions("time song")));
		new RemoveAdvertisement(seleniumManager).remove(timeSong);
	}

}
