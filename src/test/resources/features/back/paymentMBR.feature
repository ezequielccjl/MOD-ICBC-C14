@backEnd
Feature: Servicio - paymentMBR

  @paymentMBR
  Scenario Outline: Llamada al metodo POST paymentMBR
    Given Se loguea con "<user>" "<pass>" "<deviceId>" correctamente para paymentMBR
    When Se realiza la consulta al metodo getClientDataMBR 
    And Se realiza la consulta al metodo listProductsMBR con "<code1>" "<code2>" "<code3>" "<code4>" "<code5>" "<code6>" "<code7>" "<code8>"
    And Se realiza la consulta al metodo paymentMBR "<transactionId>" "<accountProductIndex>" "<cardIndex>" "<confirmPaymentIndicator>" "<currencyCode>" "<amount>"
    Then Se verifica la response code devuelto de paymentMBR

    Examples: 
      | user      | pass     | deviceId| code1 | code2  | code3 | code4 | code5 | code6 | code7 | code8 |transactionId												| accountProductIndex | cardIndex | confirmPaymentIndicator | currencyCode | amount | 
      | U11424824 | prueba01 |         | 01    | 02			| 11		| 12		| 37		| 38		| 61		| 62		|ee8862b2-cc0b-4be8-975c-6169dc6c5361 |0										| 0					| false										| USB					 | 20			|

      


