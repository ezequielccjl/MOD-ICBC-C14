Feature: Servicio - llamada al metodo POST getPrivacyPoliciesContentBLR

  @getPrivacyPoliciesContentBLR
  Scenario Outline: llamada al metodo POST getPrivacyPoliciesContentBLR
    Given se preparan las especificaciones para llamar al metodo
    When llamo al metodo getPrivacyPoliciesContentBLR con "<channel>" "<password>" "<serviceName>" "<transactionId>" "<userId>" "<contentName>" 
    Then se valida que el response sea el esperado

    Examples: 
      | user		| pass	 | deviceId | channel | password | serviceName 			| transactionId												 | userId | contentName 				| 
      |F27308585|prueba01|					| BLR			| mbr2014	 | gateway_generico | 9af0313d-8ae5-4455-bde8-cfb7acf08c5b | mbrusr | politica_privacidad |
