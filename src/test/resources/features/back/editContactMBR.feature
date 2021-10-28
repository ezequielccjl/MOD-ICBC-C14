Feature: Servicio - MBR Agenda editContact

  @editContactMBR
  Scenario Outline: Llamada al metodo POST editContactMBR
    Given Usuario loguea con "<user>" "<pass>" "<deviceId>"
    When Realiza consulta con los datos "<transactionId>" "<channel>" "<destinationCbuCvuAlias>" "<cbuNumber>" "<cuitCuilNumber>" "<description>" "<accountCode>"
    Then Verifico el codigo de la respuesta

    Examples: 
      | user     | pass     | deviceId|transactionId                       | channel| destinationCbuCvuAlias  | cuitcuilNumber  | cbuNumber 						| cuitCuilNumber  |description|accountCode|
      | corona01 | Prueba01 |         |sergio-pruebas-nuevas10						 |mbr 		|0150501601000008074781	  |27148193342	    |0150501601000008074781	|27148193342      |del carmen |04         |
