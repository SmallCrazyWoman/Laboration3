Feature: Test SVTPlay Website

  Scenario:Check SVT Title is correct
    Given Webpage is avaliable
    When user visits SVT Play
    Then title would be "SVT Play"

  Scenario:Check if SVT logo is visable
    Given Webpage is avaliable
    When user visits SVT Play
    Then logo is visable

  Scenario:Check if menu item Start is avaliable
    Given Webpage is avaliable
    When user visits SVT Play
    Then Menu item Start is avaliable

  Scenario:Check if menu item Program is avaliable
    Given Webpage is avaliable
    When user visits SVT Play
    Then Menu item Program is avaliable

  Scenario:Check if menu item kanaler is avaliable
    Given Webpage is avaliable
    When user visits SVT Play
    Then Menu item Kanaler is avaliable

  Scenario:Count number of program categories on SVT Play
    Given menu program is avaliable
    When user clicks menu item program
    Then number of categories should be 16

  Scenario:Check Sign Language Title
    Given Webpage is avaliable
    When user visits SVT Play
    Then Sign language title should be "Teckenspråk"

  Scenario:Access sign language page on SVT Play
    Given menu program is avaliable
    When user press sign language page
    Then Access sign language programs page and check title should be "Teckenspråkstolkade program och program på teckenspråk | SVT Play"

  Scenario: Search and access news category
    Given Webpage is avaliable
    When user visits SVT Play
    Then user click news category and pagetitle should be "NYHETER"

  Scenario: Verify contact page is avaliable
    Given Webpage is avaliable
    When user visits SVT Play
    Then user click contact me page and pagetitle should be "Kontakta oss | SVT Kontakt"

  Scenario: Verify contact email address is correct
    Given Webpage is avaliable
    When user visits SVT Play contact me page
    Then Email address should be "kontakt@svt.se"

