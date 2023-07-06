Feature: API automation testing Alta QE Batch 11
  @Latihan
  Scenario Outline: Get List Users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
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

  @Tugas
  Scenario: Get Single User with valid parameter page
    Given Get Single User with valid parameter id 2
    When Send request single user
    Then Status code should be 200 OK
    And Response email "janet.weaver@reqres.in"
    And Response first_name "Janet"
    And Response last_name "Weaver"
    And Response avatar "https://reqres.in/img/faces/2-image.jpg"

#    @Tugas
#    Scenario: Post register succesfull
#      Given Post create register with valid json
#      When Send request post register succesfull
#      Then Status code should be 200 created
#      And Response body email was "" and pasword ""

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




