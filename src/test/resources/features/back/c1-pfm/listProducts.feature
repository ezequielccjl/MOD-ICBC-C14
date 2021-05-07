Feature: Listar productos
	
  Scenario: listar los productos del cliente
    When envio el json con tipo de documento, numero y genero
    Then recibo los productos correctos del cliente
    