@backEnd
Feature: Servicio - llamada al metodo POST ownTransferBLR

  @ownTransferBLR
  Scenario Outline: llamada al metodo POST ownTransferBLR
    Given se preparan las especificaciones necesarias para el request
    When llamamos al metodo ownTransferBLR con "<transactionId>" "<channel>" "<number>" "<docCode>" "<docNumber>" "<accountCode>" "<code>" "<description>" "<destinationNumber>" "<destinationCode>" "<destionationDescription" "<currencyDescription>" "<amount>" "<resultCode>"
    Then validamos la response que nos devuelta

    Examples: 
      | transactionId  | channel | number						 | docCode | docNumber | accountCode | code | description | destinationNumber | destinationCode | destinationDescription | currencyDescription | amount | resultCode |
      | xxxxxxxxx			 | mbr		 | 001508250111104488| 04 	   | 24264846	 | 11					 | 01		| CA $				| 001508250210349357| 02							| CC $									 | $									 | 0.01   | ok 				 |
      | xxxxxxxxx			 | mbr		 | 001508250111104488| 04 	   | 24264846	 | 11					 |  		| CA $				| 001508250210349357| 02							| CC $									 | $									 | 0.01   | fallo			 |
