package com.choucair.moviles.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComandosADB {
	
	private final Logger logger = Logger.getLogger(ComandosADB.class.getName());
	private String device = "";
	
	public ComandosADB(String device)
	{
		this.device = device;
	}
	
	private List<String> ejecutarComandoADB(String[] comando) {
		BufferedReader br = null;
		List<String> resultados = new ArrayList<>();
		try {
			Process cmd = Runtime.getRuntime().exec(comando);
			br = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null)
			{
				resultados.add(line);
			}
		}catch(IOException e){logger.log(Level.SEVERE,e.getMessage());}
		return resultados;
	}

	public void obtenerLogBatteryHistory()
	{
		List<String> resultados = ejecutarComandoADB(new String[] {"adb","-s",device,"shell","dumpsys","batterystats","--history"});
		for(String resultado : resultados)
		{
			if(resultado.contains("volt") || resultado.contains("charge") || resultado.contains("temp") || resultado.contains("top"))
				logger.info(resultado);
		}
	}
	
	public void resetLogBattery()
	{
		logger.info("Reset Battery Log");
		mostrarResultado(ejecutarComandoADB(new String[] {"adb","-s",device,"shell","dumpsys","batterystats","--reset"}));
	}
	
	private void mostrarResultado(List<String> resultados)
	{
		for(String resultado : resultados)
			logger.info(resultado);
	}
}
	