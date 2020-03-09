
@MortgageRequest
Feature: Realizar una hipoteca

  @MortgageRequestExitoso
  Scenario: Realizar hipoteca 
    Scenario Outline: Realizar hipoteca exitoso
         Given Iniciar App Eribank
		    And Iniciar Sesion Exitosa <Usuario> <Contrasena>
		    And Verificar Acceso App <Mensaje>
		    When Ingreso a la opcion Mortgage Request
		    And diligencio formulario Mort <Nombre><Apellido><Edad><Direccion1><Direccion2>
		    And Seleccionar country <Pais>
		    And diligenciar el formulario next <Loan><Years><Occupation><Income>
		    Then Realizar hipoteca exitoso
		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje             |Phone  |Name    |Amount|Nombre  |Apellido    |Edad      |Direccion1    |Direccion2 |Pais      |Loan         |  Years     |Occupation           | Income       | 
		      |"company"|"company" |"Your balance is: " |"777" |"nombre"| "500"|"juan"  | "rodrig"   |"12"      |  "calle1"    |"calle2"   |"Argentina"   |"Car"	       | "15"       | "Agricultural"      | "1,000,000"  |     
		   