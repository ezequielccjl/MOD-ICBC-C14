Feature: Realizo consulta al Alias y CBU
  @consultaAliasCBU
  Scenario Outline: Consulta Alias CBU
    Given El usuario hace el login con "<user>" "<password>"
    When Ingresa a cbu alias qr
    Then Verifica su alias

    Examples:
		| user    | password |
		|corona01 | Prueba01 |
