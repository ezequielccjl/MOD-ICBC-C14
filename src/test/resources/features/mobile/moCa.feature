@MoCa
Feature: El usuario testea los distintos plugins de MoCa

#CHEQUEADO
@MoCa-Splash
Scenario: Abrir aplicacion y visualizar Splash
    Given Que el usuario abre la aplicacion
    When Se encuentra en la pantalla de carga
    Then Verifica que se visualice el Splash

@MoCa-Spinner
Scenario: Abrir aplicacion y visualizar Spinner
    Given Que el usuario ingresa a la pantalla de Login
    When Se encuentra en la pantalla de carga
    Then Verifica que se visualice el Spinner
    
@MoCa-BackNativo
Scenario: Cerrar aplicacion con Back nativo
    Given Que el usuario abre la aplicacion
    When Clickea en el Back nativo
    Then Verifica que se cierre la aplicacion
#CHEQUEADO
@MoCa-Mall
Scenario: Ir a pantalla Mall
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea en Mall
    Then Verifica que se visualice la pantalla Mall
#CHEQUEADO
@MoCa-Beneficios
Scenario: Ir a pantalla Beneficios
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea en Beneficios
    Then Verifica que se visualice la pantalla Beneficios
#CHEQUEADO
@MoCa-HaceteCliente
Scenario: Ir a pantalla Hacete Cliente
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea en Hacete Cliente
    Then Verifica que se visualice la pantalla Quiero ser cliente
    
@MoCa-Contacto
Scenario: Ir a pantalla Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Contacto
    Then Verifica que se visualice la pantalla Contacto
    
@MoCa-Contacto-Telefono
Scenario: Realizar llamada desde Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Contacto
    And Clickea en un telefono
    Then Verifica que se marque el numero
#CHEQUEADO
@MoCa-Ayuda
Scenario: Ir a pantalla Ayuda
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    Then Verifica que se visualice la pantalla Ayuda
#CHEQUEADO    
@MoCa-Ayuda-PreguntasFrecuentes
Scenario: Ir a pantalla Ayuda y Preguntas frecuentes
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Preguntas frecuentes
    Then Verifica que se visualice la pantalla Preguntas frecuentes
#CHEQUEADO      
@MoCa-Ayuda-TerminosYCondiciones
Scenario: Ir a pantalla Ayuda y Terminos y condiciones
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Terminos y condiciones desde Ayuda
    Then Verifica que se visualice la pantalla Terminos y condiciones
    
@MoCa-Ayuda-PoliticasDePrivacidad
Scenario: Ir a pantalla Ayuda y Politicas de privacidad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Politicas de privacidad desde Ayuda
    Then Verifica que se visualice la pantalla Politicas de privacidad
    
@MoCa-Ayuda-Seguridad
Scenario: Ir a pantalla Ayuda y Seguridad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Seguridad
    Then Verifica que se visualice la pantalla Seguridad
    
@MoCa-Ayuda-Contacto
Scenario: Ir a pantalla Ayuda y Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Contacto
    Then Verifica que se visualice la pantalla Contacto
      
@MoCa-TerminosYCondiciones
Scenario: Ir a pantalla Terminos y condiciones
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Terminos y condiciones
    Then Verifica que se visualice la pantalla Terminos y condiciones
      
@MoCa-PoliticasDePrivacidad
Scenario: Ir a pantalla Politicas de privacidad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Politicas de privacidad
    Then Verifica que se visualice la pantalla Politicas de privacidad

@MoCa-Mas-Contacto
Scenario Outline: Ir a pantalla Mas y Contacto
    Given Que el usuario se loguea con "<user>" "<pass>"
    When Clickea en Mas
    And Clickea en Contacto desde Mas
    Then Verifica que se visualice la pantalla Contacto
    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-TarjetaDeCredito-DescargarResumen
Scenario Outline: Descargar resumen de Tarjeta de credito
    Given Que el usuario se loguea con "<user>" "<pass>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Resumen
    And Descarga el Resumen de Tarjeta de credito
    Then Verifica que se descargue el Resumen de Tarjeta de credito
    
    Examples:
		| user      | pass     | numeroDeTarjeta |
		| T10136908 | prueba01 | ...4760         |
		
@MoCa-FondosDeInversion-DescargarReglamentoDeGestion
Scenario Outline: Descargar Reglamento de gestion de Fondo de inversion
    Given Que el usuario se loguea con "<user>" "<pass>"
    When Clickea en Inversiones
    And Clickea en Fondos de inversion
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue el Reglamento de gestion
    
    Examples:
		| user      | pass     | pdf                   |
		| T17319044 | prueba01 | REGLAMENTO DE GESTIÓN |
		
@MoCa-FondosDeInversion-DescargarFactSheet
Scenario Outline: Descargar FactSheet de Fondo de inversion
    Given Que el usuario se loguea con "<user>" "<pass>"
    When Clickea en Inversiones
    And Clickea en Fondos de inversion
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue la FactSheet
    
    Examples:
		| user      | pass     | pdf       |
		| T17319044 | prueba01 | FACTSHEET |
		
@MoCa-FondosDeInversion-DescargarCalificacion
Scenario Outline: Descargar Calificacion de Fondo de inversion
    Given Que el usuario se loguea con "<user>" "<pass>"
    When Clickea en Inversiones
    And Clickea en Fondos de inversion
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue la Calificacion
    
    Examples:
		| user      | pass     | pdf          |
		| T17319044 | prueba01 | CALIFICACIÓN |
		
@MoCa-Mas-Recomendar-Facebook
Scenario Outline: Recomendar la App por Facebook
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Recomendar
		And Clickea en Facebook
		Then Verifica que se recomiende por Facebook
    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-Recomendar-Twitter
Scenario Outline: Recomendar la App por Twitter
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Recomendar
		And Clickea en Twitter
		Then Verifica que se recomiende por Twitter
		    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-Recomendar-Gmail
Scenario Outline: Recomendar la App por Gmail
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Recomendar
		And Clickea en Gmail
		Then Verifica que se recomiende por Gmail
				    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-Recomendar-Outlook
Scenario Outline: Recomendar la App por Outlook
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Recomendar
		And Clickea en Outlook
		Then Verifica que se recomiende por Outlook
				    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-Recomendar-SMS
Scenario Outline: Recomendar la App por SMS
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Recomendar
		And Clickea en SMS
		Then Verifica que se recomiende por SMS
				    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-GestionDeProductos-Cuentas-CajaDeAhorroPesos
Scenario Outline: Descargar PDF de caja de ahorro pesos
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Gestion de productos
		And Clickea en Cuentas
		And Clickea en Caja de ahorro pesos
		And Descarga el PDF de la caja de ahorro
		Then Verifica que se descargue el PDF de caja de ahorro
				    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-Mas-GestionDeProductos-Cuentas-CajaDeAhorroDolares
Scenario Outline: Descargar PDF de caja de ahorro dolares
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Mas
		And Clickea en Gestion de productos
		And Clickea en Cuentas
		And Clickea en Caja de ahorro dolares
		And Descarga el PDF de la caja de ahorro
		Then Verifica que se descargue el PDF de caja de ahorro
				    
    Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-TarjetaDeCredito-Denunciar-MasterCard
Scenario Outline: Denunciar tarjeta MasterCard
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en tres puntos de tarjeta MasterCard
		And Clickea en Denunciar
		Then Verifica que se visualice la pantalla de denuncias MasterCard
		
		Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-TarjetaDeCredito-Denunciar-Visa
Scenario Outline: Denunciar tarjeta Visa
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en tres puntos de tarjeta Visa
		And Clickea en Denunciar
		Then Verifica que se visualice la pantalla de denuncias Visa
		
		Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-LogIn-EnviarInstruccionesClave
Scenario: Enviar instrucciones cajero
		Given Que el usuario ingresa a la pantalla de Login
		When Clickea en No puedo ingresar
		And Clickea en Generacion en cajeros Banelco
		And Clickea en Enviar instrucciones
		Then Verifica que se visualice la pantalla de enviar instrucciones
		
@MoCa-CajaDeAhorroPesos-CompartirTransferencia
Scenario Outline: Compartir transferencia de caja de ahorro pesos
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Caja de ahorro pesos
		And Clickea en una transferencia
		And Clickea en Compartir
		Then Verifica que se visualice la pantalla de compartir transferencia
		
		Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-CajaDeAhorroPesos-CompartirCBU-ALIAS-QR
Scenario Outline: Compartir CBU-ALIAS-QR
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en CBU-ALIAS-QR
		And Clickea en Compartir CBU-ALIAS-QR
		Then Verifica que se visualice la pantalla de compartir CBU-ALIAS-QR
		
		Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		
@MoCa-CajaDeAhorroPesos-EnviarMovimiento
Scenario Outline: Enviar movimiento de caja de ahorro pesos
		Given Que el usuario se loguea con "<user>" "<pass>"
		When Clickea en Caja de ahorro pesos
		And Clickea en un movimiento
		And Clickea en Enviar
		Then Verifica que se visualice la pantalla de enviar movimiento
		
		Examples:
		| user      | pass     |
		| T17319044 | prueba01 |
		