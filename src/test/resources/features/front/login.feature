@login
Feature: Login - ICBC Modernizacion

  Scenario Outline: El usuario realiza logueo
    Given El usuario se encuentra en la App
    When Ingresa su "<user>" y "<contrasenia>" "<loop>"
    Then Verifica "<respuestaEsperada>"
    And Blanquea usuario con "<tipoDocumento>" "<numeroDocumento>" "<genero>" "<usuario>" "<clave>" "<canalOrigen>" "<requestId>" 
    
    Examples: 
      | user   | contrasenia  | respuestaEsperada 						   | loop |tipoDocumento|numeroDocumento|genero|usuario	 |clave	  |canalOrigen|requestId	|
      #| U14225231 | prueba01		 | LoginOk					 							 |	1		|						  |               |      |         |        |           |           |
      | U14225231 | asdasd		   |El usuario se encuentra bloqueado|	3	  | 04					|14225231				|M		 |U14225231|prueba01|sbs				|56646246561|

