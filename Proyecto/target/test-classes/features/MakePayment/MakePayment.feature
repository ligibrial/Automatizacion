#Author: your.email@your.domain.com


@MakePayment
Feature: Pruebas en el modulo de ingreso a la app

		@MakePaymentExitoso
		  Scenario Outline: Realizar pago exitoso
		    Given Iniciar App Eribank
		    And Iniciar Sesion Exitosa <Usuario> <Contrasena>
		    And Verificar Acceso App <Mensaje>
		    When Ingreso a la opcion de pago 
		    And Diligenciar el formulario de pago <Phone><Name><Amount>
		    And Seleccionar Pais <Pais>
		    Then Realizar pago exitoso
		    
		    
	Examples: 
		      |Usuario  |Contrasena| Mensaje             |Phone  |Name    |Amount |Pais       |
		      |"company"|"company" |"Your balance is: "| "777" |"nombre"| "500" |"India"    |
		      
		      
	 
