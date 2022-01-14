@backEnd
Feature: Servicio - llamada al metodo cardExpensesRecentMBR

@cardExpensesRecentMBR
Scenario Outline: se llama al metodo cardExpensesRecentMBR
	Given se prepara el login para el metodo con los datos "<klogonUserId>" "<klogonPass>" "<kdeviceId>"
	When se ejecuta el paso intermedio listProducts con los datos "<transactionIdListProducts>"
	And se ejecuta el metodo cardExpensesRecentMBR con los datos "<transactionId>" "<productId>" "<errorCode>"
	Then se chequea que el response code sea el esperado
	
	Examples:
		| klogonUserId | klogonPass | kdeviceId | transactionIdListProducts 					 | transactionId 												| productId | errorCode | 
		| F27308585		 | prueba01   | 					| c88e9362-fe9a-43e6-945c-0a11ed70da6f | 8a33ff49-64adce33-0164-add58e7b-0032 | 0					| 					|
		| F27308585		 | prueba01   | 					| c88e9362-fe9a-43e6-945c-0a11ed70da6f | 8a33ff49-64adce33-0164-add58e7b-0032 | 					| 	error		|