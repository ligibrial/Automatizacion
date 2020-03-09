package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.MakePaymentSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class MakePaymentDefinitions {
@Steps
MakePaymentSteps makePaymentSteps;

@When("^Ingreso a la opcion de pago$")
public void ingresoALaOpcionDePago() {
	makePaymentSteps.ingresoALaOpcionDePago();
}

@When("^Diligenciar el formulario de pago \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
public void diligenciarElFormularioDePago(String ph, String nm, String amt) {
	makePaymentSteps.diligenciarElFormularioDePago(ph, nm, amt);
}

@When("^Seleccionar Pais \"([^\"]*)\"$")
public void seleccionarPais(String cty) throws InterruptedException  {
   

	makePaymentSteps.seleccionarPais(cty);
}

@Then("^Realizar pago exitoso$")
public void realizarPagoExitoso() {
  
}

	
}