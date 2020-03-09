package com.choucair.moviles.app.steps;
import com.choucair.moviles.app.pageobject.LogoutObject;
import net.thucydides.core.annotations.Step;

public class LogoutSteps {
	
	LogoutObject logoutobject;
	@Step
	public void seleccionarSalir() {
		logoutobject.ingresarLogout();

	}


	@Step
	public void salirExitosamente() {
	  
	}


}
