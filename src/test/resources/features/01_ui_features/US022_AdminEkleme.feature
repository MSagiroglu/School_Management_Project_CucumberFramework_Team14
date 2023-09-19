@UI @Us22
Feature: US22 Admin Ekleme
  @Us22Tc01
  Scenario: TC01 Admin Ekleme
    Given admin login olur
    When admin verilen bilgileri girer
    And admin submit butonuna basar
    Then admin adminin eklenip eklenmedigini dogrular

  @Us22Tc02
  Scenario: TC02 Yanlış Telefon No ve Kayıtlı Telefon No ile Admin Ekleyememe
    Given admin login olur
    When admin verilen bilgileri girer
    Then admin telefon verilerini yanlis girer ve hata mesajlarini dogrular

  @Us22Tc03
  Scenario: TC03 Yanlış Ssn No ve Kayıtlı Ssn No ile Admin Ekleyememe
    Given admin login olur
    When admin verilen bilgileri girer
    Then admin ssn verilerini yanlis girer ve hata mesajlarini dogrular

  @Us22Tc04
  Scenario: TC04 Gelecek tarihli Date Of Birth ile Admin Ekleyememe
    Given admin login olur
    When admin verilen bilgileri girer
    Then admin dogum tarihini ileri bir tarih girer ve hata mesajini dogrular

  @Us22Tc05
  Scenario: TC05 Kayıtlı Username ile Admin Ekleyememe
    Given admin login olur
    When admin verilen bilgileri girer
    Then admin kayitli username girer ve hata mesajini dogrular

  @Us22Tc06
  Scenario: TC06 Uygun password ile admin ekleme
    Given admin login olur
    When admin verilen bilgileri girer
    Then admin uygun olmayan passwordlar girer hata mesajlarini dogrular
    And admin uygun bir password ile admin ekler ve dogrular

  @Us22Tc07
  Scenario: TC07 Boş bırakılan alanlarla admin ekleyememe
    Given admin login olur
    When admin veri girilecek alanlari bos birakir ve hata mesajlarini dogrular sonra gender haric verileri girer
    And admin submit butonuna basar
    Then admin cikis yapip girdigi verilerle login olmayi dener ve hata alip dogrular


















