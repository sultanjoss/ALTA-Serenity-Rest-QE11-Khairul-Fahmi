Feature: PUT in reqres
  @Tugas
    Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request user with valid id and json
    Then Status code should be 200 OK
    And Response body name was "morpheus" and job was "zion resident"
    And Validate put update JSON schema
    Examples:
      |id|
      |1 |
      |2 |


  @Tugas
        #  postman seharusnya expektasi 400, tetapi masih 200
    Scenario Outline: Put update user with invalid name in JSON
    Given Put update user with invalid id <id> and json
    When Send request user with invalid id and json
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |
      |3 |

