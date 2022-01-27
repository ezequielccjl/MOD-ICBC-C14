@agenda
Feature: Agenda de transferencias

  Scenario Outline: Agenda
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Se dirige a agenda
    And Selecciona crear un nuevo destinatario
    And Completa "<cvualias>" "<descripcion>" y presiona continuar
    Then Verifica que se haya agregado correctamente

    Examples: 
      | user      | pass     | cvualias 							 | descripcion    |
      | U32881700 | prueba01 | 0150501602000001476653  | PruebaTesting  |
