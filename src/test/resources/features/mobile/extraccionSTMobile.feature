@ExtraccionST-Mobile
Feature: El usuario realiza una extraccion sin tarjeta

  @ExtraccionST-Mobile-TA-Limites
  Scenario Outline: Orden de extraccion sin tarjeta: Comprobacion de limites
    Given Me logueo con el usuario "<user>" y la pass "<pass>"
    When Clickea en Mas
    And Selecciona Extraccion sin tarjeta
    And Selecciona nueva extraccion
    And Completa campos para verificar "<montoInferior>"
    And Completa correctamente "<origen>" "<montoSuperior>" "<tipo>" "<numero>" y presiona continuar
    Then Verifica orden completada

    Examples:
		| user       | pass | origen | montoInferior | montoSuperior| tipo | numero   |
		|u92308675   | prueba01 | 39/29  | 				1 		 |30000   				| DNI	 | 32532678 |
		#|u92308675   | prueba01 | 39/29  | 				1			 |20000  				| DNI	 | 32532678 |
