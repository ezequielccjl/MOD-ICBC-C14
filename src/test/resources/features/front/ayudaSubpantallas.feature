@pantallaAyuda
Feature: El usuario navega por todas las subpantallas de Ayuda

  Scenario Outline: Navegacion por Ayuda
    Given El usuario hace el Login con "<user>" "<password>"
    When Entra a la pestania mas y selecciona ayuda
    And Navega por preguntas frecuentes
    And Navega por terminos y condiciones
    And Navega por politicas de privacidad
    And Navega por seguridad
    And Navega por contacto
    Then Verifica que la navegacion haya sido correcta

    Examples:
		| user    | password |
		|corona01 | Prueba01 |
