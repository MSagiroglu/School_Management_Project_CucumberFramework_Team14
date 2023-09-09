
@us13ui

Feature: US_13_Ogretmen_Olusturma

  Background:
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "teacherManagementMenu"

  Scenario: tc_01_Ders_secimi
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
    And warning for "teacherSavedMessage"
    Then quit driver


  Scenario: tc_02_Ders_secimiN
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
    And warning for "dersSecilmedi"
    Then quit driver


  Scenario: tc_03_Name
    And choose a lesson
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
    And warning for "nameRequired"
    Then quit driver

  Scenario: tc_04_NameN
    And choose a lesson
    And enter specific "A" to "name"
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
    And warning for "invalidNameWarning"
    Then quit driver

  Scenario: tc_05_Surname
    And choose a lesson
    And enter random "name"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "surNameRequired"
    Then quit driver


  Scenario: tc_06_BirthPlace
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "birthPlaceRequired"
    Then quit driver


  Scenario: tc_07_Email
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "emailRequired"
    Then quit driver


  Scenario: tc_08_EmailN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter specific "ABC" to "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "emailShouldBe5_50"
    Then quit driver


  Scenario: tc_09_EmailN2
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter specific "2@34" to "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "pleaseEnterValidEmailMessage"
    Then quit driver


  Scenario: tc_10_Phone
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "phoneNumberRequired"
    Then quit driver

  Scenario: tc_11_PhoneN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter specific "123456" to "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "phoneNumber12Message"
    Then quit driver

  Scenario: tc_12_isAdvisorTeacher
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
    And click to "isAdvisorTeacher"
    And click to "submit"
    And warning for "teacherSavedMessage"
    Then quit driver

  Scenario: tc_13_Gender
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "invalidGender"
    Then quit driver

  Scenario: tc_14_DateOfBirth
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "dateOfBirthRequired"
    Then quit driver

  Scenario: tc_15_DateOfBirthN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter specific "21.04.2050" to "DateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "dogumGunuGecmisBirTarihOlmali"
    Then quit driver

  Scenario: tc_16_SSN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "sSNRequired"
    Then quit driver

  Scenario: tc_17_NSSN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter specific "12345678910" to "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "pleaseEnterValidSSNNumberMessage"
    Then quit driver

  Scenario: tc_18N2SSN
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter specific "123456789" to "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "userName"
    And enter random "password"
    And click to "submit"
    And warning for "ssnMin11Character"
    Then quit driver


  Scenario: tc_19_UserName
    And choose a lesson
    And enter random "name"
    And enter random "surname"
    And enter random "birthPlace"
    And enter random "email"
    And enter random "phoneNumber"
    And enter random "SSN"
    And enter random "dateOfBirth"
    And click to "gender"
    And enter random "password"
    And click to "submit"
    And warning for "usernameRequired"
    Then quit driver

  Scenario: tc_20Password
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
    And click to "submit"
    And warning for "passwordRequired"
    Then quit driver


  Scenario: tc_21PasswordN
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
    And enter specific "Abc123" to "password"
    And click to "submit"
    And warning for "passwordAtLeast8Characters"
    Then quit driver


  Scenario: tc_22PasswordN2
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
    And enter specific "Abcdefgh" to "password"
    And click to "submit"
    And warning for "passwordOneNumber"
    Then quit driver

  Scenario: tc_23PasswordN3
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
    And enter specific "ABCD1324" to "password"
    And click to "submit"
    And warning for "passwordOneLowerCaseCharacter"
    Then quit driver















