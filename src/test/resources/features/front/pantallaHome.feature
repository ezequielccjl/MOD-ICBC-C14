@pantallaHome
Feature: El usuario entra a su Home

  Scenario Outline: Verifiacion de productos en Home
    Given El usuario "<user>" se loguea con "<password>"
    When Revisa sus productos
    Then Verifica que tenga productos "<cajaAhorroPesos>" "<cuentaCorriente>" "<cajaAhorroDolar>" "<tarjeta1>" "<tarjeta2>"
    
    Examples:
		| user    | password |cajaAhorroPesos |cuentaCorriente |cajaAhorroDolar |tarjeta1    |tarjeta2          |
		|corona01 | Prueba01 |0825/01111044/88|0825/02103493/57|0825/11104452/63|Visa Titular|Mastercard Titular|
