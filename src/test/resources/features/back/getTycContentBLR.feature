@backEnd
Feature: Servicio - llamada al metodo POST getTycContentBLR

  @getTycContentBLR
  Scenario Outline: llamada al metodo POST getTycContentBLR
    Given las especificaciones del request se preparan
    When llamo al metodo getTycContentBLR con "<channel>" "<password>" "<serviceName>" "<transactionId>" "<userId>"
    Then se valida el codigo de respuesta

    Examples: 
      | channel  | password | serviceName | transactionId												| userId |
      | BLR			 | mbr2014  | gateway_tyc |9f73364f-28e4-4729-84b8-47363713a7c4 | mbrusr |
