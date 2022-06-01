@AgendaMobile
Feature: Agenda de transferencias mobile

  @AgendaMobile_caso001
  Scenario Outline: Agrego un nuevo destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Voy a la opcion crear un nuevo destinatario
    And Completa "<cvualias>" "<descripcion>"
    And Presiona continuar y confirma los datos ingresados "<cvualias>" "<descripcion>"
    Then Verifica que se haya agregado el destinatario "<cbucvualias>" "<descripcion>"

    Examples: 
      | user      | pass     | cvualias            | descripcion   |
      | U21465763 | prueba01 | 0150501602000001476653 | AgregarDestinatario |

@AgendaMobile_caso002
  Scenario Outline: Agrego un nuevo destinatario desde transferir
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir

  @AgendaMobile_caso003
  Scenario Outline: Editar un destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Aprieta el boton tres puntos del "<cvucbualias>"
    And Aprieta el boton editar
    And Edita el campo de cvucbualias con "<nuevocvucbualias>" y la descripcion con "<descripcion>"
    And Presiona continuar y confirma los datos ingresados "<cvualias>" "<descripcion>"
    Then Verifica la actualizacion de destinatario "<nuevocvucbualias>" "<descripcion>"

    Examples: 
      | user     | pass     | cvucbualias            | nuevocvucbualias       | descripcion       |
      | Corona01 | prueba01 | 0000001700000000008479 | 0150501602000001476653 | TestModernEdicion |

  @AgendaMobile_caso004
  Scenario Outline: Ver detalle de un destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Selecciono el "<cvucbualias>"
    Then Valido el detalle "<cvucbualias>"
    
    Examples: 
      | user     | pass     | cvucbualias            |
      | Corona01 | prueba01 | 1980001730000001079547 |

  @AgendaMobile_caso005
  Scenario Outline: Eliminar un destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Voy a agenda
    And Aprieta el boton tres puntos del "<cvucbualias>"
    And Aprieta el boton eliminar y cancela
    And Aprieta el boton eliminar y confirma eliminacion
    Then Valida eliminacion del destinatario

    Examples: 
      | user     | pass     | cvucbualias            |
      | Corona01 | prueba01 | 1980001730000001079547 |
