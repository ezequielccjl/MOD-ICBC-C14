Feature: Servicio - llamada al metodo POST getNewClientContentBLR

  @getNewClientContentBLR
  Scenario Outline: llamada al metodo POST getNewClientContentBLR
    Given preparamos las especificaciones para el request
    When llamamos al metodo getFaqContent con "<transactionId>" "<channel>" "<userId>" "<password>"
    Then validamos el response

    Examples: 
      | transactionId								 | channel | userId | password |
      | sergio-BLR-new-clien-content | mbr		 | mbrusr | mbr2014  |
