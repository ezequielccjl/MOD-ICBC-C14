@NuevaHome
Feature: Rediseño de Home

  @NuevaHome-SaludoAlUsuario
  Scenario Outline: Saludo al usuario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Reviso que aparezca el saludo al usuario
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |

	@NuevaHome-OcultarSaldos
  Scenario Outline: Ocultar Saldos
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiono en ocultar saldos
    Then Valido que el saldo este oculto
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-NuevaBotonera
  Scenario Outline: Nueva Botonera
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que se encuentre nueva botonera
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonCBUAlias
  Scenario Outline: Boton CBU Alias
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico funcionamiento de boton CBU Alias
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonNuevoProducto
  Scenario Outline: Boton Nuevo Producto en pantalla
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que boton Nuevo Producto se encuentre en pantalla
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonNuevoProductoFuncional
  Scenario Outline: Boton Nuevo Producto en pantalla
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifico que boton Nuevo Producto este funcional
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
    
  @NuevaHome-BarraInferiorDisponible
  Scenario Outline: Verificar que se encuentre la barra inferior
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que aparezca barra inferior
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonInversiones
  Scenario Outline: Verificar funcionamiento de Botón Inversiones
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione de boton Inversiones
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonPagos
  Scenario Outline: Verificar funcionamiento de Botón Pagos
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione de boton Pagos
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  #Escenario con usuario sin OnBoarding
  @NuevaHome-BotonMODO
  Scenario Outline: Verificar funcionamiento de Botón MODO
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione de boton MODO
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-MenuHamburguesa
  Scenario Outline: Verificar funcionamiento de Menu hamburguesa
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que funcione menu hamburguesa
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
  @NuevaHome-BotonExtraccionSinTarjeta
  Scenario Outline: Verificar funcionamiento de Boton Extraccion sin Tarjeta
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Valido que me redirija a pantalla Extraccion sin tarjeta
    And Cierro sesion
    Examples:
    | user			| pass  	 |
    | U10567381 | prueba01 |
    
	
