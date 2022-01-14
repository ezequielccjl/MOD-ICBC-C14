@backEnd
Feature: Servicio - llamada al metodo POST getAvailableCardBLR

  @getAvailableCardBLR
  Scenario Outline: llamada al metodo POST getAvailableCardBLR
    Given se preparan las especificaciones necesarias
    When llamamos al metodo getAvailableCardBLR con "<channel>" "<cardNumber>" "<operationType>" "<productType>" "<messageDescription>"
    Then validamos la response devuelta

    Examples: 
      | channel  | cardNumber				| operationType | productType | messageDescription								 |
      | MBR			 | 4423120001187332 | C							| visa 				| 																	 |
      | MBR			 | 4423120001187332 | C							| 		 				|	ProductType not support.					 |

