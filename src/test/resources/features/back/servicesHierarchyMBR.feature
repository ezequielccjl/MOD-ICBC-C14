@backEnd
Feature: Servicio - servicesHierarchyMBR

  @servicesHierarchyMBR
  Scenario Outline: Llamada al metodo POST servicesHierarchyMBR
    Given Se hace el login con "<user>" "<pass>" "<deviceId>" de forma correcta
		When Se realiza la consulta al metodo servicesHierarchyMBR con "<channel>" "<transactionId>"
    Then Se verifica la response devuelta del metodo

    Examples: 
     | user 		 | pass 		| deviceId | channel 	| transactionId 											 | 
		 | F27308585 | prueba01 |					 | blr			| 9f73364f-28e4-4729-84b8-47363713a7c4 |
      


