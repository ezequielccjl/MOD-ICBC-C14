@cardlessExtraction
Feature: El usuario realiza una extraccion sin tarjeta

	@cardlessNormal
  Scenario Outline: Orden de extraccion sin tarjeta: Comprobacion de limites
    Given El "<user>" hace log con "<password>"
    When Clickea pestania mas
    And Selecciona Extraccion sin tarjeta
    And Selecciona nueva extraccion
    And Completa campos para verificar "<montoInferior>"
    And Completa correctamente "<origen>" "<montoCorrecto>" "<tipo>" "<numero>" y presiona continuar
    Then Verifica orden completada

    Examples:
		| user       | password | origen | montoInferior | montoCorrecto| tipo | numero   |
		|u92308675   | prueba01 | 39/29  | 				1 		 |1000   				| DNI	 | 32532678 |
		#|u92308675   | prueba01 | 39/29  | 				1			 |20000  				| DNI	 | 32532678 |
		
		@cardlessMaximos
		Scenario Outline: Orden de extraccion sin tarjeta: Repeticion hasta comprobar monto y numero maximo
    Given El "<user>" hace log in con "<password>"
    When Clickea en la pestania mas
    And Selecciona opcion Extraccion sin tarjeta
    And Selecciona nueva extraccion sin tarjeta
    And Completa "<origen>" "<monto>" "<tipo>" "<numero>" segun la cantidad de "<loops>"
    Then Verifica la orden completada

    Examples:
		| user       | password | origen | monto | tipo  | numero   | loops |
		|u92308675   | prueba01 | 39/29  | 10000 | DNI	 | 32532678 | 2			|
		|u92308675   | prueba01 | 39/29  | 100   | DNI	 | 32532678 | 10			|
		
		
		
		
