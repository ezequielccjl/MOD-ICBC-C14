Feature: Servicio - cardExpensesRecentBLR

  @cardExpensesRecentBLR
  Scenario Outline: Llamada al metodo POST cardExpensesRecentBLR
    Given Se preparan las especificaciones requeridas para el metodo
    When Realiza la consulta con los datos a cardExpensesRecentBLR con "<transactionId>" "<typeOp>" "<cardNumber>" "<typeCard>" "<errorCode>"
    Then Se verifica el codigo de respuesta devuelto

    Examples: 
    	|transactionId         							  | typeOp | cardNumber 			| typeCard | errorCode  |
      |8a33ff49-64adce33-0164-add58e7b-0032 | T			 | 4423120001404711 | visa 		 |    			  |
      |8a33ff49-64adce33-0164-add58e7b-0032 | T			 | 4423120001404711 | 		 		 | error data |

