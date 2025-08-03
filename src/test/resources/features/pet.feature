Feature: Agregar una nueva mascota (Pet)
  Scenario: Agregar una mascota válida
    Given I am viewing owner "Miguel Ortiz"
    When I click "Add New Pet"
    And I fill the pet form with:
      | Name      | Krypto       |
      | Birth Date| 2020-01-01|
      | Type      | dog       |
    And I click "Save Pet" button
    Then I should see "Krypto" in the pets list
    And the pet data should be saved in the database

  Scenario: Cancelar 
    Given I am viewing Add Pet of owner "Miguel Ortiz"
    When I click "Back" button
    Then I should be redirected to the owner details page
