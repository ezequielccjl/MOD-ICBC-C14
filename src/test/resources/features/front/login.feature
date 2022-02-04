@Login
Feature: Login - ICBC Modernizacion
	
	@Login-Satisfactorio-CaracteresEspeciales-OlvidandoClave
	Scenario Outline: El usuario realiza logueo
    Given El usuario se encuentra en la App
   	When Ingreso usuario "<caracEsp>" y verifico que no se pueda continuar
   	And Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifica "<respuestaEsperada>" de su logueo
    
    Examples: 
      | user     | pass  				| respuestaEsperada |caracEsp|
      |U10567381 | prueba01			| loginCorrecto			| !!$$%% |
	    |U10567381 | error123			|	loginIncorrecto   | !!$$%% |
	    
	@Login-FallidoConClaveRecienGestionada
	Scenario Outline: El usuario realiza logueo
    Given El usuario se encuentra en la App
   	When Ingreso usuario "<caracEsp>" y verifico que no se pueda continuar
   	And Me logueo con el usuario "<user>" y la pass "<pass>"
    Then Verifica "<respuestaEsperada>" de su logueo
    
    Examples:      
      | user     | pass  				| respuestaEsperada |caracEsp|
	    |U10567381 | fallidoo			|	loginIncorrecto   | !!$$%% |
	
	@Login-Bloqueo
  Scenario Outline: El usuario realiza logueo y bloqueo
    Given El usuario se encuentra en la App
    When Ingresa su "<user>" y "<contrasenia>" "<loop>"
    Then Verifica "<respuestaEsperada>"
    And Blanquea usuario con "<tipoDocumento>" "<numeroDocumento>" "<genero>" "<usuario>" "<clave>" "<canalOrigen>" "<requestId>" 
    
    Examples: 
      | user   | contrasenia  | respuestaEsperada 						   | loop |tipoDocumento|numeroDocumento|genero|usuario	 |clave	  |canalOrigen|requestId	|
      #| U14225231 | prueba01		 | LoginOk					 							 |	1		|						  |               |      |         |        |           |           |
      | U14225231 | asdasd		   |El usuario se encuentra bloqueado|	3	  | 04					|14225231				|M		 |U14225231|prueba01|sbs				|56646246561|

	
