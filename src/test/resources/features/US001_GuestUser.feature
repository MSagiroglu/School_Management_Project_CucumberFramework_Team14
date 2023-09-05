@US_01
Feature: US001
  Scenario: TC_01 Aday ogrenciler sisteme kayit olabilmelidir.
    Given Guest User Anasayfada register butonuna tiklar
    When Guest User Register sayfasındaki gerekli alanları doldurur.
    Then Aday ogrncinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.
