package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.LogoutSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogoutDefinitions {
	@Steps
	LogoutSteps logoutSteps;
		
		@When("^El usuario sale de la app$")
		public void elUsuarioSaleDeLaApp() {
		    // Write code here that turns the phrase above into concrete actions
			 logoutSteps.seleccionarSalir();
		}
		
		@Then("^verifica salida exitosa$")
		public void verificaSalidaExitosa() {
		 
		}
		



}
