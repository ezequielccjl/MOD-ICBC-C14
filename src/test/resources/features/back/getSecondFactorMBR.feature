Feature: Servicio - getSecondFactorMBR

  @getSecondFactorMBR
  Scenario Outline: Llamada al metodo POST getSecondFactorMBR
    Given Realiza login con "<user>" "<pass>" "<deviceId>"
    When Envio "<system>" "<name>" "<operation>" "<version>" "<ip>" <port> "<layer>" <index> <latency> "<channel>" "<groupId>" "<password>" "<remoteHost>" "<serviceName>" "<sessionId>" "<transactionId>" "<taskId>" "<userId>" "<generatorIndicator>" al metodo getSecondFactorMBR
    Then Verifico el codigo de status

    Examples: 
    | user 	 	| pass 		 |deviceId | system 		 | name														  			| operation 	 | version | ip 				 | port 	| layer 	| index | latency | channel | groupId 		| password | remoteHost | serviceName | sessionId 													 | transactionId 												| taskId 		 | userId | generatorIndicator |
    | corona01| Prueba01 | 				 | retail 		 | com.midd.test.service.AccountsService  | listAccounts | 1.0.4   | 10.11.12.13 | 28080  | service	| 2		  | 247 		| PRE			| 20000000001 | xxx			 | 10.11.12.13| clientData	| 8a33ff49-64adce33-0164-add58e7b-9876 | 8a33ff49-64adce33-0164-add58e7b-0032 | 0123456789 | preuser| true							 |

