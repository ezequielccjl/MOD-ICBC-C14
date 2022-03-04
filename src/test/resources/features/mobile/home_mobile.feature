@HomeMobile
Feature: Rediseño de Home

  @HomeMobile-SaludoAlUsuario
  Scenario Outline: Saludo al usuario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Reviso que aparezca el saludo al usuario
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |

	@HomeMobile-OcultarSaldos
  Scenario Outline: Ocultar Saldos
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiono en ocultar saldos
    Then Valido que el saldo este oculto
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |