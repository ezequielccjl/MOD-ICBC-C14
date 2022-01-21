@backEnd
Feature: Servicio - generateSecondFactorBLR

  @generateSecondFactorBLR
  Scenario Outline: Llamada al metodo POST generateSecondFactorBLR
    Given Llamada al servicio generateSecondFactorBLR
    When Envio "<channel>" "<transactionId>" "<documentNumber>" "<docTypeCode>" "<providerName>" "<medioCode>" "<claveCode>" "<resultCode>" "<schema>" al servicio
    Then Verificacion del status code

    Examples: 
      | channel  | transactionId											 | documentNumber	| docTypeCode  | providerName | medioCode | claveCode  | resultCode | schema 																					 |
      | mbr 		 | 59dfc449-2358-4cf2-a90c-b8a4d7ff34ca| 12345678 			| 04					 | ProviderName | TKS 		  | zz98			 | ok 				| schemas/schemaGenerateSecondFactorBLR_ok.json 	 |
      | mbr 		 | 59dfc449-2358-4cf2-a90c-b8a4d7ff34ca| 12345678 			| 04					 | ProviderName | 		 		  | zz98			 | ok 				| schemas/schemaGenerateSecondFactorBLR_error.json |
