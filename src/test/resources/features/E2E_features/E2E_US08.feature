Feature: US_08 US-09 Vice Dean Ders Olusturma E2E Testi
  @viceDean
  Scenario: Ui ile lesson olusturma
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar
    Given lessons butonuna tiklar
    And lesson kutucuguna tiklar
    And lesson kutucuguna ders adi girer
    And Zorunlu ders ise kısmını isaretler
    And Credit Score name kutucuğuna tıklar
    And submit_butonuna_tiklar

  @API
  Scenario: Api ile olusan dersi cagirma
    Given lessonname ile get yapilir
    Then dogrulama yapilir

  Scenario: Database ile dersi dogrulama
    Given Lesson Database bilgileri icin baglantı kurulur.
    And lessonname ile statement olustur
    Then db dogrula yapilir


