Feature: Servicio - servicesHierarchyBLR

  @servicesHierarchyBLR
  Scenario Outline: Llamada al metodo POST servicesHierarchyBLR
    Given Se hace la preparacion de las especificaciones
		When Se realiza la consulta al metodo servicesHierarchyBLR con "<channel>" "<transactionId>"
    Then Se verifica la response devuelta por el metodo

    Examples: 
      | channel | transactionId 											 | 
			| blr			| 9f73364f-28e4-4729-84b8-47363713a7c4 |
      

