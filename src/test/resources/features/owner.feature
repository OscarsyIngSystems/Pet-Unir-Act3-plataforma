Feature: Agregar un nuevo dueño (Owner)
  Scenario: Agregar un dueño válido
    Given I am on the New Owner page
    When I click on "Add Owner"
    And I fill the form with:
      | First Name | Miguel     |
      | Last Name  | Ortiz    |
      | Address    | Calle 11|
      | City       | Mexico   |
      | Telephone  | 600123456|
    And I click "Add Owner" button
    Then I should see "Miguel Ortiz" in the owners list
    And the owner data should be saved in the database

  Scenario: Cancelar
    Given I am on the New Owner page
    When I click "Back" button
    Then I should be redirected to the owners list
