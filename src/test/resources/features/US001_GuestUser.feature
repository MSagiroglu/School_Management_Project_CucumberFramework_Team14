@US_01
Feature: US001 Aday ogrenciler sisteme kayit olabilmelidir.
  @US_01_PS
  Scenario: TC_01 Aday ogrenciler sisteme kayit olabilmelidir.
    Given Guest User Anasayfada register butonuna tiklar
    When Guest User Register sayfasındaki gerekli alanları doldurur.
    Then Aday ogrncinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.
  @US_01_NS
  Scenario: TC_02 Aday ogrenciler sisteme name girmeden kayit olamamalidir.
    Given Guest User Anasayfada register butonuna tiklar
    When Guest User Register sayfasındaki gerekli datayi "name" girmeden alanları doldurur.
    Then Aday ogrncinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.
