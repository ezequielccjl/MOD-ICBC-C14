@pantallaResumen
Feature: El usuario accede a sus resumenes

  Scenario Outline: Resumen de TC hasta doce liquidaciones
    Given El "<user>" hace login con "<password>"
    When Clickea en pestania mas
    And Selecciona Resumenes
    And Selecciona Tarjetas
    And Selecciona "<tarjeta>"
    Then Verifica su lista de resumenes

    Examples:
		| user      | password | tarjeta 		|
		|M16261074  | prueba01 | Visa				|
		#|U11424824 | prueba01 | Mastercard	|
		#|U18148108 | prueba01 | Visa				|
		#|U21465763 | prueba01 | Visa				|
		
