
Feature: El usuario se dirige a pantalla Contacto

  @pantallaContacto
  Scenario: Ingresar a Contacto
    Given El usuario se logea con "<user>" y "<password>"
    When Presiona en la pestaña Mas
    And Selecciona Contacto
    Then Verifica que se encuentre en Contacto
