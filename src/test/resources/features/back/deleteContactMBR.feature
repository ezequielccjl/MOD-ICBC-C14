Feature: Servicio - llamada al metodo POST deleteContactMBR

  @deleteContactMBR
  Scenario Outline: llamada al metodo POST deleteContactMBR
    Given se ejecuta el login con "<user>" "<pass>" "<deviceId>" correcto
    When llamamos al metodo addContactMBR con los datos CONTINUAR ACA, ADDCONTACT NO DISPONIBLE TODAVIA. NECESITA PASOS INTERMEDIOS GETCLIENT Y LISTPRODCARD
    When llamo al metodo deleteContactMBR con "<transactionId>" "<senderAccountNumber>" "<senderAccountCode>" "<mandateId>" "<dueDate>" "<amount>" "<beneficiaryDocumentNumber>" "<beneficiaryDocumentCode>" "<errorCode>"
    Then validamos el codigo que nos devolvio el metodo

    Examples: 
      | user		| pass	 | deviceId | transactionId											   | senderAccountNumber | senderAccountCode | mandateId | dueDate 		| amount | beneficiaryDocumentNumber | beneficiaryDocumentCode | errorCode |
      |U92308675|prueba01|					| pruebaCardlessExtraction202111291425 | 05010103819429			 | 01								 | 2934			 | 2021-12-09 | 1000.0 | 32532678									 | 04											 |					 |
      |U92308675|prueba01|					| pruebaCardlessExtraction202111291425 | 05010103819429			 | 01								 | 					 | 2021-12-09 | 1000.0 | 32532678									 | 04											 | Error.ws		 |
    
