@transferenciaInmediata
Feature: El usuario realiza una transferencia inmediata

  Scenario Outline: Transferencia inmediata
    Given El user "<user>" se loguea con "<password>"
    When Presiona en la pestania Transferir
    And Selecciona "<destino>" "<monto>" "<concepto>"
    And Presiona continuar
    And Confirma transferencia
    Then Verfica que este en pantalla de SMS
    
    Examples:
		| user    | password |destino					 |monto |concepto |
		|corona01 | Prueba01 |jose maria medina|1		  |Cuota|
