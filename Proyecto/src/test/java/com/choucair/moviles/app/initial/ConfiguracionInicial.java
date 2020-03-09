package com.choucair.moviles.app.initial;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.choucair.moviles.app.utils.ComandosADB;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ConfiguracionInicial {
	
	ComandosADB cadb = new ComandosADB(System.getProperty("appium.udid"));
	@Before
	public void configuracion() throws InvalidFormatException, IOException
	{
		//Configuración de la granja chocuair
	}
	
	@After
	public void finalizar()
	{
		//Cerrar conexión
	}
}
