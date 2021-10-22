@listProductCardMBR
Feature: Servicio - Consulta a los productos
 

  Scenario Outline: Llamada al metodo POST listProductCard
    Given El usuario se loguea correctamente con "<user>" "<pass>" "<deviceId>"
    When Hace la consulta al servicio con "<transactionId>"
    Then Verifico que cargo los productos correctamente

    Examples: 
      | user	    | pass     |deviceId | transactionId                        |
      | F27308585 | prueba01 |         |0d27a017-b54b-413e-925c-7c88c500c7c2  |
