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
    Then Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.

  @US_01_NS @NS02
  Scenario: TC_03 Aday ogrenciler sisteme Surname girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Surname" girmeden alanları doldurur.
    Then Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.

  @US_01_NS @NS03
  Scenario: TC_04 Aday ogrenciler sisteme Birth place girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "Birth place" girmeden alanları doldurur.
    Then Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.

  @US_01_NS @NS04
  Scenario: TC_05 Aday ogrenciler sisteme Phone number girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "phone number" girmeden alanları doldurur.
    Then Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.

  @US_01_NS @NS05
  Scenario: TC_06 Aday ogrenciler sisteme birth date girmeden kayit olamamalidir.
    When Guest User Register sayfasındaki gerekli datayi "birth date" girmeden alanları doldurur.
    Then Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.


