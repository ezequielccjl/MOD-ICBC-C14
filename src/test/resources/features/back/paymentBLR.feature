Feature: Servicio - llamada al metodo paymentBLR

  @paymentBLR
  Scenario Outline: Llamada al metodo POST paymentBLR
    Given Se preparan las especificaciones para el request
    When Llamo al metodo paymentBLR con los datos "<channel>" "<transactionId>" "<confirmPaymentIndicator>" "<currencyCode>" "<cardNumber>" "<accountProductNumber>" "<accountProductCurrency>" "<cardTypeIndicator>"
    Then Verificamos que el response code sea correcto

    Examples: 
      | channel  | transactionId 											  | confirmPaymentIndicator | currencyCode | cardNumber 			| accountProductNumber | accountProductCurrency | cardTypeIndicator |
      | mbr 		 | 59dfc449-2358-4cf2-a90c-b8a4d7ff34ca | false									  | ARP				   | 4423120000952942 | 0				 						 | ARP                    | visa 							|
