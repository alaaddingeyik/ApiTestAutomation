🎯 Proje Amacı
Bu proje ile: ✔ Restful Booker API'yi otomatik olarak test etmek
✔ CRUD işlemlerini doğrulamak (Create, Read, Update, Delete)
✔ Cucumber BDD ile davranış odaklı testler oluşturmak
✔ Allure Report ile detaylı test raporları almak
✔ Dynamic Booking ID kullanarak testlerin bağımsız olmasını sağlamak

🛠 Kullanılan Teknolojiler & Araçlar
Teknoloji / Kütüphane	Açıklama
Java	Test otomasyon dili
RestAssured	API testlerini yönetmek için kullanılan Java kütüphanesi
Cucumber BDD	Davranış Odaklı Test Çerçevesi
JUnit	Test doğrulamalarında kullanılan framework
Maven	Bağımlılık yönetimi ve build süreci için
Allure Reports	Test raporlama aracı
Gherkin	Cucumber ile BDD test senaryoları oluşturmak için

ApiTest
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   ├── BaseAPI.java
│   │   │   ├── utilities
│   │   │   │   ├── ApiUtils.java
│   ├── test
│   │   ├── java
│   │   │   ├── apiTests
│   │   │   │   ├── BookingAPI.java
│   │   │   ├── runners
│   │   │   │   ├── TestRunner.java
│   │   │   ├── stepDefinitions
│   │   │   │   ├── BookingSteps.java
│   │   │   ├── reports
│   │   │   ├── features
│   │   │   │   ├── ApiFeatures.feature
│── pom.xml
│── README.md
📌 Klasör Yapısının Açıklaması
📂 base/ → API temel yapılarını içeren BaseAPI sınıfı
📂 utilities/ → API isteklerini gönderen yardımcı sınıflar (ApiUtils.java)
📂 apiTests/ → Test sınıfları (BookingAPI.java)
📂 stepDefinitions/ → Cucumber senaryolarına karşılık gelen adımlar
📂 runners/ → Cucumber ve JUnit entegrasyonunu sağlayan test çalıştırıcı dosyalar
📂 features/ → .feature dosyaları (Cucumber senaryoları)
📜 pom.xml → Maven bağımlılıkları ve proje konfigürasyonu
📜 README.md → Proje hakkında detaylı bilgi

