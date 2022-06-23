@LoginMobile
Feature: Login Mobile ICBC AA
  
  @Login-002-IngresoFallido
  Scenario Outline: El usuario se loguea incorrectamente
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    Then Verifica login incorrecto

    Examples: 
      | user  		| password |
      | U10567381 | prueba99 |
      
  @Login-003-OlvideMiClave
  Scenario Outline: El usuario se loguea en ICBC
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    And Ingresa en Olvide mi usuario o clave
    And Presiona Generacion Online
    And Completa "<dni>" "<numTramite>"
    Then Verifica que se haya logueado correctamente

    Examples: 
      | user  		| password |
      | U10567381 | prueba01 |
      
  @Login-008-CaracteresEspeciales
	Scenario Outline: El usuario realiza logueo
    Given El usuario se encuentra en la app ICBC
   	When Ingreso usuario "<caracEsp>" y verifico que no se pueda continuar
   	And Me logueo con el usuario "<user>" y la pass "<password>"
    Then Verifica que se haya logueado correctamente
    
    Examples: 
      | user     | password  	  | respuestaEsperada |caracEsp|
      |U10567381 | prueba01			| loginCorrecto			| !!$$%% |
  
  @Login-009-Correcto
  Scenario Outline: El usuario se loguea en ICBC
    Given El usuario se encuentra en la app ICBC
    When Completa "<user>" "<password>" presiona ingresar
    Then Verifica que se haya logueado correctamente

    Examples: 
      | user  		| password |
      | U10567381 | prueba01 | 
  
  @Login-TA-Bloqueo
  Scenario Outline: El usuario realiza logueo y bloqueo
    Given El usuario se encuentra en la App
    When Ingresa su "<user>" y "<pass>" "<loop>"
    Then Verifica "<respuestaEsperada>"
    And Blanquea usuario con "<tipoDocumento>" "<numeroDocumento>" "<genero>" "<usuario>" "<clave>" "<canalOrigen>" "<requestId>" 
    
    Examples: 
      | user      | pass  			 | respuestaEsperada 						   | loop |tipoDocumento|numeroDocumento|genero|usuario	 |clave	  |canalOrigen|requestId	|
      #| U14225231 | prueba01		 | LoginOk					 							 |	1		|						  |               |      |         |        |           |           |
      | U14225231 | asdasd		   |El usuario se encuentra bloqueado|	3	  | 04					|14225231				|M		 |U14225231|prueba01|sbs				|56646246561|
      
  @Login-TA-PrimeraVez
  Scenario Outline: El usuario se loguea en ICBC
    Given El usuario se encuentra en la app ICBC
    When Completa "<user>" "<password>" presiona ingresar
    Then Verifica que se haya logueado correctamente

    Examples: 
      | user  		| password |
      | U10567381 | prueba01 | 
  

