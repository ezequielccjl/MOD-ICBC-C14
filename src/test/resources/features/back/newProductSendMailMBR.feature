@backEnd
Feature: Servicio - llamada al metodo POST newProductSendMailMBR

  @newProductSendMailMBR
  Scenario Outline: llamada al metodo POST newProductSendMailMBR
    Given se ejecuta login con "<user>" "<pass>" "<deviceId>" para newProductSendMailMBR
    When llamo al metodo getClientData con  "<transactionIdGetClientData>" para newProductSendMailMBR
		And llamo al metodo newProductSendMailMBR con "<channel>" "<transactionId>" "<requestDate>" "<incomeDescription>" "<productDescription>" "<subProductDescription>" "<productCode>" "<subjectDescription>" "<contactPhoneNumber>" "<email>" "<messageCode>"
    Then validamos el codigo que nos devuelve el metodo

    Examples: 
      | user		| pass	 | deviceId | transactionIdGetClientData				   | channel | transactionId 												| requestDate | incomeDescription 		| productDescription | subProductDescription | productCode | subjectDescription 																		| contactPhoneNumber | email 						| messageCode |
      |F27308585|prueba01|					| ea3b0a4d-4541-4251-a364-045a3a3e51e6 | mbr		 | a34f8c43-gda1-4fh7-a11e-248001l98c90 | 2021-09-20  |												| Tarjetas					 | MasterCard Titular    | 61					 | ICBC Mobile Banking  / Solicitud de Nuevos Productos - | 1122334455				 | cliente@mail.com | ok					|
      |F27308585|prueba01|					| ea3b0a4d-4541-4251-a364-045a3a3e51e6 | mbr		 | a34f8c43-gda1-4fh7-a11e-248001l98c90 | 2021-09-20  |												| Tarjetas					 | MasterCard Titular    | 61					 | ICBC Mobile Banking  / Solicitud de Nuevos Productos - | 1122334455				 | cliente@mail.com | fallo				|

    
