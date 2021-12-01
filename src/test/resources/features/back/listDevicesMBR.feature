Feature: Servicio - listDevicesMBR

  @listDevicesMBR
  Scenario Outline: Llamada al metodo POST listDevicesMBR
    Given Se loguea con "<user>" "<pass>" "<deviceId>" correctamente
    When Se realiza la consulta al metodo listDevicesMBR con "<transactionId>" "<channel>"
    Then Se verifica la response code devuelta

    Examples: 
      | user     | pass     | deviceId|transactionId | channel |
      | corona01 | Prueba01 |         |jacome.rodrigo| mbr 		 |

      

