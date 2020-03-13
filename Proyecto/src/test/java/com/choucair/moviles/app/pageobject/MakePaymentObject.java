package com.choucair.moviles.app.pageobject;
import static com.choucair.moviles.app.ui.MakePaymentUI.*;

import java.util.List;

import com.choucair.moviles.app.utils.MobilePageObject;

import net.serenitybdd.core.annotations.findby.By;

import com.choucair.moviles.app.utils.AccionesObjetos;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class MakePaymentObject extends MobilePageObject{
	public MakePaymentObject(WebDriver driver){super(driver);}
	
	AccionesObjetos accionesObjetosFormPay;
	

	public void hacerClickBotonMakePayment()
	{
		accionesObjetosFormPay.clickObjeto(btnMakePayment);
	}
	
	
	public void ingresarTelefono(String ph) {
	
		accionesObjetosFormPay.setInputText(txtPhone, ph );
	}
	
	public void ingresarNombre(String nm) {
		accionesObjetosFormPay.setInputText(txtName, nm);
		
	}
	
	public void ingresarCantidad(String amt) {
		
		accionesObjetosFormPay.setInputText(txtamount, amt);
		
	}
	
	public void realizarClicSelect() {
		
		accionesObjetosFormPay.clickObjeto(btnSelect);
		
	}

	public void seleccionarPais(String cty) throws InterruptedException   {
		
		if(accionesObjetosFormPay.isAndroid()) {
		accionesObjetosFormPay.selecctScroll(cty);
		
		}else{
			
			selectScrollIos2(cty);	
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
					accionesObjetosFormPay.clickObjeto(e);
					 break buscarpais;
				 	}
			 }	
			System.out.println("entrando a vertical swipe");
			verticalSwipe();
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
	      
	       accionesObjetosFormPay.swipe(x, starty, x, endy);
       
	
   }
	public void enviarSolicitud() {
	
		accionesObjetosFormPay.clickObjeto(send);
		
	}
	
	public void clickBotonYes() {
		
		accionesObjetosFormPay.clickObjeto(btnyes);
		
	}
	
	
	
	public void clickBotonNo() {

		accionesObjetosFormPay.clickObjeto(btnNo);
		
	}

	
	
}