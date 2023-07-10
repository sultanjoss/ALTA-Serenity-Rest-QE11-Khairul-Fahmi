Feature: Delete fitur in reqres
  @Tugas
    Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
