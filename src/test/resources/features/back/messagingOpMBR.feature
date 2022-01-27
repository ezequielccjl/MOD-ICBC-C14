@backEnd
Feature: Servicio - llamada al metodo POST messagingOpMBR

  @messagingOpMBR
  Scenario Outline: llamada al metodo POST messagingOpMBR
    Given se realiza el login exitosamente con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getClientData con "<transactionId>" 
    And llamo al metodo messagingOpMBR con "<channel>" "<show>"
    Then validamos el codigo de respuesta que se devuelve

    Examples: 
      | user 		| pass	 | deviceId | transactionId												| channel | show |
      |F27308585|prueba01|					| 9f73364f-28e4-4729-84b8-47363713a7c4| MBR 		| N		 |
