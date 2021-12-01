Feature: Servicio - llamada al metodo POST modifyUserLogonMBR

  @modifyUserLogonMBR
  Scenario Outline: llamada al metodo POST modifyUserLogonMBR
    Given realizamos el login con los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo modifyUserLogonMBR con "<channel>" "<transactionId>" "<klogonUserId>" "<klogonType>" "<klogonNum>" "<klogonPass>" "<kgender>"
    Then validamos que el codigo de respuesta sea el esperado

    Examples: 
      | user		| pass	 | deviceId | channel | transactionId												| klogonUserId | klogonType | klogonNum | klogonPass | kgender |
      |F27308585|prueba01|					| mbr			|9f73364f-28e4-4729-84b8-47363713a7c4 | m20444413		 | 04 				| 20444413  | prueba01   | M			 |