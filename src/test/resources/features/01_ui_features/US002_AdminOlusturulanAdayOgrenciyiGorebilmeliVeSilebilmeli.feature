@UI
Feature: US_002 Admin OlusturulanAday Ogrenciye ait bilgileri gorebilmeli ve silebilmeli


  @UIPositive
  Scenario: TC_01 Admin aday ogrenciye ait bilgileri gorebilmeli
    Given Kullanici Admin olarak giris yapar.
    When Admin Guest User Sayfasina giris yapar
    Then Admin Kayıt olan Guest user'a ait bilgileri görebilir.
    #And Site kapatilir.

  @UIPositive
  Scenario: TC_02 Admin aday ogrenciye ait bilgileri  silebilmeli
    Given Kullanici Admin olarak giris yapar.
    When Admin Guest User Sayfasina giris yapar
    Then Admin Kayıt olan Guest user'a ait bilgileri silebilir.
