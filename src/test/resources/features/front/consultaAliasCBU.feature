@consultaAliasCBU
Feature: Realizo consulta al Alias y CBU
  
  Scenario Outline: Consulta Alias CBU
    Given El usuario hace el login con "<user>" "<password>"
    When Ingresa a cbu alias qr
    Then Verifica "<alias>" "<cbu>"

    Examples:
		| user     | password | alias  | cbu 									 |
		|U10567381 | prueba01 | 			 |01505177/01000000004119|
