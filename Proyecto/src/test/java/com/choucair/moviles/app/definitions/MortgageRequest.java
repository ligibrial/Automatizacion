package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.MortgageRequestSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MortgageRequest {
	@Steps
	 MortgageRequestSteps mortgageSteps;


	@When("^Ingreso a la opcion Mortgage Request$")
	public void ingresoALaOpcionMortgageRequest() {
	 mortgageSteps.ingresoALaOpcionMortgageRequest();
		
	}

	@When("^diligencio formulario Mort \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void diligencioFormularioMort(String nombre, String apellido , String edad, String direccion1, String direccion2) {
   mortgageSteps.diligencioFormularioMort(nombre, apellido, edad, direccion1, direccion2);
	}

	@When("^Seleccionar country \"([^\"]*)\"$")
	public void seleccionarCountry(String country) {
		
      mortgageSteps.seleccionarCountry(country);
  
	}
	@When("^diligenciar el formulario next \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void diligenciarElFormularioNext(String Loan, String Years, String Occupation, String Income) {
		mortgageSteps.diligenciarElFormularioNext(Loan, Years, Occupation, Income);
	
	
	}

	@Then("^Realizar hipoteca exitoso$")
	public void realizarHipotecaExitoso() {
		mortgageSteps.realizarHipotecaExitoso();
	
	}

}
