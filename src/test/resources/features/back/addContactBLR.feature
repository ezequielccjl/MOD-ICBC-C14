@backEnd
Feature: Servicio - BLR Agenda addContact

  @addContactBLR
  Scenario Outline: Llamada al metodo POST addContact
    Given El usuario loguea 
    When Realiza la consulta con "<transactionId>" "<channel>" "<documentNumber>" "<documentType>" "<cuitCuilNumber>" "<cbuNumber>" "<description>" "<accountCode>" "<errorCode>"
    Then Verifico el codigo

    Examples: 
      | user      | pass     | deviceId|transactionId                       | channel| documentNumber   | documentType | cuitCuilNumber  |cbuNumber							|description|accountCode| errorCode |
      | F27308585 | Prueba01 |         |12c21775-afdf-4a08-a0b9-2939360fe1c9|mbr 		 |16445351			    |04						 |27148193342      |0150501601000008074781|del carmen |4          |						|
      | F27308585 | Prueba01 |         |12c21775-afdf-4a08-a0b9-2939360fe1c9|mbr 		 |							    |04						 |27148193342      |0150501601000008074781|del carmen |4          |		1000		|
