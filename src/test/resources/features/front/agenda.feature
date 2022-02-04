@Agenda
Feature: Agenda de transferencias

	@Agenda-AgregarDestinatario
  Scenario Outline: Agrego un nuevo destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Se dirige a agenda
    And Selecciona crear un nuevo destinatario
    And Completa "<cvualias>" "<descripcion>" y presiona continuar
    Then Verifica que se haya agregado correctamente

    Examples: 
      | user      | pass     | cvualias 							 | descripcion    |
      | U32881700 | prueba01 | 0150501602000001476653  | PruebaTesting  |
      
  @Agenda-EditarDestinatario
  Scenario Outline: Edito un destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Se dirige a agenda
    And Selecciona el "<userAModificar>"
    And Clickea menu tres puntos y Editar
    And Edita "<cvualias>" "<descripcion>" y presiona continuar
    Then Verifica que se muestren los datos editados y operacion completada
    

    Examples: 
      | user      | pass     | userAModificar | cvualias 							  | descripcion    |
      | U32881700 | prueba01 | Tucumano       | 0150501602000001476653  | PruebaEdicion  |
      
  @Agenda-ConsultaTransferenciaDestinatario
  Scenario Outline: Realizo la consulta de un destinatario y le transfiero
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Se dirige a agenda
    And Selecciona el "<userAConsultar>"
    And Clickea menu tres puntos y Transferir
    And Completa campos "<monto>" "<concepto>" y selecciona continuar
    And Verifica comprobante e ingresa token
    Then Verifica transferencia exitosa
    

    Examples: 
      | user      | pass     | userAConsultar | monto | concepto |
      | U32881700 | prueba01 | Tucumano       | 100	  | Varios 	 |
      
  @Agenda-EliminarDestinatario
  Scenario Outline: Edito un destinatario
    Given Estoy en la pantalla de Login
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    When Se dirige a agenda
    And Selecciona el "<userAEliminar>"
    And Clickea menu tres puntos y Eliminar
    And Cancela y vuelve a confirmar pop up
    Then Verifica que el destinatario se haya eliminado
    

    Examples: 
      | user      | pass     | userAEliminar  |
      | U32881700 | prueba01 | Tucumano       |
      
   
