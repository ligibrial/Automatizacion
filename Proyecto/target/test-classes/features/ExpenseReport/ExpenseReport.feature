#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@ExpenseReport
Feature: Pruebas en el modulo de ingreso a la app

		@ExpenseReportExitoso
		  Scenario Outline: Informe de gastos exitoso
		    Given Iniciar App Eribank
		    And Iniciar Sesion Exitosa <Usuario> <Contrasena>
		    And Verificar Acceso App <Mensaje>
		    When Selecciono informe 
		    And Selecciono varios informes
		    Then valido elementos ingresados
		    
		    Examples: 
		    |Usuario  |Contrasena|Mensaje             |
		    |"company"|"company" |"Your balance is: " |

