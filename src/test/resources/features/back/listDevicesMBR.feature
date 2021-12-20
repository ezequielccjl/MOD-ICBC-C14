Feature: Servicio - listDevicesMBR

  @listDevicesMBR
  Scenario Outline: Llamada al metodo POST listDevicesMBR
    Given Se loguea con "<user>" "<pass>" "<deviceId>" correctamente
    When Se realiza la consulta al metodo listDevicesMBR con "<transactionId>" "<channel>" "<resultCode>"
    Then Se verifica la response code devuelta

    Examples: 
      | user      | pass     | deviceId|transactionId | channel  | resultCode |
      | F27308585 | prueba01 |         |jacome.rodrigo| mbr 		 | ok					|
      | F27308585 | prueba01 |         |jacome.rodrigo| 		 		 | error			|

      

