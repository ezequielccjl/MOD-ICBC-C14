@listProductsMBR
Feature: Servicio - Consulta a los productos

  Scenario Outline: Llamada al metodo POST listProducts
    Given El usuario se loguea exitosamente con "<usuario>" "<pass>" "<deviceId>"
    When Hace la consulta al servicio con "<transactionId>" <filter>
    Then Verifico que se cargaron los productos correctamente

    Examples: 
      | usuario   | pass     |deviceId | transactionId                        | filter |
      | F27308585 | prueba01 |         |c88e9362-fe9a-43e6-945c-0a11ed70da6f  |		  01 |
