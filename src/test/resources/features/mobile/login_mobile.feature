@LoginMobile
Feature: Login Mobile ICBC AA
  
  @tag2
  Scenario Outline: El usuario se loguea en ICBC
    Given El usuario se encuentra en la app ICBC
    When Completa "<user>" "<password>"presiona ingresar
    Then Verifica que se haya logueado correctamente

    Examples: 
      | user  		| password |
      | U10567381 | prueba01 | 
