#Author: your.email@your.domain.com


@MakePayment
Feature: Pruebas en el modulo de ingreso a la app

		@MakePaymentExitoso
		  Scenario Outline: Realizar pago exitoso
		    Given Usuario ingresa a la app Eribank 
		    And Inicia Sesion Exitosa <Usuario> <Contrasena>
		    And Verifica el Acceso App <Mensaje>
		    When Realiza el pago  
		    And Diligencia los datos de pago <Phone><Name><Amount>
		    And Selecciona la ubicación de envio  <Pais>
		    Then Realiza pago exitoso 
		    
		    
	Examples: 
		      |Usuario  |Contrasena| Mensaje             |Phone  |Name    |Amount |Pais       |
		      |"company"|"company" |"Your balance is: "| "777" |"nombre"| "500" |"Spain"    |
		      
		      
	 
