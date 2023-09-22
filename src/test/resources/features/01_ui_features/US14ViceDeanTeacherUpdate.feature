
@UI
Feature: US_14_Ogretmen_Guncelleme

  Background:
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "teacherManagementMenu"

  @US14TC01
  Scenario: tc01_Name_PhoneNumber_SSN_UserName_Goruntulenmeli

    And go to "tableUp" page
    And bekle 2 saniye
    And confirm "name"
    And bekle 2 saniye
    And confirm "phoneNumber"
    And bekle 2 saniye
    And confirm "SSN"
    And bekle 2 saniye
    And confirm "userName"
    And quit driver

  @US14TC02
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

















