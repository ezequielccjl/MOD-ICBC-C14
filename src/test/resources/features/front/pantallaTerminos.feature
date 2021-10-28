Feature: El usuario se dirige a la pantalla Terminos y Condiciones

  @pantallaTerminos
  Scenario Outline: Ingreso a Terminos y Condiciones
    Given El usuario se loguea con "<user>" "<password>"
    When Presiona en la pestania mas
    And Selecciona Ayuda
    And Selecciona terminos y condiciones
    Then Verifica que se encuentre en terminos y condiciones

    Examples:
		| user    | password |
		|corona01 | Prueba01 |
