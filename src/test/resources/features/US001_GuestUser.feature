@US_01
Feature: US001 Aday ogrenciler sisteme kayit olabilmelidir.
  Background:
    Given Guest User Anasayfada register butonuna tiklar

  @US_01_PS
  Scenario: TC_01 Aday ogrenciler sisteme kayit olabilmelidir.
    When Guest User Register sayfasındaki gerekli alanları doldurur.
    Then Aday ogrencinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.

  @US_01_NS @NS01
  Scenario: TC_02 Aday ogrenciler sisteme name girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "name" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS02
  Scenario: TC_03 Aday ogrenciler sisteme Surname girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Surname" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS03
  Scenario: TC_04 Aday ogrenciler sisteme Birth place girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Birth place" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS04
  Scenario: TC_05 Aday ogrenciler sisteme Phone number girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "phone number" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS05
  Scenario: TC_06 Aday ogrenciler sisteme daha önce kayit olunan Phone number ile kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalari daha once kullanilmis  bir data  "Registered phone" ile girerek alanları doldurur.
    Then Aday ogrencinin kaydinin  daha once kullanilmiş bir data "Registered phone" ile gerceklesmedigi dogrulanir.

  @US_01_NS @NS06
  Scenario: TC_07 Aday ogrenciler sisteme kayit olurken Phone number kismina olaral harf girerse kayit  olamamalidir.
    When Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  "Phone number'da  rakamdan farkli karakter" ile girerek alanları doldurur.
    Then Aday ogrencinin "Phone Number" dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.


  @US_01_NS @NS07
  Scenario: TC_08 Aday ogrenciler sisteme birth date girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "birth date" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS08
  Scenario: TC_09 Aday ogrenciler sisteme birth date olarak gecmis bir tarih girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  "gecmis olamyan bir tarih" ile girerek alanları doldurur.
    Then Aday ogrencinin "birth date" dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.

  @US_01_NS @NS09
  Scenario: TC_10 Aday ogrenciler sisteme Ssn Number girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Ssn Number" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS10
  Scenario: TC_11 Aday ogrenciler sisteme daha önce kayit olunan SSn number ile kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalari daha once kullanilmis  bir data  "Registered Ssn Number" ile girerek alanları doldurur.
    Then Aday ogrencinin kaydinin  daha once kullanilmiş bir data "Registered Ssn Number" ile gerceklesmedigi dogrulanir.

  @US_01_NS @NS11
  Scenario: TC_12 Aday ogrenciler sisteme Ssn numarasi alanına 9 haneli Ssn numarasina 3. ve 5. haneden sonra - disinda bir karakter girerse kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  "Ssn number'da  (-)'den farkli karakter" ile girerek alanları doldurur.
    Then Aday ogrencinin "Ssn Number" dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.
