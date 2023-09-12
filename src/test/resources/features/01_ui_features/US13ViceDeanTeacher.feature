@us13ui
Feature: US_13 Vice Dean Ogretmen Olusturma

  Background:
    Given Vice Dean olarak giris yapar
    And click to "menu"
    And click to "teacherManagementMenu"

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

























