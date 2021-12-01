Feature: Servicio - llamada al metodo POST getSegCanalesContentBLR

  @getSegCanalesContentBLR
  Scenario Outline: llamada al metodo POST getSegCanalesContentBLR
    Given preparamos las especificaciones
    When llamamos al metodo getSegCanalesContent con "<transactionId>" "<channel>" "<userId>" "<password>"
    Then validamos el code

    Examples: 
      | transactionId	 | channel | userId | password |
      | jacome.rodrigo | mbr		 | mbrusr | mbr2014  |
