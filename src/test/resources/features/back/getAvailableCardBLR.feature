Feature: Servicio - llamada al metodo POST getAvailableCardBLR

  @getAvailableCardBLR
  Scenario Outline: llamada al metodo POST getAvailableCardBLR
    Given se preparan las especificaciones necesarias
    When llamamos al metodo getAvailableCardBLR con "<channel>" "<cardNumber>" "<operationType>" "<productType>" "<resultCode>"
    Then validamos la response devuelta

    Examples: 
      | channel  | cardNumber				| operationType | productType | resultCode |
      | MBR			 | 4423120001187332 | C							| visa 				| ok				 |
      | MBR			 | 4423120001187332 | C							| 		 				|						 |

