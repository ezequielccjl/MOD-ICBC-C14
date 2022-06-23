@LoginNuevo-Mobile
Feature: Login con nuevo usuario y clave (Gesti�n de claves)

	@LoginNuevo-Mobile-01
  Scenario: 01_Nuevo Login - Visualizacion pantalla de Login
    Given El usuario se encuentra en la app ICBC
    Then Verifico campos de pantalla login
    
	@LoginNuevo-Mobile-02
  Scenario: 02_Nuevo Login - Ingresar con Biometria
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Ingresar por biometria
    Then Reviso correcta visualizacion de Ingresar por biometria
    
  @LoginNuevo-Mobile-03
  Scenario: 03_Nuevo Login - Boton Accesos utiles
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Reviso correcta visualizacion de Accesos utiles
    
  @LoginNuevo-Mobile-04
  Scenario: 004_Nuevo Login - Boton Accesos �tiles - Bot�n Turnos
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Clickeo Turnos y reviso correcta visualizacion de pantalla
    
  @LoginNuevo-Mobile-05
  Scenario: 004_Nuevo Login - Boton Accesos �tiles - Bot�n Hacete cliente
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Clickeo Hacete cliente y reviso correcta visualizacion de pantalla
    
  @LoginNuevo-Mobile-06
  Scenario: 004_Nuevo Login - Boton Accesos �tiles - Bot�n ICBC Mall
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Clickeo ICBC Mall y reviso correcta visualizacion de pantalla
    
  @LoginNuevo-Mobile-07
  Scenario: 004_Nuevo Login - Boton Accesos �tiles - Bot�n Beneficios
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Clickeo Beneficios y reviso correcta visualizacion de pantalla
    
  @LoginNuevo-Mobile-07-Extra
  Scenario: 004_Nuevo Login - Boton Accesos �tiles - Bot�n Informacion
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Accesos utiles
    Then Clickeo Informacion y reviso correcta visualizacion de pantalla

  @LoginNuevo-Mobile-08
  Scenario: 08_Nuevo Login - Bot�n Transferir
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Transferir de Accesos utiles
    Then Reviso correcta visualizacion de pantalla Transferir
    
  @LoginNuevo-Mobile-09
  Scenario Outline: 09_Nuevo Login - Login exitoso
  	Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verificar el correcto acceso a la Home de Mobile
    Examples:
		| user    | pass	 |
		|U10567381|prueba01|
		
	#No detecta cartel - Usuario y/o contrase�a incorrecta
	@LoginNuevo-Mobile-10
	Scenario Outline: 10_Nuevo Login - Login err�neo - Usuario incorrecto
  	Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verificar que se despliegue el mensaje de error
    Examples:
		| user    | pass	 |
		|USUARIO99|prueba01|
		
  #No detecta cartel - Usuario y/o contrase�a incorrecta
	@LoginNuevo-Mobile-11
	Scenario Outline: 11_Nuevo Login - Login err�neo - Contrase�a incorrecta
  	Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verificar que se despliegue el mensaje de error
    Examples:
		| user    | pass	 |
		|U10567381|error123|
	
	#Averiguar TAP - No aparece mensaje
	@LoginNuevo-Mobile-12
	Scenario Outline: 12_Nuevo Login - Usuario con menos de 8 caracteres
  	Given El usuario se encuentra en la app ICBC
    Then Me logueo con el usuario "<user>" y verifico mensaje de error 
    Examples:
		| user    | pass	 |
		|asdasd   |prueba01|
	
	#Averiguar TAP - No aparece mensaje
	@LoginNuevo-Mobile-13
	Scenario Outline: 013_Nuevo Login - Intento de ingreso sin clave
		Given El usuario se encuentra en la app ICBC
    When Ingreso usuario "<user>"
    Then Verifico falta de password
    Examples:
		| user    | pass	 |
		|U10567381|        |
		
	@LoginNuevo-Mobile-14
	Scenario: 14_Nuevo Login - Link Tenes problemas para ingresar
    Given El usuario se encuentra en la app ICBC
    When Clickeo en Tenes problemas para ingresar
    Then Reviso correcta visualizacion de pantalla Problemas para ingresar