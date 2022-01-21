@backEnd
Feature: Servicio - llamada al metodo POST newDollarTransferBLR

	@newDollarTransferBLR
  Scenario Outline: llamada al metodo POST newDollarTransferBLR
  	Given preparamos las especificaciones necesarias del metodo newDollarTransferBLR
    When llamamos al metodo newDollarTransferBLR con "<channel>" "<transactionId>" "<cuentao>" "<cuentad>" "<moneda>" "<monto>" "<resultCode>" "<schema>"
    Then validamos el code que nos trajo la respuesta del metodo newDollarTransferBLR

    Examples:
    	| channel | transactionId | cuentao 						 | cuentad 							| moneda | monto | resultCode | schema 																		 		|
    	| mbr     | 							| 00150501000134882388 | 00150501001113372445 | USB		 | 1		 | ok					| schemas/schemaNewDollarTransferBLR_ok.json 		|
    	| mbr     | 							| 										 | 00150501001113372445 | USB		 | 1		 | error 			| schemas/schemaNewDollarTransferBLR_error.json |