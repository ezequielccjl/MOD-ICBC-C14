Feature: Servicio - messagingOpBLR

  @messagingOpBLR
  Scenario Outline: Llamada al metodo POST messagingOpBLR
    Given Se preparan las especificaciones requeridas
    When Llamada al metodo messagingOpBLR con "<channel>" "<clientNumber>" "<docNumber>" "<typeDoc>" "<gender>" "<show>" "<resultCode>"
    Then Verifico el status code devuelto

    Examples: 
      | channel  | clientNumber | docNumber| typeDoc| gender | show | resultCode |
      | MBR 		 | 02110087		  | 25371858 | 04 		| M 		 | N	  | ok				 |
      | MBR 		 | 						  | 				 |		 		|   		 |  	  | fail			 |
