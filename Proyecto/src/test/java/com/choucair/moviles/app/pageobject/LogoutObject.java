package com.choucair.moviles.app.pageobject;

import org.openqa.selenium.WebDriver;

import com.choucair.moviles.app.utils.AccionesObjetos;
import com.choucair.moviles.app.utils.MobilePageObject;
import static com.choucair.moviles.app.ui.LogoutUI.*;

public class LogoutObject extends MobilePageObject{
	public LogoutObject(WebDriver driver){super(driver);}
	
	AccionesObjetos accionesObjetoslogout;
	
	public void ingresarLogout() {
		
		accionesObjetoslogout.clickObjeto(btnlogout);
	}
	
	
	

}
