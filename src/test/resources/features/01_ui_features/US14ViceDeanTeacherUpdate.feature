Feature: US_14_Ogretmen_Guncelleme

  Background:
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "teacherManagementMenu"

  Scenario: tc01_Name_PhoneNumber_SSN_UserName_Goruntulenmeli
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And go to "tableUp" page
    And go to "down" page
    And go to "down" page
    And go to "down" page
    And bekle 2 saniye
    Then click to "lastPageButton"
    And go to "up" page
    And confirm "name"
    And bekle 2 saniye
    And confirm "phoneNumber"
    And bekle 2 saniye
    And confirm "SSN"
    And bekle 2 saniye
    And confirm "userName"
    And quit driver


    Scenario: tc02_Teacher_Update
      And click to "editButton"
      And choose a lesson
      And enter random "name"
      And enter random "surname"
      And enter random "birthPlace"
      And enter random "email"
      And enter random "phoneNumber"
      And enter random "SSN"
      And click to "gender"
      And enter random "dateOfBirth"
      And enter random "userName"
      And enter random "password"
      And click to "submit"
      And warning for "teacherUpdatedSuccessfulMessage"
      And quit driver

















