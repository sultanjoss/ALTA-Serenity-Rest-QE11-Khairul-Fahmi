Feature: POST Login Successfully

  @Tugas
  Scenario: Post login succesfully
    Given Post login successfully with valid json
    When Send request post login successfully
    Then Status code should be 200 OK
    And Response body "QpwL5tke4Pnpja7X4"