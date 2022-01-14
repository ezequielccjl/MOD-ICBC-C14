@backEnd
Feature: Servicio - getEmailsBLR

  @getEmailsBLR
  Scenario Outline: Llamada al metodo POST getEmailsBLR
    Given Se preparan las especificaciones para getEmailsBLR
    When Realiza la consulta al metodo getEmailsBLR con "<system>" "<name>" "<operation>" "<version>" "<ip>" "<port>" "<layer>" "<index>" "<latency>" "<channel>" "<groupId>" "<password>" "<remoteHost>" "<serviceName>" "<sessionId>" "<transactionId>" "<userId>" "<numClie>" "<resultCode>"
    Then Verifico el codigo devuelto por el metodo

    Examples: 
      | system | name     																				 | operation  | version | ip   				| port  | layer 	| index | latency | channel | groupId			| password | remoteHost  | serviceName | sessionId 																						| transactionId												 | userId | numClie  | resultCode |
      | retail | com.midd.test.service.ChannelPdpOnboardingService | get-emails | 1.0.0   | 10.11.12.13 | 28080 | service | 2			| 247			| mbr			| 20000000001 | mbr2014  | 10.11.12.13 | getEmails	 | c68405db-a424-4531-afb7-a4724e475dd3_MBR_session_dev | 8a33ff49-64adce33-0164-add58e7b-1111 | mbrusr | 01936084 | ok					|
      | retail | com.midd.test.service.ChannelPdpOnboardingService | get-emails | 1.0.0   | 10.11.12.13 | 28080 | service | 2			| 247			| mbr			| 20000000001 | mbr2014  | 10.11.12.13 | getEmails	 | c68405db-a424-4531-afb7-a4724e475dd3_MBR_session_dev | 8a33ff49-64adce33-0164-add58e7b-1111 | mbrusr | 				 | 500				|

