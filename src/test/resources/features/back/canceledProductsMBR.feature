Feature: Servicio - MBR canceledProductsMBR

  @canceledProductsMBR
  Scenario Outline: Llamada al metodo POST canceledProductsMBR
    Given Se realiza un login exitoso con "<user>" "<pass>" "<deviceId>"
    When Realiza la consulta canceledProductsMBR con "<channel>" "<transactionId>" "<clientNumber>"
    Then Se verifica el codigo de respuesta que devuelve

    Examples: 
      | user     | pass     | deviceId| channel |transactionId  | clientNumber |
      | corona01 | Prueba01 |         | mbr		  | xxxx 					| 04647871		 |