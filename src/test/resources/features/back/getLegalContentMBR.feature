@backEnd
Feature: Servicio - llamada al metodo POST getLegalContentMBR

  @getLegalContentMBR
  Scenario Outline: llamada al metodo POST getLegalContentMBR
    Given se ejecuta el login con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getLegalContentMBR con "<channel>" "<transactionId>"
    Then se valida el response code

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												|
      |F27308585|prueba01|					| mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |

