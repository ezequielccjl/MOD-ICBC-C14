@backEnd
Feature: Servicio - llamada al metodo checkLimitTransactionMBR

@checkLimitTransactionMBR
Scenario Outline: se llama al metodo checkLimitTransactionMBR
	Given se prepara el login para el metodo checkLimitTransactionMBR con los datos "<klogonUserId>" "<klogonPass>" "<kdeviceId>"
	When se ejecuta el metodo checkLimitTransactionMBR con los datos "<transactionId>" "<channel>" "<dateOperMin>" "<dateOperMax>" "<currency>"	
	Then se chequea la respuesta esperada
	
	Examples:
		| klogonUserId | klogonPass | kdeviceId | transactionId 											 | channel | dateOperMin | dateOperMax | currency |
		| F27308585		 | prueba01   | 					| 8a33ff49-64adce33-0164-add58e7b-0032 | mbr		 | 2019-11-27  | 2019-11-29  | $				|

		
		