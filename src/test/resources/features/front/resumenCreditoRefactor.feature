@pantallaResumenRefactor
Feature: El usuario accede a sus resumenes

  Scenario Outline: Resumen de TC hasta 12 liquidaciones
    Given El "<user>" hace login con "<password>"
    When Clickea en pestania mas
    And Selecciona Resumenes
    And Selecciona Tarjetas
    And Selecciona "<tarjeta>"
    Then Verifica su lista de resumenes

    Examples:
		| user     | password | tarjeta 		|
		|M16261074 | prueba01 | Visa				|
		|M16261074 | prueba01 | Mastercard	|
		
		
