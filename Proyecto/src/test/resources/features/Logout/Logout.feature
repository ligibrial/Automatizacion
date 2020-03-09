@Logout 
Feature: Pruebas en el modulo de ingreso a la app

		@LogoutExitoso
		  Scenario Outline: Realizar pago exitoso
		    Given Iniciar App Eribank
		    And Iniciar Sesion Exitosa <Usuario> <Contrasena>
		    And Verificar Acceso App <Mensaje>
		    When Seleccionar Salir
		    Then Salir exitosamente
		    
		    		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje            |
		      |"company"|"company" |"Your balance is: "|
		      
		      
