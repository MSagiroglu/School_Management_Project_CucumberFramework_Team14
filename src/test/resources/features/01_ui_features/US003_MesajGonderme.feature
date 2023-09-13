
Feature: US003 ManegementonSchool Sayfasi Testi
  Background:
    Given kullanici Managementon School sayfasina gider
    Then kullanici Contact ikonuna tiklar

   @pozitive
  Scenario: TC01 Mesaj Gonderme
    And kullanici Name Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar
    And kullanici Contact Message Created Successfully textinin gorundugunu dogrular

   @negative
    Scenario: TC02 Kullanıcı İsmi Olmadan Mesaj Gönderememe
      And kullanici Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar
      And kullanici Required uyarisinin gorundugunu dogrular


  Scenario: TC02 Mail Adresinde '@' ve '.' Kullanmadan Mesaj Gonderememe
    And kullanici Name Gecersiz Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar
    And kullanici Please enter Valid email textinin gorundugunu dogrular
    And kullanici sayfayi kapatir





