Feature: Servicio - llamada al metodo POST canceledProductsBLR

  @canceledProductsBLR
  Scenario Outline: llamada al metodo POST canceledProductsBLR
    Given declaramos el requestSpecification
    When llamamos al metodo canceledProductsBLR con "<channel>" "<transactionId>" "<clientNumber>" "<fromCode>" "<toCode>"
    Then se valida el codigo de la response

    Examples: 
      | channel  | transactionId		 | clientNumber | fromCode | toCode |
      | mbr			 | jacome.rodrigo.pm | 04647871			| 01			 | 99 		|

