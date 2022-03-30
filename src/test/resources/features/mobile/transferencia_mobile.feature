@TransferMobile
Feature: El usuario realiza una transferencia inmediata

	@TransferMobile-SinAgregarDestinatario
  Scenario Outline: Transferencia mediante agenda sin agregar destinatario
    Given El usuario se encuentra en la app ICBC
    When Me logueo con el usuario "<user>" y la pass "<pass>"
    And Presiona en el boton Transferir
    And Seleccina destino y agrega nuevo destinatario con "<cbu>"
    And Selecciona "<origen>" "<monto>" "<concepto>"
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia exitosa
    
    Examples:
		| user    | pass	 |origen					  |cbu					 	        |monto 	  |concepto |
		|U21465763|prueba01|0517/01000004/11 |0150501602000001476653 |100		  |Varios		|
		#AGENDAR
