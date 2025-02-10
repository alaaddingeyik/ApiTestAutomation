Feature: Booking API Testleri

  Scenario: Yetkilendirme al
    Given Kullanıcı API için yetkilendirme alır
    Then Yetkilendirme başarılı olmalıdır

  Scenario: Rezervasyon bilgilerini al
    When Kullanıcı "/booking" endpointine GET isteği gönderir
    Then Yanıt kodu 200 olmalıdır

  Scenario: Yeni rezervasyon oluştur
    When Kullanıcı "/booking" endpointine şu verilerle POST isteği gönderir:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Ali       | gazi     | 150        | true        | 2024-01-01 | 2024-01-05 | Breakfast       |
      | Mehmet    | eq      | 200        | false       | 2024-02-01 | 2024-02-10 | Lunch           |
    Then Yanıt kodu 200 olmalıdır

  Scenario: Rezervasyonu güncelle (PUT)
    Given Kullanıcı geçerli bir "token" alır
    When Kullanıcı "/booking/{bookingId}" endpointine şu verilerle PUT isteği gönderir:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Mehmet    | Canan    | 200        | false       | 2024-02-01 | 2024-02-10 | Lunch           |
    Then Yanıt kodu 200 olmalıdır

  Scenario: Rezervasyon bilgilerini kısmi güncelle (PATCH)
    Given Kullanıcı geçerli bir "token" alır
    When Kullanıcı "/booking/{bookingId}" endpointine şu verilerle PATCH isteği gönderir:
      | lastname |
      | Aslan    |
    Then Yanıt kodu 200 olmalıdır

  Scenario: Rezervasyonu sil
    When Kullanıcı "/booking/{bookingId}" endpointine DELETE isteği gönderir
    Then Yanıt kodu 201 olmalıdır
