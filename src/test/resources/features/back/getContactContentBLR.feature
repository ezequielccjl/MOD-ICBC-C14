@backEnd
Feature: Servicio - llamada al metodo POST getContactContentBLR

  @getContactContentBLR
  Scenario Outline: llamada al metodo POST getContactContentBLR
    Given preparamos las especificaciones del request
    When llamamos al metodo getContactContentBLR con "<channel>" "<transactionId>" "<resultCode>" "<schema>"
    Then validamos la response

    Examples: 
      | channel  | transactionId												| resultCode | schema 																			 |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 | ok 				 | schemas/schemaGetContactContentBLR_ok.json 	 |
      | 				 | 9f73364f-28e4-4729-84b8-47363713a7c4 | EXC01186	 | schemas/schemaGetContactContentBLR_error.json |
