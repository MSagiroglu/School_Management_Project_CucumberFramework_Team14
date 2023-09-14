@apiTest
Feature: Mesaj Gönderme Testi
  Scenario: Basarili bir sekilde mesaj gonderilebilmeli
    Given Mesaj gondermek icin Post request hazirligi yapilir
    And Gonderilecek mesaj bilgileri hazırlanır
    When Mesaj eklemek icin Post request gonderilir
    Then Mesaj Bilgileri dogrulanir