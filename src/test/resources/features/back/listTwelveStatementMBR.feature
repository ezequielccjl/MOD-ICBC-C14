Feature: Servicio - list twelve statement MBR

  @listTwelveStatementMBR
  Scenario Outline: Llamada al metodo POST listTwelveStatementMBR
    Given El usuario realiza login con "<user>" "<pass>" "<deviceId>"
    When Realiza la consulta al metodo getClientData con "<transactionIdGetClientData>"
    And Realiza la consulta al metodo listProductCard con "<transactionIdListProductCard>"
		And Realiza la consulta al metodo listTwelveStatementMBR con "<transactionIdListTwelveStatementMBR>" "<canceledIndicator>" "<cardProductIndexNumber>" "<cardBrandIndicatorCode>"
    Then Verifico la response

    Examples: 
      | user     | pass     | deviceId|transactionIdGetClientData          | transactionIdListProductCard 			 | transactionIdListTwelveStatementMBR  | canceledIndicator  | cardProductIndexNumber | cardBrandIndicatorCode  |
      | corona01 | Prueba01 |         |ea3b0a4d-4541-4251-a364-045a3a3e51e6| 0d27a017-b54b-413e-925c-7c88c500c7c2| e7601672-248e-4aec-94ef-8359f32ec339 | false						   | 1											| mastercard              |

      
