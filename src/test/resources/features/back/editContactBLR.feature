@backEnd
Feature: Servicio - BLR Agenda editContact

  @editContactBLR
  Scenario Outline: Llamada al metodo POST editContact
    Given El usuario loguea con "<user>" "<pass>" "<deviceId>"
    When Hace la consulta con los datos "<transactionId>" "<channel>" "<destinationCbuCvuAlias>" "<documentNumber>" "<documentCode>" "<cuitCuilNumber>" "<cbuNumber>" "<description>" "<accountCode>" "<errorCode>"
    Then Verifico la respuesta

    Examples: 
      | user      | pass     | deviceId|transactionId                      | channel| destinationCbuCvuAlias  | documentNumber  | documentCode | cuitCuilNumber  |cbuNumber							|description|accountCode| errorCode |
      | F27308585 | Prueba01 |         |sergio-pruebas-nuevas10						 |mbr 		|8927341627389432345678	  |16445351			    |04						 |27148193342      |0150501601000008074781|del carmen |04         |						|
      | F27308585 | Prueba01 |         |sergio-pruebas-nuevas10						 |mbr 		|8927341627389432345678	  |							    |04						 |27148193342      |0150501601000008074781|del carmen |04         |	1000			|
