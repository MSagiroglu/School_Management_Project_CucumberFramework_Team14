@apiTest
Feature: Mesaj Gönderme Testi
  Scenario: Basarili bir sekilde mesaj gonderilebilmeli
    Given Mesaj gondermek icin Post request hazirligi yapilir
    And Gonderilecek mesaj bilgileri hazırlanır
    When Mesaj eklemek icin Post request gonderilir
    Then Mesaj Bilgileri dogrulanir
  @US_03_apiNegative
  Scenario: Body de eksik data girerek "400 Bad Request Status Code" alma
    Given Mesaj gondermek icin Post request hazirligi yapilir
    And Gonderilecek mesaj bilgileri hazırlanır
    When Mesaj eklemek icin Post request gonderilir
    Then Dortyuz Bad Request Status Code dogrulanir

