Feature: Consultar Alias

  Scenario Outline: Llamada al metodo POST que consultar los datos del cliente
    When envio el json con los datos del cliente "<alias>"
    Then verifica que trae al cliente correcto

    Examples: 
      | alias     |
      | gabo123   |
      | pepinillo |
      | XLR2001   |

  Scenario: Llamada al metodo POST para validar el schema
    When envio el json
    Then valido el schema
