@All
Feature:  US15 Vice Dean Ogrenci olusturabilme Testi
  Background:
    Given kullanici Managementonschools sayfasina gider

  @TC01
  Scenario: TC01 kullanici Vise Dean olarak ogrenci olusturabilmeli
    * kullanici login butonuna tiklar
    * kullanici admin olarak giris yapar
    * kullanici menu butonuna tiklar
    * kullanici Student Management butonuna tiklar
    * kullanici danisman ogretmeni secer
    * ogrenci kaydinin gerceklestigi dogrulanir
    * kullanici yeniden menu butonuna tiklar
    * kullanici logout butonuna tiklar ve cikis yapar
    * kullanici sayfayi kapatir

  @TC02
  Scenario: TC02 "Name" girilmeden kayit olunmamali
    * kullanici name yazmadan tum bilgileri girer

  @TC03
  Scenario: TC03 "Surname" girilmelden kayit olunmamali
    * kullanici surname yazmadan bilgileri girer

  @TC04
  Scenario: TC04 "Birth Place" girilmedene kayit olunamamli
    * kullanici birth place yazmadan bilgileri girer

  @TC05
  Scenario: TC05 E-mail girilmeden kayit olunamamali
    * kullanici birth email yazmadan bilgileri girer

  @TC06
  Scenario: TC06 Telefon numarası girilmeden kayit olunamamali
    * kullanici birth telefon numarasi yazmadan bilgileri girer

  @TC07
  Scenario: TC07 Cinsiyet seçilmeden kayit olunamamali
    * kullanici birth cinsiyeti secmeden bilgileri girer

  @TC08
  Scenario: TC08 Doğum tarihi girilmeden kayit olunamamali
    * kullanici dogum tarihini girmeden bilgileri girer

  @TC09
  Scenario: TC09 SSN girilmeden ve SSN; ucuncu ve besinci rakamdan sonra "-" içermeden kayit olunamamali
    * kullanici ucuncu ve besinci rakamdan sonra cizgi içermeyen SSN bilgileri girmeden bilgileri girer

  @TC10
  Scenario: TC010 SSN girilmeden ve SSN; ve dokuz rakamdan oluşmadan kayit olunamamali
    * kullanici gerekli sartlari yerine getirmeden bilgileri girer

  @TC11
  Scenario: TC11 User Name girilmeden kayit olunamamali
    * kullanici user name girmeden bilgileri girer

  @TC12
  Scenario: TC12 Father Name girilmeden kayit olunamamali
    * kullanici father name girmeden bilgileri girer

  @TC13
  Scenario: TC13 Mother Name girilmeden kayit olunamamali
    * kullanici mother name girmeden bilgileri girer

  @TC14
  Scenario: TC14 Password en az sekiz karakterden oluşmadan kayit olunamamali
    * kullanici passwordu en az sekiz karakterden olusturmadan bilgileri girer

  @TC15
  Scenario: TC15 Password büyük harf, küçük harf ve bir rakam içermeden kayit olunamamali
    * kullanici passwordu buyuk harf kucuk harf ve bir rakam icermeden bilgileri girer













