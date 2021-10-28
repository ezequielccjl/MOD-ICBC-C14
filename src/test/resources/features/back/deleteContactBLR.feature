Feature: Servicio - BLR Agenda deleteContact

  @deleteContactBLR
  Scenario Outline: Llamada al metodo POST deleteContact
    Given El usuario se loguea con "<user>" "<pass>" "<deviceId>"
    When Realiza la consulta con los datos "<transactionId>" "<channel>" "<documentNumber>" "<documentCode>" "<destinationCbuCvuAlias>" 
    Then Verifico el codigo de respuesta

    Examples: 
      | user     | pass     | deviceId|transactionId                       | channel| destinationCbuCvuAlias  | documentNumber  | documentCode |
      | corona01 | Prueba01 |         |sergio-pruebas-nuevas7 						 |mbr 		|0150501601000008074781	  |16445351			    |04						 |
