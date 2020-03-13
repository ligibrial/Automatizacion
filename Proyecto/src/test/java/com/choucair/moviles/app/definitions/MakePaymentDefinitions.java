package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.MakePaymentSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class MakePaymentDefinitions {
		
	    @Steps
		MakePaymentSteps makePaymentSteps;
		
		@When("^Realiza el pago$")
		public void realizaElPago() {
			makePaymentSteps.ingresoALaOpcionDePago();
		}
		
		@When("^Diligencia los datos de pago \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
		public void diligenciaLosDatosDePago(String ph, String nm, String amt) {
			makePaymentSteps.diligenciarElFormularioDePago(ph, nm, amt);
		}
		
		@When("^Selecciona la ubicación de envio  \"([^\"]*)\"$")
		public void seleccionaLaUbicaciónDeEnvio(String cty) throws InterruptedException {
			makePaymentSteps.seleccionarPais(cty);
		}
		
		@Then("^Realiza pago exitoso$")
		public void realizaPagoExitoso() {
         makePaymentSteps.realizarPagoExitoso();
	   
		}
	
}