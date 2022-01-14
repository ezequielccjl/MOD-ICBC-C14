Feature: El usuario paga la tarjeta de credito

	@pagarCredito
	Scenario Outline: Se paga el total de una tarjeta con pesos
		Given El usuario se logea con "<user>" y "<password>"
		When El usuario clickea en pagar "<tarjeta>" "<nroTarjeta>"
		And Clickea en boton pagar
		And Selecciona "<cuentaDebitar>" "<monedaPagar>" "<importe>" y clickea continuar
		And Clickea pagar
		Then Visualiza comprobante de pago
		
		Examples:
		| user     | password | tarjeta      | nroTarjeta | cuentaDebitar    | monedaPagar| importe |
		#|U11424824 | prueba01 | Mastercard	 | 9359  			| 0501/01159680/80 | PESOS      | 2500   |
		#|U11424824 | prueba01 | Mastercard	 | 9359  			| 0501/01159680/80 | DOLAR      | 2500   |
		#|U22730746 | prueba01 | Visa	 			 | 3597 			| 0545/02102333/91 | PESOS      | 11000   |
		|U22730746 | prueba01 | Visa	 			 | 3597  			| 0521/11109677/97 | DOLAR      | 10   	 |
		#|U22730746 | prueba01 | Visa	 			 | 3597  			| 0521/11109677/97 | DOLAR      | 10		   |
		
		