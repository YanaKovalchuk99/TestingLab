Feature: Pages Testing

  Scenario: Search in catalog
    Given Open catalog page
    When User search математика in the directory
    Then Search check
    And Close catalog page

  Scenario:Registration on sat
    Given Open catalog page
    When User clicks registration button
    Then Registration check
    And Close catalog page

  Scenario: Incorrect login and password
    Given Open login page
    When User enters login koval_yana99@mail.ru and password 1234
    Then Error message
    And Close login page

  Scenario: Recovery password
    Given Open login page
    When User forgot password
    Then Password recovery page
    And Close login page

  Scenario: Become an author
    Given Open main page
    When Page text received
    Then Page text is no different from онлайн-курсы от ведущих вузов и компаний страны
    And Close main page

  Scenario: Click catalog button
    Given Open main page
    When User clicks directory button
    Then Go to catalog page
    And Close main page
    
