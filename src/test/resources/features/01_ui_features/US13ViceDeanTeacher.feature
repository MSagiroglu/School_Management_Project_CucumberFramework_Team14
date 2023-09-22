@UI
Feature: US_13 Vice Dean Ogretmen Olusturma

  Background:
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "teacherManagementMenu"

  @US13TC01
  Scenario: TC_01 Ogretmen kaydi yapilabilmelidir
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

  @US13TC02
  Scenario: TC_02 Ders secimi yapilmadan kayit olunamamalidir
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

  @US13TC03
  Scenario: TC_03 Name girilmeden kayit olunamamalidir
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

  @US13TC04
  Scenario: TC_04 Gecersiz (tek karakter) name ile kayit olunamamalidir
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

  @US13TC05
  Scenario: TC_05 Surname girilmeden kayit olunamamalidir
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

  @US13TC06
  Scenario: TC_06 Birth Place girilmeden kayit olunamamalidir
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

  @US13TC07
  Scenario: TC_07 Email girilmeden kayit olunamamalidir
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

  @US13TC08
  Scenario: TC_08 Gecersiz email (5 karakter altinda) ile kayit olunamamalidir
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

  @US13TC09
  Scenario: TC_09 Gecersiz email ('@' iceren gecersiz deger) ile kayit olunamamalidir
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

  @US13TC10
  Scenario: TC_10 Phone girilmeden kayit olunamamalidir
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

  @US13TC11
  Scenario: TC_11 Gecersiz phone (12 karakterden az) ile kayit olunamamalidir
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

  @US13TC12
  Scenario: TC_12 Is Advisor Teacher secilerek kayit olusturulabilmelidir
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

  @US13TC13
  Scenario: TC_13 Gender secilmeden kayit olunamamalidir
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

  @US13TC14
  Scenario: TC_14 Date of birth girilmeden kayit olunamamalidir
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

  @US13TC15
  Scenario: TC_15 Gecersiz date of birth (gelecek zaman) ile kayit olunamamalidir
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

  @US13TC16
  Scenario: TC_16 SSN girilmeden kayit olunamamalidir
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

  @US13TC17
  Scenario: TC_17 Gecersiz SSN (- icermeyen) ile kayit olunamamalidir
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

  @US13TC18
  Scenario: TC_18 Gecersiz SSN (11 karakter altinda deger) ile kayit olunamamalidir
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

  @US13TC19
  Scenario: TC_19 Username girilmeden kayit olunamamalidir
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

  @US13TC20
  Scenario: TC_20 Password girilmeden kayit olunamamalidir
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

  @US13TC21
  Scenario: TC_21 Gecersiz password (8 karakterden az deger) ile kayit olunamamalidir
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

  @US13TC22
  Scenario: TC_22 Gecersiz password (numara icermeyen deger) ile kayit olunamamalidir
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

  @US13TC23
  Scenario: TC_23 Gecersiz password (kucuk harf icermeyen deger) ile kayit olunamamalidir
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

  @US13TC24
  Scenario: TC_24 Gecersiz password (buyuk harf icermeyen deger) ile kayit olunamamalidir
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
    And enter specific "abcd1324" to "password"
    And click to "submit"
    And warning for "passwordOneUpperCaseCharacter"
    Then quit driver

  @US13TC25
  Scenario: TC_25 Birden fazla ders secilebilmelidir
    And choose a lesson
    And choose lessons
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

  @US13TC26
  Scenario: TC_26 Is Advisor Teacher secilebilmelidir
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
    And is advisor teacher
    Then quit driver

  @US13TC27
  Scenario: TC_27 Gecersiz name (sayisal deger iceren) ile kayit olunamamalidir
    And choose a lesson
    And enter specific "123" to "name"
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



























