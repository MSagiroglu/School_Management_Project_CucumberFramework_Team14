Feature: Vice Dean Ders Olusturma
  Background: Login islemleri
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar
    Given lessons butonuna tiklar



  @US09_TC01
  Scenario: US09_TC01_DersListesiniGorebilme
    And Vice Dean Lesson Name alanini gorur.
#    And VD Compulsory alanini  gorur.
#    And VD Credit Score alanini gorur.
#    Then  Lesson List alanini gordugunu dogrular.
#    And kullanici sayfayi kapatir
#
#  @US09_TC02
#  Scenario: US09_TC02_DersSilme
#    And VD en son sayfaya gider
#    And VD ders siler
#    Then VD dersin silindigini dogrular
#    And kullanici sayfayi kapatir


