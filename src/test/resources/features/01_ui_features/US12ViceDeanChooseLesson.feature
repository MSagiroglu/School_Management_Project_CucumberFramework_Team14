@UI

Feature: US_12_Ders_Secme

  @US12TC01
  Scenario: tc01_dersSecme
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "lessonManagementMenu"
    And bekle 3 saniye
    And click to "lessonProgramButton"
    And Vice Dean choose lesson
    And Vice Dean choose teacher
    And warning for "lessonAddedMessage"
    And quit driver

  @US12TC02
  Scenario: tc02_dersDogrulama
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "lessonManagementMenu"
    And bekle 3 saniye
    And click to "lessonProgramButton"
    And click to "lessonAssignmet"
    And warning for "lesson"
    And quit driver


