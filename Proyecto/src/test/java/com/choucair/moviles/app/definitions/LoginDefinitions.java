package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginDefinitions{
	
	
	@Steps
	LoginSteps loginSteps;
	
	@Given("^Usuario ingresa a la app Eribank$")
	public void iniciarAppEribank() {
		loginSteps.iniciarAppEribank();
	}
	
	@When("^Inicia Sesion Exitosa \"([^\"]*)\" \"([^\"]*)\"$")
	public void iniciaSesionExitosa(String usu, String pass) {
		loginSteps.iniciarSesionExitosa(usu, pass);
	}
	
	@Then("^Verifica el Acceso App \"([^\"]*)\"$")
	public void verificaElAccesoApp(String mensaje) {
		loginSteps.verificaElAccesoApp(mensaje);
	}


}