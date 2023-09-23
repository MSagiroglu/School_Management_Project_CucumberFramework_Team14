@US15Api
Feature: Ogrenci Ekleme Tesi

  Scenario: Ogrenci basarili bir sekilde eklenebilmeli
    Given Ogrenci eklemek icin Post request hazirligi yapilir
    And Gonderilecek ogrenci bilgileri hazirlanir
    When Ogrenci eklemek icin Post request gonderilir
    Then Ogrenci bilgileri dogrulanir

  @15DB
  Scenario Outline: Ogrenci Olusturabilme Kaydinin DataBase ile dorgulanmasi
    Given ogrenci kaydi icn DataBase baglan
    When username "<username>" ile ogrenci bilglerini getir
    Then bodynin ilgili bilgileri icerdigini dogrula: name "<name>", surname "<surname>", birthplace "<birthplace>", email "<email>", phone "<phone>", gender "<gender>", dateofbirth "<dateofbirth>", ssn "<ssn>", username "<username>", fathername "<fathername>", mothername "<mothername>", password "<password>"
    Examples:
      | username    | name | surname | birthplace | email                | phone        | gender | dateofbirth | ssn         | username | fathername | mothername | password  |
      | IlyaRepin14 | Ilya | Repin   | USSR       | korey.hand@gmail.com | 286-694-7546 | male   | 1975-11-11  | 625-23-5065 | Ilya     | Anton      | Mariya     | Izmir.*35 |





