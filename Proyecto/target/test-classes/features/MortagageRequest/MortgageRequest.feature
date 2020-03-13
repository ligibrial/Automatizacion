
@MortgageRequest
Feature: Realizar una hipoteca

  @MortgageRequestExitoso
  Scenario: Realizar hipoteca 
    Scenario Outline: Realizar hipoteca exitoso
         Given Usuario ingresa a la app Eribank
		    And Inicia Sesion Exitosa <Usuario> <Contrasena>
		    And Verifica el Acceso App <Mensaje>
		    When El usuario hace la solicitud de hipoteca 
		    And Diligencia los datos de la solicitud hipoteca <Nombre><Apellido><Edad><Direccion1><Direccion2>
		    And Selecciona ubicacion para realizar solicitud <Pais>
		    And Selecciona los datos de la solicitud hipoteca <Loan><Years><Occupation><Income>
		    Then Verifica la solicitud exitosa
		      
		    Examples: 
		      |Usuario  |Contrasena|Mensaje             |Phone  |Name    |Amount|Nombre  |Apellido    |Edad      |Direccion1    |Direccion2 |Pais      |Loan         |  Years     |Occupation           | Income       | 
		      |"company"|"company" |"Your balance is: " |"777" |"nombre"| "500"|"juan"  | "rodrig"   |"12"      |  "calle1"    |"calle2"   |"Argentina"   |"Car"	       | "15"       | "Agricultural"      | "500,000"  |     
		   