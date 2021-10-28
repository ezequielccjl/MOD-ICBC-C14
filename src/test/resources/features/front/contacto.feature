
Feature: El usuario se dirige a pantalla Contacto

  @pantallaContacto
  Scenario Outline: Ingresar a Contacto
    Given El usuario se logea con "<user>" "<password>"
    When Presiona en la pestania Mas
    And Selecciona Contacto
    Then Verifica que se encuentre en Contacto
    
    Examples:
		| user    | password |
		|corona01 | Prueba01 |

