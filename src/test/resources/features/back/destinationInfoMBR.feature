Feature: Servicio - MBR channel-transfer-account destination-info

  @destinationInfoMBR
  Scenario Outline: Llamada al metodo POST destinationInfoMBR
    Given Login exitoso con "<user>" "<pass>" "<deviceId>"
    When Realiza la consulta con "<transactionId>" "<destinationAliasCbuCvu>" "<resultCode>"
    Then Se verifica el codigo de respuesta

    Examples: 
      | user     | pass     | deviceId|transactionId                       | destinationAliasCbuCvu  | resultCode |
      | corona01 | Prueba01 |         |ad4ca27c-a637-4207-8b32-69ee962fc287|1430001713000000360014	 | ok 			  |
      | corona01 | Prueba01 |   			|ad4ca27c-a637-4207-8b32-69ee962fc287|                         | fail       |

