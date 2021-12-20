Feature: Servicio - getAvailableCardMBR

  @getAvailableCardMBR
  Scenario Outline: Llamada al metodo POST getAvailableCardMBR
    Given Se realiza login con "<user>" "<pass>" "<deviceId>" correctamente
    When Se realiza la consulta al metodo getClientData con "<transactionIdGetClientData>"
    And Se realiza la consulta al metodo listProducts con "<transactionIdListProductCard>"
		And Se realiza la consulta al metodo getAvailableCardMBR con "<channel>"
    Then Se verifica la response devuelta

    Examples: 
      | user     	| pass     | deviceId|transactionIdGetClientData          | transactionIdListProducts		 			 	| channel  |
      | F27308585 | prueba01 |         |ea3b0a4d-4541-4251-a364-045a3a3e51e6| c88e9362-fe9a-43e6-945c-0a11ed70da6f| MBR 		 |

      
