@backEnd
Feature: Servicio - llamada al metodo POST listExtractionMBR

  @listExtractionMBR
  Scenario Outline: llamada al metodo POST listExtractionMBR
    Given se ejecuta el login con "<user>" "<pass>" "<deviceId>" de manera correcta
    When llamo al metodo listExtractionMBR con "<channel>" "<transactionId>" 
    Then validamos el codigo del response

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												|
      |U92308675|prueba01|					| mbr			 | pruebaCardlessExtraction202111291425 |


