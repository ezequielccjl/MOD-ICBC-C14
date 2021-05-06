Feature: Consultar Alias

  @Post
  Scenario: Llamada al metodo POST que consultar los datos del cliente
    When envio el json con los datos del cliente
    Then verifica que trae al cliente correcto
