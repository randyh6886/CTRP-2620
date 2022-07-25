Feature: Import a study from clinicaltrial.gov system
  Scenario: import a study
    Given I click on import
    When I type into ClinicalTrials Identifier
    Then I click on Search Studies
    Then I click on Import trial
    Then I assert results
    Then I logout
