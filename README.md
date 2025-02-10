# 🚀 ApiTestAutomation - RESTful API Test Otomasyonu

Bu proje, **Restful Booker API**'sini otomatik olarak test etmek için geliştirilmiş bir **API Test Otomasyonu** framework'üdür. **RestAssured, Cucumber BDD, JUnit ve Maven** gibi popüler test araçları kullanılarak API testleri oluşturulmuştur.

---

## 🎯 Proje Amacı

✅ REST API'leri otomatik olarak test etmek  
✅ CRUD işlemlerini doğrulamak (**Create, Read, Update, Delete**)  
✅ **Cucumber BDD** ile davranış odaklı testler oluşturmak  
✅ **Allure Report** ile detaylı test raporları almak  
✅ **Dynamic Booking ID** kullanarak testlerin bağımsız olmasını sağlamak  

---

## 🛠 Kullanılan Teknolojiler & Araçlar

| Teknoloji | Açıklama |
|-----------|---------|
| ☕ **Java** | Test otomasyon dili |
| 🔗 **RestAssured** | API testlerini yönetmek için |
| 🌱 **Cucumber BDD** | Davranış Odaklı Test Çerçevesi |
| 📌 **JUnit** | Test doğrulama framework'ü |
| ⚙️ **Maven** | Bağımlılık yönetimi ve build süreci |
| 📊 **Allure Reports** | Test raporlama aracı |

---

## 📂 Proje Yapısı


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


📌 **Açıklamalar:**  
- `base/` → API temel yapılarını içeren `BaseAPI` sınıfı  
- `utilities/` → API isteklerini gönderen yardımcı sınıflar (`ApiUtils.java`)  
- `apiTests/` → Test sınıfları (`BookingAPI.java`)  
- `stepDefinitions/` → Cucumber senaryolarına karşılık gelen adımlar  
- `runners/` → Cucumber ve JUnit entegrasyonunu sağlayan test çalıştırıcı dosyalar  
- `features/` → `.feature` dosyaları (**Cucumber senaryoları**)  
- `pom.xml` → **Maven bağımlılık ve proje konfigürasyonu**  
- `README.md` → **Proje hakkında detaylı bilgi**  




