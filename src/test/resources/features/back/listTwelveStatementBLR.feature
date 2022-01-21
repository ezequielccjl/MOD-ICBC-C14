@backEnd
Feature: Servicio - list twelve statement BLR

  @listTwelveStatementBLR
  Scenario Outline: Llamada al metodo POST listTwelveStatementBLR
    Given El usuario loguea correctamente con "<user>" "<pass>" "<deviceId>"
    When Hace la consulta con "<transactionId>" "<channel>" "<cardBrandIndicatorCode>" "<cardProductNumber>" "<fromDate>" "<toDate>" "<maxResultsNumber>" "<resultCode>"
    Then Verifico que la response sea correcta

    Examples: 
      | user     | pass     | deviceId|transactionId                       | channel | cardBrandIndicatorCode | cardProductNumber  	 | fromDate  	 | toDate 	| maxResultsNumber  | resultCode |
      | 				 | 				  |         |a34f8c43-eda1-4fc4-a11e-248901a04c72| mbr 		 | visa										|0380379279						 |2021-01-20   |2022-02-20|20                 | ok				 |
      | 				 | 				  |         |a34f8c43-eda1-4fc4-a11e-248901a04c72| mbr 		 |												|0380379279						 |2021-01-20   |2022-02-20|20                 |	error			 |
