Feature: Consultar Alias
	
  Scenario: Llamada al metodo POST que consultar los datos del cliente
    When envio el json con los datos del cliente
    Then verifica que trae al cliente correcto

  Scenario: Llamada al metodo POST para validar el schema
    When envio el json
    Then valido el schema
