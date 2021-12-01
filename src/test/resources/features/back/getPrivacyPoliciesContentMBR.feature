Feature: Servicio - llamada al metodo POST getPrivacyPoliciesContentMBR

  @getPrivacyPoliciesContentMBR
  Scenario Outline: llamada al metodo POST getPrivacyPoliciesContentMBR
    Given se prepara el login para los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getPrivacyPoliciesContentMBR con "<transactionId>" "<contentName>" 
    Then se valida que el response code sea el esperado

    Examples: 
      | user		| pass	 | deviceId | transactionId												 | contentName 				 | 
      |F27308585|prueba01|					| 8a33ff49-64adce33-0164-add58e7b-0032 | politica_privacidad |