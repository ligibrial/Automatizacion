package com.choucair.moviles.app.definitions;
import com.choucair.moviles.app.steps.ExpenseReportSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ExpenseReportDefinitions {


	@Steps
	ExpenseReportSteps expenseReportSteps;

	@When("^Selecciono informe$")
	public void seleccionoInforme() {
	  expenseReportSteps.seleccionoInforme();
	}

	@When("^Selecciono varios informes$")
	public void seleccionoVariosInformes() {

	  expenseReportSteps.seleccionoVariosInformes();
	}


	@Then("^valido elementos ingresados$")
	public void validoElementosIngresados() {
	}



}