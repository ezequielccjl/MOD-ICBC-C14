@HomeMobile
Feature: Rediseño de Home

  @HomeMobile-SaludoAlUsuario
  Scenario Outline: Saludo al usuario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Reviso que aparezca el saludo al usuario
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |

	@HomeMobile-OcultarSaldos
  Scenario Outline: Ocultar Saldos
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiono en ocultar saldos
    Then Valido que el saldo este oculto
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-NuevaBotonera
  Scenario Outline: Nueva Botonera
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que se encuentre nueva botonera
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BotonCBUAlias
  Scenario Outline: Boton CBU Alias
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico funcionamiento de boton CBU Alias
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BotonNuevoProducto
  Scenario Outline: Boton Nuevo Producto en pantalla
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que boton Nuevo Producto se encuentre en pantalla
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BotonNuevoProductoFuncional
  Scenario Outline: Boton Nuevo Producto en pantalla funcioal
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que boton Nuevo Producto este funcional
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BarraInferiorDisponible
  Scenario Outline: Verificar que se encuentre la barra inferior
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que aparezca barra inferior
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BotonInversiones
  Scenario Outline: Verificar funcionamiento de Botón Inversiones
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione de boton Inversiones
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-BotonPagos
  Scenario Outline: Verificar funcionamiento de Botón Pagos
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione de boton Pagos
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @HomeMobile-MenuHamburguesa
  Scenario Outline: Verificar funcionamiento de Menu hamburguesa
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione menu hamburguesa
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
    