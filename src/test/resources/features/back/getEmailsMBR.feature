@backEnd
Feature: Servicio - llamada al metodo POST getEmailsMBR

  @getEmailsMBR
  Scenario Outline: llamada al metodo POST getEmailsMBR
    Given se prepara el metodo login con los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getClientData
    When llamo al metodo getEmailsMBR con "<transactionId>"
    Then se valida que el code sea el esperado de getEmailsMBR

    Examples: 
      | user		| pass	 | deviceId | transactionId												 |
      |F27308585|prueba01|					| 5544ad82-98e4-496c-8fad-2a900bec2a72 |
