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
Scenario Outline: Get list resource with valid parameter page
  Given Get list resource with valid parameter id <id>
  When Send request list resource
  Then Status code should be 200 OK
  And Response body should be contain <name> <year> <color> <pantone_value>
  And Validate get list resource JSON schema
  Examples:
    |id|    name       |  year    | color   | pantone_value   |
    |1 | cerulean      |  2000    |#98B2D1  |    15-4020      |
    |2 | fuchsia rose  |  2001    |#C74375  |    17-2031      |
    |3 | true red      |  2002    |#BF1932  |    19-1664      |
    |4 | aqua sky      |  2003    |#7BC4C4  |    14-4811      |
    |5 | tigerlily     |  2004    |#E2583E  |    17-1456      |
    |6 | blue turquoise|  2005    |#53B0AE  |    15-5217      |

