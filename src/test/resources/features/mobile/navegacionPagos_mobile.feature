@navegacionPagos_mobile
Feature: Experiencia de Navegacion en Pagos

  @navegacionPagos_mobile_Caso086
  Scenario Outline: Navegación hacia atrás desde la pantalla - Próximos vencimientos
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    When Voy a la solapa Pagos
    Then Valido que este en la solapa Pagos
    And Voy a la opcion Pagos
    And Valido que haya entrado en la opcion Pagos
    And Vuelvo hacia atras en la opcion Pagos
    Then Valido que este en la solapa Pagos

    Examples: 
      | user      | password |
      | U10567381 | prueba01 |

  @navegacionPagos_mobile_Caso087
  Scenario Outline: Navegación hacia atrás desde la pantalla - Próximos vencimientos
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    When Voy a la solapa Pagos
    Then Valido que este en la solapa Pagos
    And Voy a la opcion Pagos
    And Valido que haya entrado en la opcion Pagos
    And Aprieto el boton pagar otras cuentas
    And Valido que entro en la opcion pagar otras cuentas
    And Vuelvo hacia atras en la opcion pagar otras cuentas
    And Valido que haya entrado en la opcion Pagos

    Examples: 
      | user      | password |
      | U10567381 | prueba01 |

  @navegacionPagos_mobile_Caso088
  Scenario Outline: Navegación hacia atrás desde la pantalla - DEBIN
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    When Voy a la solapa Pagos
    Then Valido que este en la solapa Pagos
    When Voy a la opcion DEBIN
    And Valido que entro en la opcion DEBIN
    And Vuelvo hacia atras en la opcion DEBIN
    Then Valido que este en la solapa Pagos
    
    Examples: 
      | user      | password |
      | U10567381 | prueba01 |

  @navegacionPagos_mobile_Caso089
  Scenario Outline: Navegación hacia atrás desde la pantalla -Historial autorizaciones-
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<password>"
    When Voy a la solapa Pagos
    Then Valido que este en la solapa Pagos
    When Voy a la opcion DEBIN
    And Valido que entro en la opcion DEBIN
    And Apreto el boton historial de autorizaciones
    And Valido que entro en la pantalla historial de autorizaciones
    And Vuelvo hacia atras en la pantalla de historial de autorizaciones
    And Valido que entro en la opcion DEBIN
    
    Examples: 
      | user      | password |
      | U10567381 | prueba01 |
