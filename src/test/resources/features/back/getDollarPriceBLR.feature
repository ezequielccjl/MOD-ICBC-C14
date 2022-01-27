@backEnd
Feature: Servicio - llamada al metodo POST getDollarPrice

@getDollarPriceBLR
  Scenario Outline: llamada al metodo POST getDollarPrice
    Given se preparan los valores del request
    When llamo al metodo getDollarPrice con "<channel>" "<transactionId>" "<codorgb>" "<codsegm>" "<resultCode>" "<schema>"
    Then se valida la respuesta del ms

    Examples: 
      | channel  | transactionId												|codorgb|codsegm | resultCode | schema 																		 |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |001	  |BAE     | ok		     	| schemas/schemaGetDollarPriceBLR_ok.json 	 |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |				|BAE     | error		 	| schemas/schemaGetDollarPriceBLR_error.json |
