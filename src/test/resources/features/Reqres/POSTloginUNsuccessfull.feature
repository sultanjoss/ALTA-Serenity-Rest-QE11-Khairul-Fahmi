Feature: login unsuccessfully

  Scenario: Post login unsuccesfully
    Given Post login unsuccessfully with invalid json
    When Send request post login unsuccessfully
    Then Status code should be 400 Bad Request
    And Response body is eror "Missing  password"