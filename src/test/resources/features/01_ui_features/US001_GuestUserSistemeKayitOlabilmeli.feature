@All @US01vice
Feature: US001 Aday ogrenciler sisteme kayit olabilmelidir.

  Background:
    Given Guest User Anasayfada register butonuna tiklar

  @US_01_PS @US_02 @pozitifApi
  Scenario: TC_01 Aday ogrenciler sisteme kayit olabilmelidir.
    When Guest User Register sayfasındaki gerekli alanları doldurur.
    Then Aday ogrencinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.




  @US_01_NS @NS01 @1
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
  Scenario: TC_07 Aday ogrenciler sisteme kayit olurken Phone number kismina karakter olarak harf girerse kayit  olamamalidir.
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

  @US_01_NS @NS12
  Scenario: TC_13 Aday ogrenciler sisteme Ssn Numberı 11 haneden az girerek kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Ssn Number tam karakter" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS13
  Scenario: TC_14 Aday ogrenciler sisteme Ssn Numberı 11 haneden fazla girerek kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  "Ssn Number fazla karakter" ile girerek alanları doldurur.
    Then Aday ogrencinin "Ssn Number 11'den fazla karakter" dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.

  @US_01_NS @NS14
  Scenario: TC_15 Aday ogrenciler sisteme kayit olurken Ssn number kismina karakter olarak harf girerse kayit  olamamalidir.
    When Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  "Ssn number'da  rakamdan farkli karakter" ile girerek alanları doldurur.
    Then Aday ogrencinin "Ssn Number'a harf ile girer" dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.

  @US_01_NS @NS15
  Scenario: TC_16 Aday ogrenciler sisteme User Name girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "User Name" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS16
  Scenario: TC_17 Aday ogrenciler sisteme daha önce kayit olunan User Name ile kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datalari daha once kullanilmis  bir data  "Registered User Name" ile girerek alanları doldurur.
    Then Aday ogrencinin kaydinin  daha once kullanilmiş bir data "Registered User Name" ile gerceklesmedigi dogrulanir.

  @US_01_NS @NS17
  Scenario: TC_18 Aday ogrenciler sisteme Password girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Password" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS18
  Scenario: TC_19 Aday ogrenciler sisteme Passwod'i 8 karakterden az girerek kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Password 8 karakter" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS19
  Scenario: TC_20 Aday ogrenciler sisteme Passwod'e buyuk harf girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Password'e buyuk harf" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS20
  Scenario: TC_21 Aday ogrenciler sisteme Passwod'e kucuk harf girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Password'e kucuk harf" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.

  @US_01_NS @NS21
  Scenario: TC_22 Aday ogrenciler sisteme Passwod'e rakam girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Password'e rakam" girmeden alanları doldurur.
    Then Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.