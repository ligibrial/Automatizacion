package com.choucair.moviles.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class KobitonUtils {
	
	static String username = "movileschoucair";
    static String apiKey = "8edd6ac4-679b-4445-8ad1-49f780d262fa";
	
	public static void main(String[] args) throws IOException{
		getDevicesInfo();
	}
	
	public static void getDevicesInfo() throws IOException{
		System.out.println(genericPetition("https://api.kobiton.com/v1/devices"));
		JsonObject array;
		array = new JsonParser().parse(
				genericPetition("https://api.kobiton.com/v1/devices")).getAsJsonObject();
		mostrarJson(array.getAsJsonArray("favoriteDevices"));
		System.out.println();
	}
	
	public static void getSession() throws IOException
	{
		System.out.println(genericPetition("https://api.kobiton.com/v1/sessions/1265188"));
	}
	
	public static void getSessions() throws IOException
	{
		System.out.println(genericPetition("https://api.kobiton.com/v1/sessions"));
		JsonObject array;
		array = new JsonParser().parse(
				genericPetition("https://api.kobiton.com/v1/sessions")).getAsJsonObject();
		mostrarJson(array.getAsJsonArray("data"));
	}
	
	private static String genericPetition(String url) throws JsonSyntaxException, IOException
	{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in;
		String inputLine = "";
		//int responseCode;
		con.setRequestMethod("GET");
		con.setRequestProperty ("Authorization", generateBasicAuth());
		//responseCode = con.getResponseCode();
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		inputLine = in.readLine();
		in.close();
		return inputLine;
	}
	
	private static void mostrarJson(JsonArray json){
		for(int i = 0 ; i < json.size() ; i++){
	        System.out.println(json.get(i));
	    }
	}
	
	private static String generateBasicAuth() {
        String authString = username + ":" + apiKey;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        return "Basic " + authStringEnc;
    }
}
