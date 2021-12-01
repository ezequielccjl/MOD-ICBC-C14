Feature: Servicio - llamada al metodo POST applePayIsEnabledMBR

  @applePayIsEnabledMBR
  Scenario Outline: llamada al metodo POST applePayIsEnabledMBR
    Given se prepara el logueo con los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo applePayIsEnabledMBR con "<transactionId>"
    Then se valida que el code sea el esperado

    Examples: 
      | user		| pass	 | deviceId | transactionId												 |
      |F27308585|prueba01|					| 9af0313d-8ae5-4455-bde8-cfb7acf08c5b |