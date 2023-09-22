@US16_api
Feature:Vice Dean kullanicilarin gönderdiği tüm mesajlari görebilmeli
  Scenario Outline:US16 Gelen mesajlari dogrulama
    Given Get Request ile gelen tüm mesajlari al
    Then Body dogrulama : name="<Name>",email="<Email>",subject="<Subject>",message="<Message>",date="<Date>"
    Examples:
      |  Name  |  Email                |   Subject       |Message                    | Date         |
      |  Sema  |semamalkoc01@gmail.com |   Ders_Saati    |Ders_Saati_10'da_mi?       | 2023-09-15   |



    @US_16_DB
    Scenario Outline: Kayitli mesajlari DB ile doğrulama
      Given Database e baglan
      When name ile kayitli mesajlari al "<Name>"
      Then ABody dogrulama : name="<Name>",email="<Email>",subject="<Subject>",message="<Message>",date="<Date>"
      Examples:
        |  Name  |  Email                |   Subject       |Message                    | Date         |
        |  Semanur Malkoç Karakaya  |semamalkoc01@gmail.com |   Ders_Saati    |Ders_Saati_10'da_mi?       | 2023-09-15   |

