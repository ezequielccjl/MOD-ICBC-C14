@backEnd
Feature: Servicio - llamada al metodo POST modifyUserLogonBLR

  @modifyUserLogonBLR
  Scenario Outline: llamada al metodo POST modifyUserLogonBLR
    Given se preparan las especificaciones para el metodo
    When llamo al metodo modifyUserLogonBLR con "<channel>" "<transactionId>" "<klogonUserId>" "<klogonType>" "<klogonNum>" "<klogonPass>" "<kgender>" "<resultCode>"
    Then validamos que el response code sea el esperado

    Examples: 
      | channel | transactionId												| klogonUserId | klogonType | klogonNum | klogonPass | kgender | resultCode |
      | mbr			|9f73364f-28e4-4729-84b8-47363713a7c4 | m20444413		 | 04 				| 20444413  | prueba01   | M			 | ok					|
      | mbr			|9f73364f-28e4-4729-84b8-47363713a7c4 | m20444413		 | 04 				| 20444413  | 				   | M			 | FAIL				|
