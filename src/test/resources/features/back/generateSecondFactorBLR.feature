Feature: Servicio - generateSecondFactorBLR

  @generateSecondFactorBLR
  Scenario Outline: Llamada al metodo POST generateSecondFactorBLR
    Given Llamada al servicio generateSecondFactorBLR
    When Envio "<channel>" "<transactionId>" "<documentNumber>" "<docTypeCode>" "<providerName>" "<medioCode>" "<claveCode>" al servicio
    Then Verificacion del status code

    Examples: 
      | channel  | transactionId											 | documentNumber	| docTypeCode  | providerName | medioCode | claveCode  |
      | mbr 		 | 59dfc449-2358-4cf2-a90c-b8a4d7ff34ca| 12345678 			| 04					 | ProviderName | TKS 		  | zz98			 |
