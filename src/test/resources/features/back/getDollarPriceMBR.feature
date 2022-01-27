@backEnd
Feature: Servicio - llamada al metodo POST getFaqContentMBR

  @getDollarPriceMBR
  Scenario Outline: llamada al metodo POST getDollarPriceMBR
    Given preparamos logueo con "<user>" "<pass>" "<deviceId>"
    When llamo al metodo getDollarPriceMBR con "<channel>" "<transactionId>" "<fromInvestment>"
    Then validamos el codigo final del response

    Examples: 
      | user		| pass	 | deviceId | channel  | transactionId												       |fromInvestment |
      |F27308585|prueba01|					| mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4-dollar |true					 |