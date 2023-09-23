@E2E
Feature: US007_US016 ManegementonSchool Sayfasi E2E Testi

  @UI
  Scenario: US03 TC_01 UI Mesaj Gonderme
    Given kullanici Managementon School sayfasina gider
    Then kullanici Contact ikonuna tiklar
    And kullanici Name Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar
    And kullanici Contact Message Created Successfully textinin gorundugunu dogrular

  @viceDean
  Scenario Outline:US16 TC_03 API Gelen mesajlari dogrulama
    Given Get Request ile gelen tüm mesajlari al
    Then Body dogrulama : name="<Name>",email="<Email>",subject="<Subject>",message="<Message>",date="<Date>"
    Examples:
      | Name | Email                  | Subject    | Message              | Date       |
      | Sema | semamalkoc01@gmail.com | Ders_Saati | Ders_Saati_10'da_mi? | 2023-09-23 |


  @UI
  Scenario: US16 TC_02 UI Vice Dean Kullanıcıların Gönderdiği Mesajları Görebilmeli ve Silebilmeli
    Given kullanici Managementon School sayfasina gider ve login butonuna tiklar
    Then kullanici Vice Dean hesabiyla giris yapar
    And kullanici Menu ikonunu tiklar
    And kullanici Contact Get All textine tıklar
    And kullanici mesaj bilgilerinin gorundugunu dogrular
    #And kullanici silme ikonunun gorundugunu dogrular

  Scenario Outline: US16 TC_04 Kayitli mesajlari DB ile doğrulama
    Given Database e baglan
    When name ile kayitli mesajlari al "<Name>"
    Then ABody dogrulama : name="<Name>",email="<Email>",subject="<Subject>",message="<Message>",date="<Date>"
    Examples:
      | Name | Email                  | Subject    | Message              | Date       |
      | Sema | semamalkoc01@gmail.com | Ders_Saati | Ders_Saati_10'da_mi? | 2023-09-15 |

