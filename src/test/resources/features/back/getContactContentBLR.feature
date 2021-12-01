Feature: Servicio - llamada al metodo POST getContactContentBLR

  @getContactContentBLR
  Scenario Outline: llamada al metodo POST getContactContentBLR
    Given preparamos las especificaciones del request
    When llamamos al metodo getFaqContent con "<channel>" "<transactionId>"
    Then validamos la response

    Examples: 
      | channel  | transactionId												|
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |
