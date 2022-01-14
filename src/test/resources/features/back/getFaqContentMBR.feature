@backEnd
Feature: Servicio - llamada al metodo POST getFaqContentMBR

  @getFaqContentMBR
  Scenario Outline: llamada al metodo POST getFaqContentMBR
    Given preparamos el login con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getFaqContentMBR con "<channel>" "<transactionId>"
    Then validamos el codigo de respuesta

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												|
      |F27308585|prueba01|					| mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |
