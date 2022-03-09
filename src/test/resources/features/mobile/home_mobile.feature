@HomeMobile
Feature: Rediseño de Home

  @HomeMobile-SaludoAlUsuario
  Scenario Outline: Saludo al usuario
    Given El usuario se encuentra en la app ICBC
    When Completa "<user>" "<password>" presiona ingresar
    Then Reviso que aparezca el saludo al usuario
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |

	@HomeMobile-OcultarSaldos
  Scenario Outline: Ocultar Saldos
    Given El usuario se encuentra en la app ICBC
    When Completa "<user>" "<password>" presiona ingresar
    And Presiono en ocultar saldos
    Then Valido que el saldo este oculto
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |