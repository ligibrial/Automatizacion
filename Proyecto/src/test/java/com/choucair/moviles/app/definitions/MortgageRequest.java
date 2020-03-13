package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.MortgageRequestSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MortgageRequest {
	
		@Steps
		 MortgageRequestSteps mortgageSteps;
     
		@When("^El usuario hace la solicitud de hipoteca$")
		public void elUsuarioHaceLaSolicitudDeHipoteca() {
			 mortgageSteps.ingresoALaOpcionMortgageRequest();
		}
		
		@When("^Diligencia los datos de la solicitud hipoteca \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
		public void diligenciaLosDatosDeLaSolicitudHipoteca(String nombre, String apellido, String edad, String direccion1, String direccion2) {
			 mortgageSteps.diligencioFormularioMort(nombre, apellido, edad, direccion1, direccion2);
				
		}
		
		@When("^Selecciona ubicacion para realizar solicitud \"([^\"]*)\"$")
		public void seleccionaUbicacionParaRealizarSolicitud(String country) {
			 mortgageSteps.seleccionarCountry(country);
		}
		
		@When("^Selecciona los datos de la solicitud hipoteca \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
		public void seleccionaLosDatosDeLaSolicitudHipoteca(String Loan, String Years, String Occupation, String Income) {
			mortgageSteps.diligenciarElFormularioNext(Loan, Years, Occupation, Income);
			
		}
		
		@Then("^Verifica la solicitud exitosa$")
		public void verificaLaSolicitudExitosa() {
			mortgageSteps.realizarHipotecaExitoso();
			
		}
	
	
}
