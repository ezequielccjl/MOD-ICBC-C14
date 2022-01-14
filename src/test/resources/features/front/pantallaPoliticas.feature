Feature: El usuario se dirige a la pantalla Politicas y Privacidad

  @pantallaPoliticas
  Scenario Outline: Ingreso a Politicas y Privacidad
    Given El usuario se loguea con "<user>" y "<password>"
    When Presiona la pestania Mas
    And Selecciona ayuda
    And Selecciona politicas y privacidad
    Then Verifica que se encuentre en politicas y privacidad

    Examples:
		| user    | password |
		|U8295439 | prueba01 |
