@Us23
  Feature: US23 Admin Vice Dean Ekleyebilmeli
    @Us23Tc01
    Scenario: TC01 Admin ile Vice Dean Ekleme
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      And admin submit butonuna basar
      Then admin vice deanin eklenip eklenmedigini dogrular

    @Us23Tc02
    Scenario: TC02 Yanlış Telefon No ve Kayıtlı Telefon No ile Vice Dean Ekleyememe
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      Then admin vice dean telefon verilerini yanlis girer ve hata mesajlarini dogrular

    @Us23Tc03
    Scenario: TC03 Yanlış Ssn No ve Kayıtlı Ssn No ile Vice Dean Ekleyememe
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      Then admin vice dean ssn verilerini yanlis girer ve hata mesajlarini dogrular

    @Us23Tc04
    Scenario: TC04 Gelecek tarihli Date Of Birth ile Vice Dean Ekleyememe
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      Then admin vice dean dogum tarihini ileri bir tarih girer ve hata mesajini dogrular

    @Us23Tc05
    Scenario: TC05 Kayıtlı Username ile Vice Dean Ekleyememe
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      Then admin vice dean username e kayitli username girer ve hata mesajini dogrular

    @Us23Tc06
    Scenario: TC06 Uygun password ile Vice Dean ekleme
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      And admin vice dean eklemek icin verilen bilgileri girer
      Then admin vice dean eklemek icin uygun olmayan passwordlar girer hata mesajlarini dogrular
      And admin vice dean eklemek icin uygun bir password ile admin ekler ve dogrular

    @Us23Tc07
    Scenario: TC07 Boş bırakılan alanlarla Vice Dean ekleyememe
      Given admin login olur
      When admin menuye tiklar ve ardindan vice dean managementa tiklar
      When admin vice dean eklemek icin veri girilecek alanlari bos birakir ve hata mesajlarini dogrular sonra gender haric verileri girer
      And admin submit butonuna basar
      Then admin cikis yapip girdigi verilerle vice dean olarak login olmayi dener ve hata alip dogrular









