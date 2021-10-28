Feature: Servicio - getSecondFactorBLR

  @getSecondFactorBLR
  Scenario Outline: Llamada al metodo POST getSecondFactorBLR
    Given Llamada al servicio getSecondFactorBLR
    When Envio "<channel>" "<password>" "<serviceName>" "<transactionId>" "<userId>" "<docNumber>" "<docCode>" <generatorIndicator>
    Then Verifico el status code

    Examples: 
      | channel  | password | serviceName 									| transactionId 											 | userId | docNumber | docCode | generatorIndicator |
      | mbr 		 | xxx		  | aamr_consultar_segundo_factor | 59dfc449-2358-4cf2-a90c-b8a4d7ff34ca | mbrusr | 12345678  | 04 			| true	 						 |
