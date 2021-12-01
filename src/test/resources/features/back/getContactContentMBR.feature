Feature: Servicio - llamada al metodo POST getContactContentMBR

  @getContactContentMBR
  Scenario Outline: llamada al metodo POST getContactContentMBR
    Given nos logueamos con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getContactContentMBR con "<channel>" "<transactionId>"
    Then validamos que el codigo sea correcto

    Examples: 
      | user		| pass	 | deviceId | channel |transactionId												|
      |F27308585|prueba01|					| mbr 		|9f73364f-28e4-4729-84b8-47363713a7c4 |


