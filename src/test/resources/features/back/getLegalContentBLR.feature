Feature: Servicio - llamada al metodo POST getLegalContentBLR

  @getLegalContentBLR
  Scenario Outline: llamada al metodo POST getLegalContentBLR
    Given se preparan las especificaciones para el request
    When llamo al metodo getLegalContentBLR con "<channel>" "<transactionId>"
    Then validamos el code de la response

    Examples: 
      | channel  | transactionId												|
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |