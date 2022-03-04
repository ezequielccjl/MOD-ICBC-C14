@Transferencia
Feature: El usuario realiza una transferencia inmediata

	@Transferencia-SinAgregarDestinatario
  Scenario Outline: Transferencia mediante agenda sin agregar destinatario
    Given El user "<user>" se loguea con "<password>"
    When Presiona en el boton Transferir
    And Seleccina destino y agrega nuevo destinatario con "<cbu>"
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia exitosa
    
    Examples:
		| user     | password |origen					  |cbu					 	        |monto 	  |concepto |
		|U10567381 | prueba01 |0517/01000004/11 |0150501602000001476653 |100		  |Varios		|
		
	@Transferencia-AgregandoDestinatario
	Scenario Outline: Transferencia mediante agenda agregando destinatario
    Given El user "<user>" se loguea con "<password>"
    When Presiona en el boton Transferir
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Seleccina destino y agrega nuevo destinatario con "<cbu>"
    And Marca palomita para aniadir destinatario
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia exitosa
    
    Examples:
		| user     | password |origen					  |cbu					 	        |monto 	  |concepto |
		|U10567381 | prueba01 |0517/01000004/11 |0150501602000001476653 |100		  |Varios		|
		
	@Transferencia-CBUCVUAliasInexistente
  Scenario Outline: Transferencia mediante agenda sin agregar destinatario con CBU-CVU-Alias inexistente
    Given El user "<user>" se loguea con "<password>"
    When Presiona en el boton Transferir
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Seleccina destino y agrega nuevo destinatario con "<cbu>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia erronea
    
    Examples:
		| user     | password |origen					  |cbu					 	|monto 	  |concepto |
		|U10567381 | prueba01 |0517/01000004/11 |PRUEBA.ERRONEA |100		  |Varios		|
		
	@Transferencia-CBUCVUAliasInexistente-Agregando
  Scenario Outline: Transferencia mediante agenda sin agregar destinatario con CBU-CVU-Alias inexistente
    Given El user "<user>" se loguea con "<password>"
    When Presiona en el boton Transferir
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Marca palomita para aniadir destinatario
    And Seleccina destino y agrega nuevo destinatario con "<cbu>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia erronea
    
    Examples:
		| user     | password |origen					  |cbu					 	|monto 	  |concepto |
		|U10567381 | prueba01 |0517/01000004/11 |PRUEBA.ERRONEA |100		  |Varios		|
