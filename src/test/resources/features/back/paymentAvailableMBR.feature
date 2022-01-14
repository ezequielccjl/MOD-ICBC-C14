@backEnd
Feature: Servicio - llamada al metodo POST paymentAvailableMBR

  @paymentAvailableMBR
  Scenario Outline: llamada al metodo POST paymentAvailableMBR
    Given nos logueamos con los datos "<user>" "<pass>" "<deviceId>"
    When llamo al metodo paymentAvailableMBR con "<transactionId>"
    Then validamos que el codigo de respuesta sea correcto

    Examples: 
      | user		| pass	 | deviceId |transactionId												|
      |F27308585|prueba01|					|9f73364f-28e4-4729-84b8-47363713a7c4 |



