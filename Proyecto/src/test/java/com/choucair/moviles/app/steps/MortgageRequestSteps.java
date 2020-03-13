package com.choucair.moviles.app.steps;
import com.choucair.moviles.app.pageobject.MortgageRequestObject;
import net.thucydides.core.annotations.Step;

public class MortgageRequestSteps {
	MortgageRequestObject mortgageRequestOject;
	

	@Step
	public void ingresoALaOpcionMortgageRequest() {
		mortgageRequestOject.ingresarMortgage();
	  
	}
	

	
	
	@Step 
	public void diligencioFormularioMort(String nombre, String apellido , String edad, String direccion1, String direccion2) {
		mortgageRequestOject.ingresarNombre(nombre);
		mortgageRequestOject.ingresarApellido(apellido);
		mortgageRequestOject.ingresarEdad(edad);
		mortgageRequestOject.ingresarDireccion(direccion1);
		mortgageRequestOject.ingresarDireccion2(direccion2);
		//mortgageRequestOject.ingresarNext();
		 mortgageRequestOject.realizarClicSelect();
		
		
	}
	
   @Step
	
	public void seleccionarCountry(String country) {
		//primera linea descomentada para android
		//mortgageRequestOject.realizarClicSelect();
		mortgageRequestOject.seleccionarCountry(country);
	;
	}

	@Step

	
	public void diligenciarElFormularioNext(String Loan,String Years, String Occupation, String Income) {
		mortgageRequestOject.ingresarNext();
		mortgageRequestOject.diligenciarElFormularioNext(Loan, Years, Occupation, Income);

	}

	@Step
	public void realizarHipotecaExitoso() {
		
		mortgageRequestOject.realizarClicGuardar();
	 
	}

}
