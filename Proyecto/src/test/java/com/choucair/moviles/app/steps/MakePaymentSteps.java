package com.choucair.moviles.app.steps;

import com.choucair.moviles.app.pageobject.MakePaymentObject;

import net.thucydides.core.annotations.Step;

public class MakePaymentSteps {


	MakePaymentObject makePaymentObjet;
	@Step
	public void ingresoALaOpcionDePago() {
		makePaymentObjet.hacerClickBotonMakePayment();
	}
	@Step
	public void diligenciarElFormularioDePago(String ph, String nm, String amt) {
		makePaymentObjet.ingresarTelefono(ph);
		makePaymentObjet.ingresarNombre(nm);
		makePaymentObjet.ingresarCantidad(amt);
		
		
		
	}

	@Step
	public void seleccionarPais(String cty) throws InterruptedException{
		
		makePaymentObjet.realizarClicSelect();
		makePaymentObjet.seleccionarPais(cty);
		
		
		
	}
	@Step
	public void realizarPagoExitoso() {
		makePaymentObjet.enviarSolicitud();
		makePaymentObjet.clickBotonYes();
		
		
	}

}
