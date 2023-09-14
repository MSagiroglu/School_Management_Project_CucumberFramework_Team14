@111
Feature: US_002 Admin OlusturulanAday Ogrenciye ait bilgileri gorebilmeli ve silebilmeli

  Background:
    Given Kullanici Admin olarak giris yapar.
  @pozitifApi
  Scenario: TC_01 Admin aday ogrenciye ait bilgileri gorebilmeli ve silebilmeli
    Given Admin Guest User Sayfasina giris yapar
    And Admin Kayıt olan Guest user'a ait bilgileri görebilir.