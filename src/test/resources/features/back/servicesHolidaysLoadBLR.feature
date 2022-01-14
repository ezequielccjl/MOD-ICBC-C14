@backEnd
Feature: Servicio - llamada al metodo POST servicesHolidaysLoadBLR

  @servicesHolidaysLoadBLR
  Scenario Outline: llamada al metodo POST servicesHolidaysLoadBLR
    Given se preparan las especificaciones del request de servicesHolidaysLoadBLR
    When llamo al metodo servicesHolidaysLoadBLR con "<channel>" "<transactionId>" 
    Then se valida la response de servicesHolidaysLoadBLR

    Examples: 
      | channel  | transactionId															 |
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4-azg123 |


