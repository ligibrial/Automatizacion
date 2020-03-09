package com.choucair.moviles.app.pageobject;
import static com.choucair.moviles.app.ui.MakePaymentUI.*;
import com.choucair.moviles.app.utils.MobilePageObject;
import com.choucair.moviles.app.utils.AccionesObjetos;
import org.openqa.selenium.WebDriver;




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
	    String dr="";
		accionesObjetosFormPay.selecctScroll(cty);
			
		}else{
	     String dr="up";
		accionesObjetosFormPay.selectScrollIos(cty,  dr);
		}
	}
	

	
	
}