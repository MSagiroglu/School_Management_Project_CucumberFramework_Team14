Feature: US22 Api Testi
  @Us22Tc01Api
  Scenario: TC01 Post ile Admin Ekleme Testi
    Given Admin eklemek icin Post request hazirligi yapilir
    And Gonderilecek Admin bilgileri hazirlanir
    When Admin eklemek icin Post request gonderilir
    Then Admin Bilgileri dogrulanir
