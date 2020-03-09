package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginDefinitions{
	
	@Steps
	LoginSteps loginSteps;
	
	@Given("^Iniciar App Eribank$")
	public void iniciarAppEribank()
	{
		loginSteps.iniciarAppEribank();
	}
	
	@When("^Iniciar Sesion Exitosa \"([^\"]*)\" \"([^\"]*)\"$")
	public void iniciarSesionExitosa(String usu,String pass)
	{
		loginSteps.iniciarSesionExitosa(usu, pass);
	}
	
	@Then("^Verificar Acceso App \"([^\"]*)\"$")
	public void verificarAccesoApp(String mensaje)
	{
		loginSteps.verificarAccesoApp(mensaje);
	}
}