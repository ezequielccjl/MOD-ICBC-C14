@backEnd
Feature: Servicio - BLR Agenda deleteContact

  @deleteContactBLR
  Scenario Outline: Llamada al metodo POST deleteContact
    Given El usuario se loguea con "<user>" "<pass>" "<deviceId>"
    When Realiza la consulta con los datos "<transactionId>" "<channel>" "<documentNumber>" "<documentCode>" "<destinationCbuCvuAlias>" "<errorCode>" "<schema>"
    Then Verifico el codigo de respuesta

    Examples: 
      | user      | pass     | deviceId|transactionId          | channel| documentNumber  | documentCode | destinationCbuCvuAlias   | errorCode | schema 																		|
      | F27308585 | Prueba01 |         |sergio-pruebas-nuevas7 |mbr 		|16445351			    |04						 |0150501601000008074781	  |					  | schemas/schemaDeleteContactBLR_ok.json	  |
      | F27308585 | Prueba01 |         |sergio-pruebas-nuevas7 |mbr 		|							    |04						 |0150501601000008074781	  | 1000			| schemas/schemaDeleteContactBLR_error.json |
