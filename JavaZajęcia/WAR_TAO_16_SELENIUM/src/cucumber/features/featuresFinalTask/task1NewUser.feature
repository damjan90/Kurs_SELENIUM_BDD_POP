Feature: task1NewUser
 Scenario Outline: How to add new address
    Given I am on MyStore page
    When I go to sign in pannel
    And Log in to your account with
    And Click on Addresses button
    And click on add new address button
    And I fill in alias <Alias> field
    And I fill in address <adress> field
   And I fill in city <city> field
   And I fill in zip/postalcode <zip>
    And I fill in phone <phone> field
    Then New addres has been created
   And Check if operation is successful
    And close window

   Examples:
   |Alias| adress|city| zip|phone|
   |Daniel|Jasienica 2342|Kaliningrad|00-090|454543433|
   |Kamil |Warszawa 104  |Poznań     |02-020|544545449|