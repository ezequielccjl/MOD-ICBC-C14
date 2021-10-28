Feature: El usuario paga la tarjeta de credito

	@pantallaPagarCredito
	Scenario Outline: Pagar tarjeta de credito
		Given El usuario se logea con "<user>" y "<password>"
		When El usuario clickea en pagar
		And Selecciona "<cuentaDebitar>" "<monedaPagar>" "<importe>" y clickea continuar
		And Clickea pagar
		Then Visualiza comprobante de pago
		
		
		
		Examples:
		| user    | password | cuentaDebitar   | monedaPagar | importe |
		|corona01 | Prueba01 | 0825/01111044/88| PESOS       | 1       |