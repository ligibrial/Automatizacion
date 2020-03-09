package com.choucair.moviles.app.steps;
import com.choucair.moviles.app.pageobject.ExpenseReportObject;
import net.thucydides.core.annotations.Step;

public class ExpenseReportSteps {
	
	ExpenseReportObject expenseReportObject;
	@Step
	public void seleccionoInforme() {
		expenseReportObject.seleccionarExpense();
	  
	}

	@Step
	public void seleccionoVariosInformes() {
	 
		expenseReportObject.añadir();
	}

	@Step
	public void validoElementosIngresados() {
		
		expenseReportObject.verificar();
	}

}
