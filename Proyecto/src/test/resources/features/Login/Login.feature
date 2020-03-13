#Author: Adrian

@Login
Feature: Pruebas en el modulo de ingreso a la app

		@LoginExitoso
		  Scenario Outline: Realizar login exitoso
		    Given Usuario ingresa a la app Eribank 
		    When Inicia Sesion Exitosa <Usuario> <Contrasena>
		    Then Verifica el Acceso App <Mensaje>
		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje             |
		      |"company"|"company" |"Your balance is: " |