@prueba
Feature: Busqueda
	El usuario realiza una busqueda

  Scenario: Busqueda exitosa
    Given El usuario esta en la pagina de google
    When Ingresa la busquedas
    And hace click en buscar
    Then valida que la busqueda este ok