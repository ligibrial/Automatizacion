package com.choucair.moviles.app.pageobject;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.choucair.moviles.app.ui.MortagageRequestUI.*;

import java.util.List;

import com.choucair.moviles.app.utils.AccionesObjetos;
import com.choucair.moviles.app.utils.MobilePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.annotations.findby.By;
public class  MortgageRequestObject extends MobilePageObject{
	public  MortgageRequestObject(WebDriver driver){super(driver);}
	
	AccionesObjetos accionesObjetosMort;
	
	public void ingresarMortgage() {
		 accionesObjetosMort.clickObjeto(btnMortagageRequest);
	}
	
	public void ingresarNombre(String nombre) {
		accionesObjetosMort.setInputText(txtfirstName, nombre);
	}
	
	public void ingresarApellido(String apellido) {
		accionesObjetosMort.setInputText(txtLastName,apellido);
	}
	
	public void ingresarEdad(String edad) {
		accionesObjetosMort.setInputText( txtage, edad);
	}
	
	public void ingresarDireccion(String direccion) {
		accionesObjetosMort.setInputText(txtAddress1, direccion);
	}
	
	public void ingresarDireccion2(String direcciondos) {
		accionesObjetosMort.setInputText(txtAddress2, direcciondos);
	}
		
	public void realizarClicSelect() {
		if(accionesObjetosMort.isAndroid()) {
		accionesObjetosMort.clickObjeto(btnSelect2);		
		}
	}
	
	public void ingresarNext() {
		accionesObjetosMort.clickObjeto(btnNext);
	}
	
	public void seleccionarCountry(String country) {
		
		if(accionesObjetosMort.isAndroid()) {
		 accionesObjetosMort.selecctScroll(country);
		 
		}else {
			System.out.println("entrando a Ios");
			accionesObjetosMort.setInputText( coun,country );
		}
	}

	
	
	public void diligenciarElFormularioNext(String Loan,String Years, String Occupation, String Income) {
		if (accionesObjetosMort.isAndroid()) {
			
			//appiumDriver.findElementsByIosUIAutomation("collectionViews()[0].cells().withPredicate(\"ANY staticTexts.isVisible == TRUE\")");
		accionesObjetosMort.selecctScroll(Loan);
		accionesObjetosMort.selecctScroll(Years);
		accionesObjetosMort.selecctScroll(Occupation);
		accionesObjetosMort.selecctScroll(Income);
		
	
		
		}else{

		selectScrollIos2(Loan);
		selectScrollIos2(Years);
		selectScrollIos2(Occupation);
		selectScrollIos2(Income);
			
			

		
		}
	
    }
	
	
	public void selectScrollIos2(String param) {
		
		List<WebElement> tabList = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
		System.out.println(tabList);
		 buscarpais:
		 for(int i=0; i<=2;i++) {
			for(WebElement e : tabList) {
				System.out.println(e.getText());
				 System.out.println("isDisplayed"+e.isDisplayed());
				 if (e.getText().contains(param)&& e.isDisplayed()) {
					 System.out.println(e.isDisplayed());
					 System.out.println("el texto esta contenido en"+e.getText().contains(param));
					 System.out.println("e.gettext"+e.getText());
					 System.out.println("el pais es"+param);
					 System.out.println("el objeto es "+e);
					 accionesObjetosMort.clickObjeto(e);
					 break buscarpais;
				 	}
			 }	
			System.out.println("entrando a vertical swipe");
			verticalSwipe();
		 }
		}
	
	public void realizarClicGuardar() {
	

		if (accionesObjetosMort.isAndroid()) {
		WebElement element6 = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+"com.experitest.ExperiBank:id/saveButton"+"\").instance(0))"));
		element6.click();
		}else {
			accionesObjetosMort.clickObjeto(btnGuardar);
		}
	}
	

	
	
	public void verticalSwipe() {
	    Dimension dim = (getDriver().manage().window().getSize());
		System.out.println("la dimension es"+dim);
		   int height=dim.getHeight();
		   int width= dim.getWidth();
		   int x = width/2;
		   int starty= (int)(height*0.80);
	       int endy= (int)(height*0.20);
	      
	       accionesObjetosMort.swipe(x, starty, x, endy);
       
	
   }
}




