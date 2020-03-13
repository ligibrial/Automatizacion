package com.choucair.moviles.app.steps;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;
import com.choucair.moviles.app.pageobject.LoginPageObject;

public class LoginSteps {

	LoginPageObject loginPageObject;
	
	@Step("Inicar la app Eribank")
	public void iniciarAppEribank()
	{
		loginPageObject.iniciarAppEribank();
	}
	@Step
	public void iniciarSesionExitosa(String usu,String pass)
	{
		loginPageObject.ingresarUsuario(usu);
		loginPageObject.ingresarContrasena(pass);
		loginPageObject.hacerClickBotonIngresar();
	}
	
	@Step("verificar el inicio correcto se sesión")
	public void verificaElAccesoApp(String mensaje) 
	{
		System.out.println("el mensaje es "+mensaje);
		System.out.println("el otro mensaje es "+loginPageObject.obtenerMensajeLabel());
	
		//assertTrue(mensaje, mensaje.contains(loginPageObject.obtenerMensajeLabel()));
		assertTrue(mensaje, mensaje.equals(loginPageObject.obtenerMensajeLabel().substring(0, 17)));

	
		
	
	}
}
