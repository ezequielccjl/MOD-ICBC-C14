@backEnd
Feature: Servicio - llamada al metodo POST getTycContentMBR

  @getTycContentMBR
  Scenario Outline: llamada al metodo POST getTycContentMBR
    Given ejecutamos login con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getTycContentMBR con "<transactionId>"
    Then validamos el response code

    Examples: 
      | user		| pass	 | deviceId | transactionId												|
      |F27308585|prueba01|					| 9f73364f-28e4-4729-84b8-47363713a7c4 |


