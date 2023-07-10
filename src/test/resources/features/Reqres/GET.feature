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
    And Validate get single JSON schema

  @Tugas
    Scenario Outline: Get Single User not found
    Given Get single user not found with invalid <id>
    When Send request single user not found
    Then Status code should be 404 Not Found
    Examples:
      |id|
      |23|
  @Tugas
    Scenario Outline: Get list resource with valid parameter id
    Given Get list resource with valid parameter id <id>
    When Send request list resource
    Then Status code should be 200 OK
    And Response body displays several options <Name> <Year> <Color> <Pantone-value>
    And Response body displays support url "https://reqres.in/#support-heading"
    And Validate get list resource JSON schema
    Examples:
    |id|    Name       |  Year    | Color   | Pantone-value   |
    |1 | cerulean      |  2000    |#98B2D1  |    15-4020      |
    |2 | fuchsia rose  |  2001    |#C74375  |    17-2031      |
    |3 | true red      |  2002    |#BF1932  |    19-1664      |

  @Tugas
    Scenario Outline: Get single resource not found
      Given Get single resource not found with valid id <id>
      When Send request single resource not found
      Then Status code should be 404 Not Found
      Examples:
      |id|
      |23|

  @Tugas
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

  @Tugas
    Scenario Outline: Get delayed response
      Given Get delayed response <id>
      When Send request get delayed response
      Then Status code should be 200 OK
      And Validate JSON schema
      Examples:
      |id|
      |3 |

