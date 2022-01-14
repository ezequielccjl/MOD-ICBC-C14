@backEnd
Feature: Servicio - llamada al metodo POST getSegCanalesContentMBR

  @getSegCanalesContentMBR
  Scenario Outline: llamada al metodo POST getSegCanalesContentMBR
    Given ejecutamos el login con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getSegCanalesContentMBR con "<channel>" "<transactionId>"
    Then validamos el codigo de la respuesta

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												|
      |F27308585|prueba01|					| mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |
