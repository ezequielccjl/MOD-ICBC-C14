@backEnd
Feature: Servicio - llamada al metodo POST canceledProductsBLR

  @canceledProductsBLR
  Scenario Outline: llamada al metodo POST canceledProductsBLR
    Given declaramos el requestSpecification
    When llamamos al metodo canceledProductsBLR con "<channel>" "<transactionId>" "<clientNumber>" "<fromCode>" "<toCode>" "<resultCode>" "<schema>"
    Then se valida el codigo de la response

    Examples: 
      | channel  | transactionId		 | clientNumber | fromCode | toCode | resultCode | schema 																			|
      | mbr			 | jacome.rodrigo.pm | 04647871			| 01			 | 99 		| ok				 | schemas/schemaCanceledProductsBLR_ok.json 		|
      | mbr			 | jacome.rodrigo.pm | 							| 01			 | 99 		| error			 | schemas/schemaCanceledProductsBLR_error.json |

