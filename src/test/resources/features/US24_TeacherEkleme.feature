@US_24
Feature: Admin sisteme Teacher ekleyebilmeli
  Background:
Given Admin kullanıcı sisteme giriş yapar.

    @US_24_PS
    Scenario: TC_01 Admin sisteme teacher kaydedebilmelidir
      Then Teacher ile ilgili gerekli bilgileri doldurur.
      And Olusturulan Teacher'ın sisteme kaydının gerçekleştirildiği doğrulanır.

      @_24_NS
      Scenario: TC_02 Teacher kaydı ders seçimi yapılmadan oluşturulamamalı
        Then Teacher ile ilgili bilgileri ders seçimi yapmadan doldurur.
        And Öğretmen kaydının oluşmadığını kontrol eder.
