@backEnd
Feature: Servicio - llamada al metodo POST getAvailableCardBLR

  @getAvailableCardBLR
  Scenario Outline: llamada al metodo POST getAvailableCardBLR
    Given se preparan las especificaciones necesarias
    When llamamos al metodo getAvailableCardBLR con "<channel>" "<cardNumber>" "<operationType>" "<productType>" "<messageDescription>" "<schema>"
    Then validamos la response devuelta

    Examples: 
      | channel  | cardNumber				| operationType | productType | messageDescription								 | schema 																			|
      | MBR			 | 4423120001187332 | C							| visa 				| 																	 | schemas/schemaGetAvailableCardBLR_ok.json 		|
      | MBR			 | 4423120001187332 | C							| 		 				|	ProductType not support.					 | schemas/schemaGetAvailableCardBLR_error.json |

