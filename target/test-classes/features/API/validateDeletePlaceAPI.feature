Feature: Validating Place APIs

  Scenario: Verify if place is being successfully deleted using DeletePlaceAPI
    Given Add place payload
    When user calls "deletePlaceAPI" with "post" http request
    Then the API call is success with 200 Status code
    And "status" in response body is "OK"
    And "scope" in response body is "APP"