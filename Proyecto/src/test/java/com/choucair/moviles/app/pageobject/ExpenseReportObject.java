package com.choucair.moviles.app.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.choucair.moviles.app.utils.AccionesObjetos;
import com.choucair.moviles.app.utils.MobilePageObject;
import static com.choucair.moviles.app.ui.ExpenseReportUI.*;
import static com.choucair.moviles.app.ui.LoginUI.lblMensaje;

import java.util.List;

public class ExpenseReportObject extends MobilePageObject{
	public ExpenseReportObject(WebDriver driver){super(driver);}
	AccionesObjetos accionesObjetosExpense;
	
	public void seleccionarExpense() {
		accionesObjetosExpense.clickObjeto(btnExpense);
		
	}
	
	public void añadir() {
       for (int i=0;i<2;i++) {
			accionesObjetosExpense.clickObjeto(btnAdd);
			}

	}
	
	
	public String obtenerMensajeLabel2()
	{
		
		return accionesObjetosExpense.esperarObtenerObjetos(lblMensaje).getText();
	}
	
	public void verificar() {
		if(accionesObjetosExpense.isAndroid()) {
		 List<WebElement> tabList = getDriver().findElements(By.className("android.widget.TextView"));
		 int num=tabList.size()-1;
		
		 for (WebElement e : tabList) {
			 e.getText();
			 if(e.getText().contains("Expense")){
			
				 System.out.println("elementos agregados"+e.getSize());
			 }
		 }
		}else {
			
		 List<WebElement> tabList = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
		 int num=tabList.size()-1;
		 for (WebElement e : tabList) {
			 e.getText();
			 if(e.getText().contains("Expense")){
				System.out.println("elementos agregados"+e.getSize());
				 }
			 }
		}
	 }
	
	

}
