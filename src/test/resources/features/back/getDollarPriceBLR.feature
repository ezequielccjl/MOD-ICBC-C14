@backEnd
Feature: Servicio - llamada al metodo POST getDollarPrice

@getDollarPriceBLR
  Scenario Outline: llamada al metodo POST getDollarPrice
    Given se preparan los valores del request
    When llamo al metodo getDollarPrice con "<channel>" "<transactionId>" "<codorgb>" "<codsegm>" "<resultCode>"
    Then se valida la respuesta del ms

    Examples: 
      | channel  | transactionId												|codorgb|codsegm | resultCode |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |001	  |BAE     | ok		   |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4 |				|BAE     | error		 |
