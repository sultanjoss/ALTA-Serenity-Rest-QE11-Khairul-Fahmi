Feature: testing POST in reqres web

  @Tugas
  Scenario: Post login succesfully
    Given Post login successfully with valid json
    When Send request post login successfully
    Then Status code should be 200 OK
    And Response body "QpwL5tke4Pnpja7X4"
    And Validate post login successfull JSON schema

    @Tugas @NegativeCase
      Scenario: Post login with empty email and send password
      Given Post login with empty email and send password
      When Send request post login successfully
      Then Status code should be 400 Bad Request
      And Response body is eror "Missing email or username"
      And Validate post login successfull JSON schemas

    @Tugas @NegativeCase
    Scenario: Post login unsuccesfully
      Given Post login unsuccessfully with invalid json
      When Send request post login unsuccessfully
      Then Status code should be 400 Bad Request
      And Response body is "Missing password"
      And Validate post login unsuccessfull JSON schema

    @Tugas
    Scenario: Post register succesfull
      Given Post create register with valid json
      When Send request post register succesfull
      Then Status code should be 200 created
      And Response body was 4 and QpwL5tke4Pnpja7X4
      And Validate post register successfull JSON schema

      @Tugas @NegativeCase
        Scenario: Post register with empty email and empty password
        Given Post register with empty email and empty password in json
        When Send request post register succesfull
        Then Status code should be 400 Bad Request
        And Responses body is "Missing email or username"
        And Validate post register unsuccessfull JSON schemas

      @Tugas @NegativeCase
      Scenario: Post register unsuccessfull
        Given Post register with valid email and empty password
        When Send request register unsuccessfull
        Then Status code should be 400 created
        And Responses body is "Missing password"
        And Validate post register unsuccessfull JSON schema