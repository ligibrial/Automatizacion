package com.choucair.moviles.app.pageobject;

import static com.choucair.moviles.app.ui.LoginUI.btnIngresar;
import static com.choucair.moviles.app.ui.LoginUI.lblMensaje;
import static com.choucair.moviles.app.ui.LoginUI.txtContrasena;
import static com.choucair.moviles.app.ui.LoginUI.txtUserName;

import org.openqa.selenium.WebDriver;

import com.choucair.moviles.app.utils.AccionesObjetos;
import com.choucair.moviles.app.utils.MobilePageObject;

public class LoginPageObject extends MobilePageObject{
	public LoginPageObject(WebDriver driver){super(driver);}
	
	AccionesObjetos accionesObjetos;
	
	public void iniciarAppEribank(){
		//Inicia la app
	}
	
	public void ingresarUsuario(String usu)
	{	
		
		accionesObjetos.setInputText(txtUserName, usu);
	}
	
	public void ingresarContrasena(String con)
	{
		accionesObjetos.setInputText(txtContrasena, con);
	}
	
	public void hacerClickBotonIngresar()
	{
		accionesObjetos.clickObjeto(btnIngresar);
	}
	
	public String obtenerMensajeLabel()
	{
	
		if(accionesObjetos.isIOS()) {
		return accionesObjetos.esperarObtenerObjetos(lblMensaje).getAttribute("name");
		}else {
		return accionesObjetos.esperarObtenerObjetos(lblMensaje).getText();
		}
	}
}
