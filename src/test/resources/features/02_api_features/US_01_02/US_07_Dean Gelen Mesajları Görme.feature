@US07_api

Feature: Dean kullanicilarin gönderdiği tüm mesajlari görebilmeli
  Scenario Outline:US07 Gelen mesajlari dogrulama
    Given Get Request ile gelen tüm mesajlari al
   Then Body dogrulama : name="<Name>",email="<Email>",subject="<Subject>",message="<Message>",date="<Date>"
    Examples:
    |  Name  |  Email                |   Subject       |Message                    | Date         |
    |  Sema  |semamalkoc01@gmail.com |   Ders_Saati    |Ders_Saati_10'da_mi?       | 2023-09-15   |

