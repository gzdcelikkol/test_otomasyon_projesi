# 🚀 Test Otomasyon Projesi (BDD & Data-Driven Framework)

[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Gauge](https://img.shields.io/badge/Gauge-BDD-ff2d55?style=for-the-badge&logo=gauge&logoColor=white)](https://gauge.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.34.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![Maven](https://img.shields.io/badge/Apache%20Maven-3.8%2B-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure%20Report-2.24.0-FF6600?style=for-the-badge&logo=allure&logoColor=white)](https://qameta.io/allure-report/)
[![Log4j2](https://img.shields.io/badge/Log4j2-2.20.0-black?style=for-the-badge&logo=apache)](https://logging.apache.org/log4j/2.x/)

Bu proje; modern web uygulamaları için **Gauge**, **Selenium WebDriver** ve **Java** teknolojileri kullanılarak geliştirilmiş, ölçeklenebilir, BDD yaklaşımını benimseyen ve veri odaklı (Data-Driven) bir uçtan uca (End-to-End) test otomasyon çatı mimarisidir.

Framework; element tanımlayıcılarını (locator) ve test verilerini Java kodunun içine gömmek yerine **bağımsız JSON dosyaları** üzerinden dinamik olarak yönetecek şekilde tasarlanmıştır. Bu sayede yeni senaryolar eklenirken çoğu zaman tek bir satır Java kodu yazmadan, yalnızca JSON konfigürasyonu ve Gauge Markdown adımlarıyla test senaryoları koşulabilmektedir.

---

## 📌 Temel Özellikler ve Mimari Yaklaşım

- **🧩 Yeniden Kullanılabilir Parametrik Adımlar (Generic Step Definitions):**  
  Her sayfa için ayrı ayrı tıklama ya da metin yazma metodları oluşturmak yerine, parametrik Gauge adımları (`User clicks <element> on <page> page.`, `User enters <text> into <element> on <page> page.`) kullanılarak kod tekrarı sıfıra indirgenmiştir.
- **📁 JSON Tabanlı Dinamik Locator Yönetimi:**  
  `LocatorManager` sınıfı, belirtilen sayfa adına göre ilgili `src/test/resources/locators/<page>locators.json` dosyasını otomatik okur. `id`, `xpath`, `css`, `name`, `class` gibi popüler seçicileri destekler.
- **🗃️ Veri Odaklı Test (Data-Driven Testing):**  
  Test verileri `src/test/resources/testdata/` altındaki JSON dosyalarında tutulur. Senaryo adımlarında `"login.standardUser"` şeklinde dosya ve anahtar adı belirtilerek veriler dinamik olarak çözümlenir (`TestDataHelper`).
- **🌐 Çoklu Tarayıcı Desteği & Gizli Mod:**  
  Chrome ve Firefox tarayıcılarını destekler. Tarayıcılar izole test çalıştırması için varsayılan olarak gizli modda (`--incognito` ve `-private`) ve tam ekran açılır. Driver sürücüleri `WebDriverManager` tarafından otomatik indirilir.
- **📊 Allure 2 Raporlama & Otomatik Hata Ekran Görüntüsü:**  
  `BaseTest` ve `AllureStepRunner` entegrasyonu sayesinde her adım Allure raporuna ayrıntılı yansıtılır. Bir adım başarısız olduğunda sistem anında ekran görüntüsü (screenshot) alıp rapora ekler.
- **🛡️ Gelişmiş Etkileşimler:**  
  Dinamik explicit wait (`WaitHelper`), JavaScript tabanlı Shadow DOM eleman kontrolü (örn. N11 çerez pop-up kapatma), JavaScript Alert yönetimi ve dropdown işlemleri desteklenir.
- **🎯 Çoklu Uygulama Desteği:**  
  Framework içerisinde [Practice Software Testing (Toolshop)](https://practicesoftwaretesting.com/), [SauceDemo](https://www.saucedemo.com/) ve [N11](https://www.n11.com/) için hazırlanmış test senaryoları mevcuttur.

---

## 🛠️ Teknoloji Yığını

| Teknoloji | Sürüm | Açıklama |
| :--- | :--- | :--- |
| **Java** | 11+ (17 Uyumlu) | Temel programlama dili |
| **Gauge** | 0.10.3+ | Doğal dille test yazımı sağlayan BDD framework |
| **Selenium WebDriver** | 4.34.0 | Tarayıcı otomasyon motoru |
| **Apache Maven** | 3.8+ | Proje ve bağımlılık yönetim aracı |
| **gauge-maven-plugin** | 1.6.3 | Maven üzerinden Gauge testlerini yürütme eklentisi |
| **WebDriverManager** | 6.3.0 | Otomatik browser driver (ChromeDriver/GeckoDriver) yönetimi |
| **AssertJ** | 3.27.3 | Akıcı ve okunabilir test doğrulama (assertion) kütüphanesi |
| **Jackson Databind** | 2.15.2 | JSON formatındaki locator ve test verilerini işleme |
| **Allure Report** | 2.24.0 | Test sonuçlarını görselleştiren gelişmiş raporlama aracı |
| **Log4j 2** | 2.20.0 | Detaylı konsol ve dosya bazlı loglama altyapısı |

---

## ⚙️ Ön Gereksinimler

Testleri çalıştırmadan önce makinenizde aşağıdaki araçların kurulu olması gerekmektedir:

1. **JDK 11 veya üstü** (JDK 17 önerilir):
   ```bash
   java -version
   ```
2. **Apache Maven 3.8+**:
   ```bash
   mvn -version
   ```
3. **Gauge CLI**:  
   Gauge CLI sisteminizde kurulu olmalıdır. Kurulumun ardından mutlaka Java eklentisi yüklenmelidir:
   - **Windows (Chocolatey ile):**
     ```bash
     choco install gauge
     gauge install java
     ```
   - **macOS (Homebrew ile):**
     ```bash
     brew install gauge
     gauge install java
     ```
4. **Google Chrome** ve/veya **Mozilla Firefox** tarayıcıları.
5. **Allure Commandline** *(Raporları yerel ortamda görüntülemek için)*:
   - Windows: `scoop install allure` veya `choco install allure-commandline`
   - macOS: `brew install allure`

---

## 📥 Kurulum ve Başlangıç

1. **Projeyi Klonlayın:**
   ```bash
   git clone https://github.com/gzdcelikkol/test_otomasyon_projesi.git
   cd test_otomasyon_projesi
   ```

2. **Gauge Java Eklentisinin Kurulu Olduğundan Emin Olun:**
   ```bash
   gauge install java
   ```

3. **Maven Bağımlılıklarını İndirin:**
   ```bash
   mvn clean install -DskipTests
   ```

4. **Konfigürasyonu İnceleyin:**  
   Proje kök dizininde bulunan [config.properties](file:///c:/Users/gozde.celikkol/Desktop/proje/Test-Otomasyon/config.properties) dosyası başlangıç URL'ini belirler:
   ```properties
   url = https://practicesoftwaretesting.com/
   ```

---

## 📂 Proje Dizin Yapısı

```
test_otomasyon_projesi/
├── specs/                                  # Gauge BDD spesifikasyon dosyaları
│   ├── n11/                                # N11 e-ticaret test senaryoları
│   │   └── login-n11.spec
│   ├── sauce-demo/                         # SauceDemo senaryoları
│   │   ├── Cart.spec                       # Sepet işlemleri
│   │   ├── Full.spec                       # Uçtan uca sipariş akışı
│   │   ├── Inventory.spec                  # Ürün filtreleme ve listeleme
│   │   ├── Login.spec                      # Giriş doğrulama testleri
│   │   └── Logout.spec                     # Çıkış testleri
│   ├── toolshop/                           # Practice Software Testing senaryoları
│   │   ├── cart.spec                       # Sepet akışları
│   │   ├── inventory.spec                  # Kategori ve ürün seçimi
│   │   ├── login.spec                      # Pozitif/negatif login testleri
│   │   └── logout.spec                     # Çıkış senaryoları
│   └── example.spec
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java           # @BeforeScenario (tarayıcı & Allure açılış), @AfterScenario (kapanış)
│       │   ├── driverManager/
│       │   │   └── Driver.java             # WebDriver Factory (Chrome & Firefox, Incognito, Maximize)
│       │   ├── helpers/
│       │   │   ├── ElementHelper.java      # Akıllı tıklama, veri girişi ve dropdown seçim işlemleri
│       │   │   ├── ScreenshotHelper.java   # Hata anında ekran görüntüsü yakalayıp Allure'a ekleme
│       │   │   ├── TestDataHelper.java     # "login.standardUser" formatındaki test verilerini ayrıştırma
│       │   │   ├── VerifyHelper.java       # AssertJ tabanlı görünürlük doğrulamaları
│       │   │   └── WaitHelper.java         # Dinamik WebDriverWait ve Alert bekleme mekanizmaları
│       │   ├── locators/
│       │   │   └── LocatorManager.java     # JSON dosyasından okunan element tipini By seçicisine dönüştürme
│       │   ├── Steps/                      # Parametrik Gauge adım tanımları (Glue code)
│       │   │   ├── AlertSteps.java         # JavaScript Alert onaylama/mesaj doğrulama adımları
│       │   │   ├── ClickSteps.java         # Parametrik tıklama adımları
│       │   │   ├── CookieSteps.java        # Shadow DOM tabanlı çerez pop-up kapatma adımları
│       │   │   ├── SelectSteps.java        # Dropdown seçim adımları
│       │   │   ├── VerifySteps.java        # Element görünürlük doğrulama adımları
│       │   │   ├── WaitSteps.java          # Dinamik/statik bekleme adımları
│       │   │   └── WriteSteps.java         # Metin giriş ve klavye aksiyon adımları
│       │   └── utils/
│       │       ├── AllureStatusHolder.java # Thread-safe senaryo durum takibi
│       │       ├── AllureStepRunner.java   # Adım yaşam döngüsü, hata yakalama ve loglama köprüsü
│       │       ├── ConfigReader.java       # config.properties dosyasını okuyan yardımcı sınıf
│       │       ├── JsonReader.java         # Jackson tabanlı genel JSON okuyucu
│       │       └── TestDataReader.java     # testdata/ klasöründeki JSON verilerini okuyan sınıf
│       └── resources/
│           ├── locators/                   # Sayfa bazlı locator JSON dosyaları
│           │   ├── cartlocators.json
│           │   ├── checkoutlocators.json
│           │   ├── inventorylocators.json
│           │   ├── loginlocators.json
│           │   ├── n11locators.json
│           │   └── toolshoplocators.json
│           ├── testdata/                   # Test verisi JSON dosyaları
│           │   └── login.json
│           └── log4j2.xml                  # Konsol ve dosya loglama konfigürasyonu
├── config.properties                       # Test ortam URL konfigürasyonu
├── pom.xml                                 # Maven bağımlılıkları ve plugin yapılandırması
└── README.md                               # Proje dokümantasyonu
```

---

## 🚀 Testleri Çalıştırma

### 1. Tüm Testleri Çalıştırma
```bash
mvn clean test
```
veya doğrudan Gauge CLI ile:
```bash
gauge run specs/
```

### 2. Belirli Bir Modülü veya Dizini Çalıştırma
```bash
# Sadece Toolshop testlerini çalıştırmak için
mvn clean test -Dgauge.specs="specs/toolshop"

# Sadece SauceDemo testlerini çalıştırmak için
mvn clean test -Dgauge.specs="specs/sauce-demo"

# Sadece N11 testlerini çalıştırmak için
mvn clean test -Dgauge.specs="specs/n11"
```

### 3. Tek Bir Spec Dosyasını Çalıştırma
```bash
mvn clean test -Dgauge.specs="specs/toolshop/login.spec"
```

### 4. Tarayıcı Seçimi (Browser Selection)

Proje varsayılan olarak **Chrome** ile çalışır. Farklı bir tarayıcı seçmek için işletim sistemi düzeyinde `BROWSER` ortam değişkeni (environment variable) tanımlanır.

> [!NOTE]
> **Neden Ortam Değişkeni?**  
> Gauge testleri Maven altında ayrı bir alt süreç (subprocess) olarak başlatır. Bu nedenle `-Dbrowser=firefox` şeklindeki JVM parametreleri Gauge sürecine aktarılmaz. Bu sebeple işletim sistemi seviyesindeki `BROWSER` ortam değişkeni kullanılır.

- **Windows PowerShell:**
  ```powershell
  $env:BROWSER="firefox"
  mvn clean test
  ```

- **Windows CMD:**
  ```cmd
  set BROWSER=firefox
  mvn clean test
  ```

- **macOS / Linux:**
  ```bash
  BROWSER=firefox mvn clean test
  ```

---

## 📊 Raporlama (Allure Reporting)

Test adımları koşulurken sonuçlar otomatik olarak `allure-results/` dizinine yazılır. Hata alan adımlarda `ScreenshotHelper` aracılığıyla tam sayfa ekran görüntüsü çekilip rapora eklenir.

Raporu yerel tarayıcınızda interaktif olarak başlatmak için:
```bash
allure serve allure-results
```

Statik HTML raporu üretmek için:
```bash
allure generate allure-results --clean -o allure-report
allure open allure-report
```

---

## 🧩 Hazır Step Şablonları & Örnek Senaryo

Projede tanımlı genel adımlar sayesinde neredeyse hiç Java kodu yazmadan yeni testler oluşturabilirsiniz:

| Gauge Adımı | Açıklama | Örnek |
| :--- | :--- | :--- |
| `* User clicks <element> on <page> page.` | İlgili sayfadaki belirtilen elemente tıklar | `* User clicks "loginButton" on "login" page.` |
| `* User enters <text> into <element> on <page> page.` | Elementi temizler ve metni/veriyi yazar | `* User enters "login.standardUser" into "email" on "toolshop" page.` |
| `* User enters <text> into <element> on <page> and enter.` | Metni yazar ve `ENTER` tuşuna basar | `* User enters "n11login.password" into "passwordInput" on "n11" and enter.` |
| `* User should see <element> on <page> page.` | Elementin görünür olduğunu AssertJ ile doğrular | `* User should see "my-account" on "toolshop" page.` |
| `* User selects <text> from <element> dropdown on <page> page.` | Dropdown menüden görünür metne göre seçim yapar | `* User selects "Price (High - Low)" from "sort" dropdown on "inventory" page.` |
| `* User verifies alert message is <expectedMessage> and accepts it` | Alert mesajını doğrular ve Tamam'a basar | `* User verifies alert message is "Ürün eklendi" and accepts it` |
| `* User accepts cookies.` | Shadow DOM altındaki çerez pop-up'ını JavaScript ile onaylar | `* User accepts cookies.` |
| `* User waits for <seconds> seconds` | Belirtilen saniye kadar statik bekleme yapar | `* User waits for 3 seconds` |

### Örnek Spec Dosyası (`specs/toolshop/login.spec`)
```gauge
# Login

## Login with valid username & password
* User clicks "sign-in-link" on "toolshop" page.
* User enters "login.standardUser" into "email" on "toolshop" page.
* User enters "login.password" into "password" on "toolshop" page.
* User clicks "log-in-button" on "toolshop" page.
* User should see "my-account" on "toolshop" page.
```

---

## ➕ Yeni Bir Test Senaryosu Nasıl Eklenir?

1. **Locator Tanımlayın:**  
   `src/test/resources/locators/` altına sayfanız için `<sayfa_adi>locators.json` dosyasını ekleyin (veya mevcut dosyaya yeni anahtar ekleyin):
   ```json
   {
     "submit-btn": {
       "type": "css",
       "value": "button[type='submit']"
     },
     "user-title": {
       "type": "xpath",
       "value": "//h1[@class='welcome']"
     }
   }
   ```
2. **Test Verisi Ekleyin (Opsiyonel):**  
   `src/test/resources/testdata/` altına ilgili JSON dosyasına test verinizi kaydedin.
3. **Senaryoyu Yazın:**  
   `specs/` altında yeni bir `.spec` dosyası oluşturun ve yukarıdaki hazır adımları kullanarak senaryonuzu tamamlayın:
   ```gauge
   # Dashboard Testleri

   ## Kullanici Girisi ve Panel Dogrulama
   * User enters "login.standardUser" into "email" on "toolshop" page.
   * User clicks "submit-btn" on "toolshop" page.
   * User should see "user-title" on "toolshop" page.
   ```

---

## 📝 Loglama (Logging)

Projede **Log4j 2** kütüphanesi yapılandırılmıştır:
- Konsol çıktısında zaman damgası, thread ve log seviyesi yer alır.
- Tüm loglar `logs/test-automation.log` dosyasına anlık olarak yazılır.
- Yapılandırma dosyası: [log4j2.xml](file:///c:/Users/gozde.celikkol/Desktop/proje/Test-Otomasyon/src/test/resources/log4j2.xml)

---

## 🤝 Katkıda Bulunma

1. Bu depoyu fork'layın veya doğrudan bir çalışma dalı (branch) açın:
   ```bash
   git checkout -b feature/yeni-senaryolar
   ```
2. Değişikliklerinizi commit'leyin:
   ```bash
   git commit -m "feat: yeni sepet doğrulama adımları eklendi"
   ```
3. Dalınızı uzak depoya push'layın:
   ```bash
   git push origin feature/yeni-senaryolar
   ```
4. GitHub üzerinden bir **Pull Request (PR)** oluşturun.

---

## 📄 Lisans

Bu proje kişisel eğitim ve test otomasyon yetkinliklerini geliştirme amacıyla hazırlanmıştır. Açık kaynak olarak incelenebilir ve kullanılabilir.
