@AgendaMobile
Feature: Agenda de transferencias mobile

  @AgendaMobile_caso001
  Scenario Outline: Agrego un nuevo destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Voy a la opcion Nuevo destinatario
    And Completa "<cvualias>" "<descripcion>"
    And Presiona continuar y confirma los datos ingresados "<cvualias>" "<descripcion>"
    Then Verifica que se haya agregado el destinatario "<cvualias>" "<descripcion>"

    Examples:
      | user      | pass     | cvualias            | descripcion         |
      #| U26363609 | prueba01 | 0150501602000001476653 | AgregarDestinatario |
      | U21465763 | prueba01 | 0150501602000001476653 | AgregarDestinatario |

  @AgendaMobile_caso002
  Scenario Outline: Agrego un nuevo destinatario desde transferir
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Selecciona destino
    And Voy a la opcion Nuevo destinatario
    And Completa "<cbucvualias>" "<descripcion>"
    And Aprieta el check de agregar destinatario a mi agenda
    And Presiona continuar
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia realizada

    Examples:
      | user      | pass     | cbucvualias            | descripcion         |origen|monto|concepto|
      | U21465763 | prueba01 | 0150501602000001476653 | DestinoDesdeTranf 	|origen|1000 |Varios	|

  @AgendaMobile_caso003
  Scenario Outline: Editar un destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    #AGREGAR: And busca el destinatario
    And Aprieta el boton tres puntos del "<cvucbualias>"
    And Aprieta el boton editar
    And Edita el campo de cvucbualias con "<nuevocvucbualias>" y la descripcion con "<descripcion>"
    And Presiona continuar y confirma los datos ingresados "<cvualias>" "<descripcion>"
    Then Verifica la actualizacion de destinatario "<nuevocvucbualias>" "<descripcionEditada>"

    Examples:
      | user     | pass     | cvucbualias            | nuevocvucbualias       | descripcionEditada |
      | Corona01 | prueba01 | 0000001700000000008479 | 0150501602000001476653 | TestModernEdicion  |

  @AgendaMobile_caso004
  Scenario Outline: Ver detalle de un destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Selecciono el "<cvucbualias>"
    Then Valido el detalle "<cvucbualias>"

    Examples:
      | user     | pass     | cvucbualias            |
      | Corona01 | prueba01 | 1980001730000001079547 |

  @AgendaMobile_caso005
  Scenario Outline: Eliminar un destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    #AGREGAR: And busca el destinatario
    And Aprieta el boton tres puntos del "<cvucbualias>"
    And Aprieta el boton eliminar y cancela
    And Aprieta el boton eliminar y confirma eliminacion
    Then Valida eliminacion del destinatario "<cvucbualias>""<NombreAgendado>"

    Examples:
      | user     | pass     | cvucbualias            | NombreAgendado    |
      | Corona01 | prueba01 | 0150501602000001476653 | TestModernEdicion |


   @AgendaMobile_caso006
  Scenario Outline: Transferir desde la agenda
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Aprieta el boton tres puntos del "<cvucbualias>"
    And Aprieta el boton transferir
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia realizada
    And Presiona la opcion hacer otra transferencia
    And Selecciona destino
    And Selecciona agregar nuevo destinatario
    And Completa "<cbucvualias>" "<descripcion>"
    And Presiona el check de agregar destinatario a mi agenda
    And Presiona el boton continuar en agenda
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia exitosa

    Examples:
      | user      | pass     | cbucvualias            | descripcion         |origen|monto|concepto|    nuevocbucvualias	 |nuevadescripcion|
      | U21465763 | prueba01 | 0150501602000001476653 | DestinoDesdeTranf 	|origen|1000 |Varios	|1980001730000001079547|AgendaCaso6			|