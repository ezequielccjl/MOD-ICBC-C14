Feature: Servicio - llamada al metodo POST getContactContentBLR

  @getContactContentBLR
  Scenario Outline: llamada al metodo POST getContactContentBLR
    Given preparamos las especificaciones del request
    When llamamos al metodo getFaqContent con "<channel>" "<transactionId>" "<resultCode>"
    Then validamos la response

    Examples: 
      | channel  | transactionId												| resultCode |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 | ok 				 |
      | 				 | 9f73364f-28e4-4729-84b8-47363713a7c4 | fail			 |
