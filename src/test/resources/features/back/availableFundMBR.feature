@backEnd
Feature: Servicio - llamada al metodo POST availableFundMBR

  @availableFundMBR
  Scenario Outline: llamada al metodo POST availableFundMBR
    Given se prepara el logueo con los datos "<user>" "<pass>" "<deviceId>" para availableFundMBR
    When llamo al metodo availableFundMBR
    Then se valida que el code sea el esperado de availableFundMBR

    Examples:
    	| user		 | pass 		| deviceId |
    	| U8295439 | prueba01 |					 |