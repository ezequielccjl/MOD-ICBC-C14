@TransferMobile
Feature: El usuario realiza una transferencia inmediata

  @TransferMobile-SinPrevioAgendamiento_caso001
  Scenario Outline: Transferencia mediante agenda - Agregar destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Selecciona destino
    And Selecciona agregar nuevo destinatario
    And Ingresa cvu-cbu-alias con "<cbu>" y la descripcion
    And Presiona el check de agregar destinatario a mi agenda
    And Presiona el boton continuar en agenda
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia exitosa

    Examples: 
      | user      | pass     | origen           |cbu                   | monto | concepto |
      | U21465763 | prueba01 | 0517/01000004/11 |0150501602000001476653|   100 | Varios   |

  @TransferMobile-SinAgregarDestinatario_caso002
  Scenario Outline: Transferencia mediante agenda sin agregar destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Selecciona destino
    And Selecciona agregar nuevo destinatario
    And Ingresa cvu-cbu-alias con "<cbu>" y la descripcion
    And Presiona el boton continuar en agenda
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia realizada

    Examples: 
      | user      | pass     | origen           | cbu                    | monto | concepto |
      | U21465763 | prueba01 | 0517/01000004/11 | 0150501602000001476653 |   100 | Varios   |

  @TransferMobile-caso004
  Scenario Outline: Transferencia - SIN agregar destinatario a mi agenda - ALIAS-CBU-CVU Invalido o Inexistente.
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Selecciona destino
    And Selecciona agregar nuevo destinatario
    And Ingresa cvu-cbu-alias con "<cbucvualias>" y la descripcion
    Then Presiona continuar y valida que el cbu-cvu-alias ingresado es invalido

    Examples: 
      | user      | pass     | cbucvualias 						| descripcion |
      | U21465763 | prueba01 | pruebafallida22caracteres | cvuinvalido |

  @TransferMobile-caso007
  Scenario Outline: Transferencia - Agregando destinatario a mi agenda - ALIAS-CBU-CVU Invalido o Inexistente.
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Selecciona destino
    And Selecciona agregar nuevo destinatario
    And Ingresa cvu-cbu-alias con "<cbucvualias>" y la descripcion
    And Presiona el check de agregar destinatario a mi agenda
    Then Presiona continuar y valida que el cbu-cvu-alias ingresado es invalido

    Examples: 
      | user      | pass     | cbucvualias | descripcion |
      | U21465763 | prueba01 | pruebafallida22caracteres | cvuinvalido |
  
  #En Desarrollo
  @TransferMobile-caso009
  Scenario Outline: Transferencia - Editar destinatario.
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Voy a agenda
    And Busco "<destinatario>"
    And Presiono Editar
    And Ingresa cvu-cbu-alias con "<cbucvualias>" y la "<descripcion>"
    Then Presiona continuar y valida que el cbu-cvu-alias ingresado es invalido
    
    Examples: 
      | user      | pass     |destinatario| cbucvualias 				  | descripcion |
      | U21465763 | prueba01 |PRUEBA CON X|0150501602000001476653 | DESTINATARIOEDITADO |
    
  @TransferMobile-caso010
  Scenario Outline: Transferencia - Editar destinatario - ALIAS-CBU-CVU Invalido.
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Voy a agenda
    And Busco "<destinatario>"
    And Presiono Editar
    And Ingresa cvu-cbu-alias con "<cbucvualias>" y la descripcion
    Then Presiona continuar y valida que el cbu-cvu-alias ingresado es invalido
    
    Examples: 
      | user      | pass     |destinatario| cbucvualias 							 | descripcion |
      | U21465763 | prueba01 |PRUEBA CON X|pruebafallida22caracteres | cvuinvalido |
      
  #En Desarrollo
  @TransferMobile-caso013
  Scenario Outline: Transferencia - Transferir desde agenda.
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Voy a agenda
    And Busco "<destinatario>"
    And Presiono Transferir
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verifica transferencia realizada
    
    Examples: 
      | user      | pass     | origen           | cbu                    | monto | concepto |destinatario|
      | U21465763 | prueba01 | 0517/01000004/11 | 0150501602000001476653 |   100 | Varios   |PRUEBA CON X|
