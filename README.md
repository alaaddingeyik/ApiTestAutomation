📱 AkakceTest - Mobil Uygulama Test Otomasyonu
Bu proje, Akakce mobil uygulamasının belirli fonksiyonlarını test eden Appium, Selenium, Cucumber ve TestNG tabanlı bir mobil test otomasyon framework'üdür.
Projede, JUnit, WebDriverManager, Maven ve Cucumber BDD kullanılarak testler yazılmıştır.

📌 Proje Amacı
Bu proje ile: ✔ Akakce mobil uygulamasında arama işlemi gerçekleştirerek, kullanıcıların ürünleri filtreleme ve sıralama sürecini test etmek
✔ Belirtilen bir ürünün satıcı detaylarını görüntüleme ve doğrulama işlemlerini test etmek
✔ Test senaryolarını BDD formatında Cucumber ile yönetmek ve raporlamak

Tüm testler Cucumber BDD formatında yazılmış olup Scenario-Driven Testing yaklaşımı uygulanmıştır.

🛠 Kullanılan Teknolojiler & Araçlar
Teknoloji / Kütüphane	Açıklama
Java	Test otomasyon dili
Appium	Mobil uygulama otomasyon aracı
Selenium	Web elementlerini yönetmek için
Cucumber BDD	Davranış Odaklı Test Çerçevesi
TestNG	Test çalıştırıcı framework
Maven	Bağımlılık yönetimi
Extent Reports	Test raporlama aracı
📂 Proje Yapısı
css
Kopyala
Düzenle
AkakceTest
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── AkakceHomePage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── SearchPage.java
│   │   │   │   └── BasePage.java
│   │   │   ├── util
│   │   │   │   ├── DriverFactory.java
│   │   │   │   ├── ElementHelper.java
│   │   │   │   └── ConfigReader.java
│   ├── test
│   │   ├── java
│   │   │   ├── stepDefinitions
│   │   │   │   ├── AkakceSteps.java
│   │   │   │   ├── ProductSteps.java
│   │   │   │   └── SearchSteps.java
│   │   │   ├── runners
│   │   │   │   ├── TestRunner.java
│   │   │   ├── reports
│   │   │   ├── features
│   │   │   │   ├── akakce_test.feature
│── pom.xml
│── README.md
📌 Açıklamalar
📂 pages/ → Test edilen uygulamanın farklı sayfalarını temsil eden Page Object Model (POM) yapısı
📂 util/ → Yardımcı metotlar ve yapılandırma dosyaları
📂 stepDefinitions/ → Cucumber senaryolarına karşılık gelen adımlar
📂 runners/ → TestNG ve Cucumber entegrasyonunu sağlayan Test Runner dosyaları
📂 features/ → Cucumber .feature dosyaları
📜 pom.xml → Maven bağımlılıkları ve proje konfigürasyonu
📜 README.md → Proje hakkında detaylı bilgi