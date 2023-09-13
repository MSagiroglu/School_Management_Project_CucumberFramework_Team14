@TC07
Feature: US007_US016 ManegementonSchool Sayfasi Testi
  Background:
    Given kullanici Managementon School sayfasina gider ve login butonuna tiklar

  Scenario:  US07 TC01 Dean Kullanıcıların Gönderdiği Mesajları Görebilmeli ve Silebilmeli
    Then kullanici Dean hesabiyla giris yapar
    And kullanici Menu ikonunu tiklar
    And kullanici Contact Get All textine tıklar
    And kullanici mesaj bilgilerinin gorundugunu dogrular
    And kullanici silme ikonunun gorundugunu dogrular

    Scenario: US16 TC001 Vice Dean Kullanıcıların Gönderdiği Mesajları Görebilmeli ve Silebilmeli
      Then kullanici Vice Dean hesabiyla giris yapar
      And kullanici Menu ikonunu tiklar
      And kullanici Contact Get All textine tıklar
      And kullanici mesaj bilgilerinin gorundugunu dogrular
      And kullanici silme ikonunun gorundugunu dogrular
