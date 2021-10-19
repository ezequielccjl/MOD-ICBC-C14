Feature: El usuario paga la tarjeta de credito

	@tagPagarTarjetaCredito
	Scenario Outline: Pagar tarjeta de credito
		Given El usuario se logea con "<user>" y "<password>"
		When El usuario clickea en pagar
		And Selecciona "<cuentaDebitar>" "<monedaPagar>" "<importe>" y clickea continuar
		And Clickea pagar
		Then Visualiza comprobante de pago
		
		
		
		Examples:
		| user    | password | cuentaDebitar   | monedaPagar | importe |
		|usuario53| Prueba01 | 0530/01006879/57| PESOS       | 1       |