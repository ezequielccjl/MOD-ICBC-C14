@transferenciaInmediata
Feature: El usuario realiza una transferencia inmediata

  Scenario Outline: Transferencia inmediata
    Given El user "<user>" se loguea con "<password>"
    When Presiona en la pestania Transferir
    And Selecciona "<destino>" "<monto>" "<concepto>" y presiona continuar
    And Presiona continuar ingresa token y confirma transferencia
    Then Verfica transferencia exitosa
    
    Examples:
		| user     | password |destino					 	    |monto 	  |concepto |
		|U10567381 | prueba01 |0000095602014431735206 |100		  |Varios		|
