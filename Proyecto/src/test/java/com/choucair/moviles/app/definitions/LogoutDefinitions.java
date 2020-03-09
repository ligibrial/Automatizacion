package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.LogoutSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogoutDefinitions {
	@Steps
	LogoutSteps logoutSteps;
	@When("^Seleccionar Salir$")
	public void seleccionarSalir() {
    logoutSteps.seleccionarSalir();

	}

	@Then("^Salir exitosamente$")
	public void salirExitosamente() {
	  
	}


}
