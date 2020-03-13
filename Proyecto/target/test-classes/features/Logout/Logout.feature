@Logout 
Feature: Pruebas en el modulo de ingreso a la app

		@LogoutExitoso
		  Scenario Outline: Realizar pago exitoso
		    Given Usuario ingresa a la app Eribank
		    And Inicia Sesion Exitosa <Usuario> <Contrasena>
		    And Verifica el Acceso App <Mensaje>
		    When El usuario sale de la app
		    Then verifica salida exitosa
		    
		    		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje            |
		      |"company"|"company" |"Your balance is: "|
		      
		      
