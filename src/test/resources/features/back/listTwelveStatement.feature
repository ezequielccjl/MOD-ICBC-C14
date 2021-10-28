Feature: Servicio - list twelve statement

  @listTwelveStatement
  Scenario Outline: Llamada al metodo POST listTwelveStatement
    Given El usuario loguea correctamente con "<user>" "<pass>" "<deviceId>"
    When Hace la consulta con "<transactionId>" "<cardBrandIndicatorCode>" "<cardProductNumber>" <fromDate> <toDate> "<maxResultsNumber>"
    Then Verifico que la response sea correcta

    Examples: 
      | user     | pass     | deviceId|transactionId                       | cardBrandIndicatorCode | cardProductNumber  | fromDate  | toDate | maxResultsNumber  |
      | corona01 | Prueba01 |         |a34f8c43-eda1-4fc4-a11e-248901a04c72|visa										|30667831						 |20210920   |20211221|20                 |
