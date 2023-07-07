Feature: API AUTOMED TUGAS QA BATCH 11
  @Tugas
  Scenario: Get Single User with valid parameter page
    Given Get Single User with valid parameter id 2
    When Send request single user
    Then Status code should be 200 OK
    And Response email "janet.weaver@reqres.in"
    And Response first_name "Janet"
    And Response last_name "Weaver"
    And Response avatar "https://reqres.in/img/faces/2-image.jpg"

    @Tugas
    Scenario: Post register succesfull
      Given Post create register with valid json
      When Send request post register succesfull
      Then Status code should be 200 created
#      And Response body email was "eve.holt@reqres.in" and password "pistol"
      And Response body was 4 and QpwL5tke4Pnpja7X4

    @Tugas
    Scenario Outline: Get Single User not found
      Given Get single user not found with invalid <id>
      When Send request single user not found
      Then Status code should be 404 Not Found
      Examples:
      |id|
      |23|
