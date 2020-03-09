package com.choucair.moviles.app.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static Properties properties;
	
	public PropertiesReader() {
		//Esto debería hacer algo
	}
	
	public static String getPropiedad(String prop){return getProperties().getProperty(prop);}
	
	private static Properties getProperties()
	{
		properties = new Properties();
		try {
			properties.load(new FileReader("serenity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
