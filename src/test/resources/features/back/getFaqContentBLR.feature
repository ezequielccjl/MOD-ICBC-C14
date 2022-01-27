@backEnd
Feature: Servicio - llamada al metodo POST getFaqContentBLR

  @getFaqContentBLR
  Scenario Outline: llamada al metodo POST getFaqContentBLR
    Given se preparan las especificaciones del request
    When llamo al metodo getFaqContent con "<channel>" "<transactionId>" "<resultCode>"
    Then se valida la response

    Examples: 
      | channel  | transactionId												| resultCode |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 | ok				 |
      | 				 | 9f73364f-28e4-4729-84b8-47363713a7c4 | EXC01185	 |
