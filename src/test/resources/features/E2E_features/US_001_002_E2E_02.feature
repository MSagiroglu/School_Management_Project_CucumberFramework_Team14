
Feature: US_01 Guest User (Post Request) Ekleme E2E Testleri

  @admin
  Scenario: TC_01 API ve Database Guest User basarili bir sekilde eklenebilmeli
    Given Guest User eklemek icin Post request hazirligi yapilir
    And Gonderilecek Guest User bilgileri hazırlanır
    When Guest User eklemek icin Post request gonderilir
    Then Guest User Post Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.

  @UI
  Scenario: TC_02 UI Admin aday ogrenciye ait bilgileri gorebilmeli
    Given Kullanici Admin olarak giris yapar.
    When Admin Guest User Sayfasina giris yapar
    Then Admin Kayıt olan Guest user'a ait bilgileri görebilir.

  @admin
  Scenario: TC_01 Admin oluşturulan guest usera Get request yapma ve Database sorgulama
    Given Guest User icin Get request hazirligi yapilir
    And Sorgulanacak Guest User bilgileri hazırlanır
    When Sorgulamak icin Get request gonderilir
    Then Guest User Get Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.

  @UI
  Scenario: TC_03 UI Admin aday ogrenciye ait bilgileri  silebilmeli
    Given Kullanici Admin olarak giris yapar.
    When Admin Guest User Sayfasina giris yapar
    Then Admin Kayıt olan Guest user'a ait bilgileri silebilir.