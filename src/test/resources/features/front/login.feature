@login
Feature: Login - ICBC Modernizacion

  @loginSatisfactorio
  Scenario Outline: El usuario realiza logueo
    Given El usuario se encuentra en la App
    When Ingresa su "<usuario>" y "<contrasenia>"
    And Presiona ingresar
    Then Verifica "<respuestaEsperada>"
    
    Examples: 
      | usuario  | contrasenia | respuestaEsperada |
      | corona01 | prueba01		 | LoginOk					 |
      | usuario53 | wrongPass   | WrongPass				 |

