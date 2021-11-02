@pantallaResumen
Feature: El usuario quiere visualizar su resumen

  Scenario Outline: Resumen tarjeta de credito
    Given El user "<user>" hace login con "<password>"
    When Se dirige a seccion tarjetas y selecciona su menu
    And Selecciona resumen
    Then Verifica sus resumenes

    Examples:
		| user     | password |
		|M16261074 | prueba01 |
