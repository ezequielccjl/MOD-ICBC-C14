@agenda
Feature: Agenda de transferencias

  Scenario Outline: Agenda
    Given El usuario "<user>" "<pass>" se encuentra en la app
    When Se dirige a agenda
    And Selecciona crear un nuevo destinatario
    And Completa "<cvualias>" "<descripcion>" y presiona continuar
    Then Verifica que se haya agregado correctamente

    Examples: 
      | user      | pass     | cvualias 							 | descripcion    |
      | U32881700 | prueba01 | 0150545002000102333912  | PruebaTesting  |
