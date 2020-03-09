#Author: Adrian

@Login
Feature: Pruebas en el modulo de ingreso a la app

		@LoginExitoso
		  Scenario Outline: Realizar login exitoso
		    Given Iniciar App Eribank
		    When Iniciar Sesion Exitosa <Usuario> <Contrasena>
		    Then Verificar Acceso App <Mensaje>
		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje             |
		      |"company"|"company" |"Your balance is: " |