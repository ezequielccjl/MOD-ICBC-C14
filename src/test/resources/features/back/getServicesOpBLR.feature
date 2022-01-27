@backEnd
Feature: Servicio - llamada al metodo POST getServicesOpBLR

  @getServicesOpBLR
  Scenario Outline: llamada al metodo POST getServicesOpBLR
    Given se preparan las especificaciones del request de getServicesOpBLR
    When llamo al metodo getServicesOpBLR con "<channel>" "<transactionId>" "<operationServiceId>" "<resultCode>"
    Then se valida la response de getServicesOpBLR

    Examples: 
      | channel  | transactionId	| operationServiceId | resultCode |
      | mbr			 | transaction-id | 3									 | ok					|
      | mbr			 | transaction-id | 									 | fail				|

