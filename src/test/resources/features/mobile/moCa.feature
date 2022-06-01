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
#CHEQUEADO    
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
@MoCa-QuieroSerCliente
  Scenario: Ir a pantalla Quiero ser cliente
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea en Hacete Cliente
    Then Verifica que se visualice la pantalla Quiero ser cliente
#CHEQUEADO
@MoCa-Contacto
Scenario: Ir a pantalla Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Contacto
    Then Verifica que se visualice la pantalla Contacto
#CHEQUEADO  
@MoCa-Contacto-Telefono
Scenario: Realizar llamada desde Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Contacto
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
#CHEQUEADO    
@MoCa-Ayuda-PoliticasDePrivacidad
Scenario: Ir a pantalla Ayuda y Politicas de privacidad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Politicas de privacidad desde Ayuda
    Then Verifica que se visualice la pantalla Politicas de privacidad
#CHEQUEADO    
@MoCa-Ayuda-Seguridad
Scenario: Ir a pantalla Ayuda y Seguridad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Seguridad
    Then Verifica que se visualice la pantalla Seguridad
#CHEQUEADO    
@MoCa-Ayuda-Contacto
Scenario: Ir a pantalla Ayuda y Contacto
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Contacto
    Then Verifica que se visualice la pantalla Contacto
#No estan en la Nueva Home      
@MoCa-TerminosYCondiciones
Scenario: Ir a pantalla Terminos y condiciones
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Terminos y condiciones
    Then Verifica que se visualice la pantalla Terminos y condiciones
#No estan en la Nueva Home      
@MoCa-PoliticasDePrivacidad
Scenario: Ir a pantalla Politicas de privacidad
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en Accesos utiles
    And Clickea boton Informacion
    And Clickea en Politicas de privacidad
    Then Verifica que se visualice la pantalla Politicas de privacidad
#CHEQUEADO
 @MoCa-Mas-Contacto
  Scenario Outline: Ir a pantalla Mas y Contacto
    Given Me logueo con el usuario "<username>" y la pass "<password>"
    When Clickea en Mas
    And Clickea en Contacto desde Mas
    Then Verifica que se visualice la pantalla Contacto

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-TarjetaDeCredito-DescargarResumen
  Scenario Outline: Descargar resumen de Tarjeta de credito
    Given Me logueo con el usuario "<username>" y la pass "<password>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Resumen
    And Descarga el Resumen de Tarjeta de credito
    Then Verifica que se descargue el Resumen de Tarjeta de credito

    Examples: 
      | username  | password | numeroDeTarjeta |
      | T10136908 | prueba01 | ...4760         |

  @MoCa-FondosDeInversion-DescargarReglamentoDeGestion
  Scenario Outline: Descargar Reglamento de gestion de Fondo de inversion
    Given Me logueo con el usuario "<username>" y la pass "<password>"
    When Clickea en Inversiones
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue el Reglamento de gestion

    Examples: 
      | username  | password | pdf                 |
      | T17319044 | prueba01 | REGLAMENTO DE GESTI |

  @MoCa-FondosDeInversion-DescargarFactSheet
  Scenario Outline: Descargar FactSheet de Fondo de inversion
    Given Me logueo con el usuario "<username>" y la pass "<password>"
    When Clickea en Inversiones
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue la Fact sheet

    Examples: 
      | username  | password | pdf       |
      | T17319044 | prueba01 | FACTSHEET |

  @MoCa-FondosDeInversion-DescargarCalificacion
  Scenario Outline: Descargar Calificacion de Fondo de inversion
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Inversiones
    And Clickea en Conocer mas fondos
    And Clickea en un fondo de inversion
    And Descarga el PDF del fondo de inversion "<pdf>"
    Then Verifica que se descargue la Calificacion

    Examples: 
      | username  | password | pdf        |
      | T17319044 | prueba01 | CALIFICACI |

  @MoCa-Mas-Recomendar-Facebook
  Scenario Outline: Recomendar la App por Facebook
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Recomendar
    And Clickea en Facebook
    Then Verifica que se recomiende por Facebook

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-Mas-Recomendar-Twitter
  Scenario Outline: Recomendar la App por Twitter
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Recomendar
    And Clickea en Twitter
    Then Verifica que se recomiende por Twitter

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-Mas-Recomendar-Email
  Scenario Outline: Recomendar la App por Email
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Recomendar
    And Clickea en Email
    Then Verifica que se recomiende por Email

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-Mas-Recomendar-SMS
  Scenario Outline: Recomendar la App por SMS
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Recomendar
    And Clickea en SMS
    Then Verifica que se recomiende por SMS

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-Mas-GestionDeProductos-Cuentas-CajaDeAhorroPesos
  Scenario Outline: Descargar PDF de caja de ahorro pesos
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Gestion de productos
    And Clickea en Cuentas
    And Clickea en Caja de ahorro pesos desde cuentas
    And Descarga el PDF de la caja de ahorro
    Then Verifica que se descargue el PDF de caja de ahorro

    Examples: 
      | username  | password |
      | T10136908 | prueba01 |

  @MoCa-Mas-GestionDeProductos-Cuentas-CajaDeAhorroDolares
  Scenario Outline: Descargar PDF de caja de ahorro dolares
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en Gestion de productos
    And Clickea en Cuentas
    And Clickea en Caja de ahorro dolares desde cuentas
    And Descarga el PDF de la caja de ahorro
    Then Verifica que se descargue el PDF de caja de ahorro

    Examples: 
      | username  | password |
      | T10136908 | prueba01 |

  @MoCa-TarjetaDeCredito-Denunciar-MasterCard
  Scenario Outline: Denunciar tarjeta MasterCard
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Denunciar
    Then Verifica que se visualice la pantalla de denuncias MasterCard

    Examples: 
      | username  | password | numeroDeTarjeta |
      | T17319044 | prueba01 | ...4205         |

  @MoCa-TarjetaDeCredito-Denunciar-Visa
  Scenario Outline: Denunciar tarjeta Visa
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Denunciar
    Then Verifica que se visualice la pantalla de denuncias Visa

    Examples: 
      | username  | password | numeroDeTarjeta |
      | T17319044 | prueba01 | ...4701         |

  @MoCa-LogIn-EnviarInstruccionesClave
  Scenario: Enviar instrucciones cajero
    Given Que el usuario ingresa a la pantalla de Login
    When Clickea en No puedo ingresar
    And Clickea en Generacion en cajeros Banelco
    And Clickea en Enviar instrucciones
    Then Verifica que se visualice la pantalla de enviar instrucciones

  @MoCa-CajaDeAhorroPesos-CompartirTransferencia
  Scenario Outline: Compartir transferencia de caja de ahorro pesos
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Caja de ahorro pesos
    And Clickea en una transferencia
    And Clickea en Compartir transferencia
    Then Verifica que se visualice la pantalla de compartir transferencia

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-CajaDeAhorroPesos-CompartirCBU-ALIAS-QR
  Scenario Outline: Compartir CBU-ALIAS-QR
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en CBU-ALIAS-QR
    And Clickea en Compartir CBU-ALIAS-QR
    Then Verifica que se visualice la pantalla de compartir CBU-ALIAS-QR

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-CajaDeAhorroPesos-EnviarMovimiento
  Scenario Outline: Enviar movimiento de caja de ahorro pesos
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Caja de ahorro pesos
    And Clickea en un movimiento
    And Clickea en Enviar movimiento
    Then Verifica que se visualice la pantalla de enviar movimiento

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-CajaDeAhorroPesos-Saldo
  Scenario Outline: Enviar saldo de caja de ahorro pesos
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en tres puntos de Caja de ahorro pesos
    And Clickea en Saldo
    And Clickea en Enviar saldo
    Then Verifica que se visualice la pantalla de enviar saldo

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-TarjetaDeCredito-Resumen-MasterCard
  Scenario Outline: Compartir resumen tarjeta de credito MasterCard
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Resumen
    And Clickea en Compartir resumen
    Then Verifica que se visualice la pantalla de compartir resumen

    Examples: 
      | username  | password | numeroDeTarjeta |
      | T17319044 | prueba01 | ...4205         |

  @MoCa-TarjetaDeCredito-Resumen-Visa
  Scenario Outline: Compartir resumen tarjeta de credito Visa
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Tarjeta de credito "<numeroDeTarjeta>"
    And Clickea en Resumen
    And Clickea en Compartir resumen
    Then Verifica que se visualice la pantalla de compartir resumen

    Examples: 
      | username  | password | numeroDeTarjeta |
      | T17319044 | prueba01 | ...4701         |

  @MoCa-Inversiones-NuevoPlazoFijo
  Scenario Outline: Compartir plazo fijo
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Inversiones
    And Clickea en Nuevo Plazo Fijo
    And Da de alta el plazo fijo
    And Clickea en Enviar plazo fijo
    Then Verifica que se visualice la pantalla de enviar plazo fijo

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |

  @MoCa-CajaDeAhorroPesos-EnviarOperacionDeUSD
  Scenario Outline: Enviar operacion de USD
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en Mas
    And Clickea en CompraVenta de USD
    And Realiza la operacion de USD
    And Clickea en Enviar operacion de USD
    Then Verifica que se visualice la pantalla de enviar operacion de USD

    Examples: 
      | username  | password |
      | T10136908 | prueba01 |

  @MoCa-CajaDeAhorroPesos-ExtraccionSinTarjeta
  Scenario Outline: Enviar extraccion sin tarjeta
    Given Que el usuario se loguea con "<username>" "<password>"
    When Clickea en tres puntos de Caja de ahorro pesos
    And Clickea en Extraccion sin tarjeta
    And Clickea en Nueva Extraccion sin tarjeta
    And Clickea en Enviar extraccion sin tarjeta
    Then Verifica que se visualice la pantalla de enviar extraccion sin tarjeta

    Examples: 
      | username  | password |
      | T17319044 | prueba01 |
      
  @MoCa-018-CompartirTransferencia
  Scenario Outline: Usuario comparte comprobante de transferencia
  	Given Estoy en la pantalla de Login
    And Me logueo con el usuario "<username>" y la pass "<password>"
    When Clickea en Transferir
    And Completa campos y presiona continuar
    And Verifica datos ingresados y presiona continuar
    And Ingresa Token y presiona Transferir
    And Verifica que se haya hecho la transferencia
    Then Presiona Compartir y verifica que se haya abierto Pop up

    Examples: 
      | username  | password |
      | U21465763 | prueba01 |
