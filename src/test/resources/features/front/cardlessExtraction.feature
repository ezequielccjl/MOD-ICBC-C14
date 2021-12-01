@cardlessExtraction
Feature: El usuario realiza una extraccion sin tarjeta

  Scenario Outline: Orden de extraccion sin tarjeta: Comprobacion de limites
    Given El "<user>" hace log con "<password>"
    When Clickea pestania mas
    And Selecciona Extraccion sin tarjeta
    And Selecciona nueva extraccion
    And Completa campos para verificar "<montoInferior>"
    And Completa correctamente "<origen>" "<montoCorrecto>" "<tipo>" "<numero>" y presiona continuar
    Then Verifica orden completada

    Examples:
		| user     | password | origen | montoInferior | montoCorrecto| tipo | numero   |
		|corona01  | prueba01 | 39/29  | 				1 		 |2000   				| DNI	 | 11222333 |
		|corona01  | prueba01 | 39/29  | 				1			 |25000  				| DNI	 | 11222333 |
		
		@cardlessMaximos
		Scenario Outline: Orden de extraccion sin tarjeta: Repeticion hasta comprobar monto y numero maximo
    Given El "<user>" hace log in con "<password>"
    When Clickea en la pestania mas
    And Selecciona opcion Extraccion sin tarjeta
    And Selecciona nueva extraccion sin tarjeta
    And Completa "<origen>" "<monto>" "<tipo>" "<numero>" segun la cantidad de "<loops>"
    Then Verifica la orden completada

    Examples:
		| user     | password | origen | monto | tipo  | numero   | loops |
		|corona01  | prueba01 | 39/29  | 2000	 | DNI	 | 11222333 | 5			|
		|corona01  | prueba01 | 39/29  | 1500  | DNI	 | 11222333 | 6			|
		
		
		
		
