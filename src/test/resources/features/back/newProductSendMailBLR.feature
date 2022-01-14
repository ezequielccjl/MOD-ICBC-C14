@backEnd
Feature: Servicio - llamada al metodo POST newProductSendMailBLR

  @newProductSendMailBLR
  Scenario Outline: llamada al metodo POST newProductSendMailBLR
    Given preparamos las especificaciones necesarias del metodo
    When llamamos al metodo newProductSendMailBLR con "<channel>" "<transactionId>" "<replyName>" "<formatCode>" "<mailId>" "<subjectDescription>" "<replyEmailName>" "<fromName>" "<fromAddressEmail>" "<toName>" "<toAddressEmail>" "<ccName>" "<ccAddressEmail>" "<bcName>" "<bcAddressEmail>" "<requestDate>" "<documentNumber>" "<clientName>" "<productName>" "<templateName>" "<clientSurName>" "<incomeNumber>" "<subProductName>" "<phoneNumber>" "<email>" "<messageCode>"
    Then validamos el code que nos trajo la respuesta

    Examples: 
      | channel | transactionId												 | replyName | formatCode | mailId 															 | subjectDescription 																						 | replyEmailName | fromName 						| fromAddressEmail 				| toName 						| toAddressEmail 					| ccName | ccAddressEmail 								 | bcName 	 | bcAddressEmail 				| requestDate | documentNumber | clientName 	 | productName | templateName 					 | clientSurName | incomeNumber | subProductName 		 | phoneNumber | email 						| messageCode	|
      | mbr		 	| a34f8c43-eda1-4fc4-a11e-248901a04c72 | 					 | html				| 995e9c00-760a-4mkb-b02d-8468f80ld10v | ICBC Mobile Banking  / Solicitud de Nuevos Productos - 11299956 |								| ICBC Mobile Banking | contactenos@icbc.com.ar | Oficial productos | daiana.ruiz@icbc.com.ar | Matias | sabrina.quinarivera@icbc.com.ar | Sebastian | david.vera@icbc.com.ar | 2021-09-20  | 11299956   		 | ACOELCU DAZEL | Tarjetas		 | mbr_solicitud_productos | DEBERRU			 | 							| MasterCard Titular | 1122334455	 | cliente@mail.com | ok				  |
      | 				| a34f8c43-eda1-4fc4-a11e-248901a04c72 | 					 | html				| 																		 | ICBC Mobile Banking  / Solicitud de Nuevos Productos - 11299956 |								| ICBC Mobile Banking | contactenos@icbc.com.ar | Oficial productos | daiana.ruiz@icbc.com.ar | Matias | sabrina.quinarivera@icbc.com.ar | Sebastian | david.vera@icbc.com.ar | 2021-09-20  | 11299956			 | ACOELCU DAZEL | Tarjetas		 | mbr_solicitud_productos | DEBERRU			 | 							| MasterCard Titular | 1122334455	 | cliente@mail.com | fallo			  |

