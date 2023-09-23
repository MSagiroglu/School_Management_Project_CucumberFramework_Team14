Feature: US_08 US-09 Vice Dean Ders Olusturma E2E Testi
@viceDean
  Scenario: TC01 API Vice Dean ders olusturabilmelidir.
    Given  kulanici api icin base url olusturur
    And kullanici expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir lesson olusturur
    Then kullanici dogrulama yapar

  @UI
    Scenario: TC02 UI Vice Dean ders görebilmeli.
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar
    Given lessons butonuna tiklar

