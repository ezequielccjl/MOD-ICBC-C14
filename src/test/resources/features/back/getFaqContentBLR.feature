Feature: Servicio - llamada al metodo POST getFaqContentBLR

  @getFaqContentBLR
  Scenario Outline: llamada al metodo POST getFaqContentBLR
    Given se preparan las especificaciones del request
    When llamo al metodo getFaqContent con "<channel>" "<transactionId>"
    Then se valida la response

    Examples: 
      | channel  | transactionId												|
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |
