Feature: API automation testing Alta QE Batch 11
  @Latihan
  Scenario Outline: Get List Users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
    And Validate get list user JSON schema
    And Print if status code 200 ok
    And Get log all
    And Get log body
    Examples:
      |page  |
      |1     |
      |2     |
  @Latihan
  Scenario: Post create new user with valid JSON
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 created
    And Response body name was "Khairul" and job was "TukangBegal"

  @LatihanGET
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request user with valid id and json
    Then Status code should be 200 OK
    And Response body name was "morpheus" and job was "zion resident"
    Examples:
    |id|
    |1 |
    |2 |

    @LatihanDelete
   Scenario Outline: Delete user with valid parameter id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Status code should be 204 No Content
      Examples:
      |id|
      |1 |
      |2 |
      |3 |




