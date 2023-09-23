Feature: US11 Api Testi
  @Us11Tc01Api @viceDean
  Scenario: TC01 Vice Dean ders programını görebilmeli ve güncellemeler yapabilmelidir.
    Given  kulanici lesson program api icin base url olusturur
    And kullanici lesson pragram expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir lesson program olusturur
    Then kullanici olusturdugu dersi programını görür
