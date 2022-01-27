@backEnd
Feature: Servicio - llamada al metodo POST servicesHolidaysBLR

  @servicesHolidaysBLR
  Scenario Outline: llamada al metodo POST servicesHolidaysBLR
    Given se preparan las especificaciones del request de servicesHolidaysBLR
    When llamo al metodo servicesHolidaysBLR con "<channel>" "<transactionId>" 
    Then se valida la response de servicesHolidaysBLR

    Examples: 
      | channel  | transactionId															|
      | mbr			 | 9f73364f-28e4-4729-84b8-47363713a7c4-azg22 |
