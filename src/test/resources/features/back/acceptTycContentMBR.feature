@backEnd
Feature: Servicio - llamada al metodo POST acceptTycContentMBR

  @acceptTycContentMBR
  Scenario Outline: llamada al metodo POST acceptTycContentMBR
    Given se prepara el login con los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo acceptTycContentMBR con "<channel>" "<transactionId>"
    Then se valida que el response code sea correcto

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												|
      |F27308585|prueba01|					| mbr			 | 9af0313d-8ae5-4455-bde8-cfb7acf08c5b |