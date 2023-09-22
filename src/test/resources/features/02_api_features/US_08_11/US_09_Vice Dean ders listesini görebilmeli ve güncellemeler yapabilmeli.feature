Feature: US09 Api Testi
  @Us09Tc01Api
  Scenario: TC01 Vice Dean ders olusturabilmelidir.
    Given  kulanici api icin base url olusturur
    And kullanici expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir lesson olusturur
    Then kullanici olusturdugu dersi görür