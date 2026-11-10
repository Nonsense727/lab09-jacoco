# Лаборатори №9 — Код хамралт: JaCoCo-гоор тестээ хөтлөх

**Оюутан:** Т. Амармэнд
**Оюутны код:** B232270036
**Хичээл:** F.CSA313 — Программ хангамжийн чанарын баталгаа ба тест (2026)
**Репозитор:** https://github.com/Nonsense727/lab09-jacoco

---

## 1. Орчны хувилбар

```
$ export JAVA_HOME=/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home
$ export PATH="$JAVA_HOME/bin:$PATH"

$ java -version
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment Homebrew (build 21.0.12.1)
OpenJDK 64-Bit Server VM Homebrew (build 21.0.12.1, mixed mode, sharing)

$ mvn -version
Apache Maven 3.10.0 (c43a36b8d67be7e0805a411bc0898af1a51f5472)
Maven home: /opt/homebrew/Cellar/maven/3.10.0/libexec
Java version: 21.0.12.1, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk@21/21.0.12.1/libexec/openjdk.jdk/Contents/Home
Default locale: en_MN, platform encoding: UTF-8, time zone: Asia/Ulaanbaatar
OS name: "mac os x", version: "27.0.1", arch: "aarch64", family: "mac"
```

## 2. Төслийн бүтэц

```
lab09-jacoco/
├── pom.xml
├── .gitignore
├── README.md
├── cfg.png
├── results/
└── src/
    ├── main/java/mn/edu/must/sqat/ScholarshipCalculator.java
    └── test/java/mn/edu/must/sqat/ScholarshipCalculatorTest.java
```

Тайлангийн хэсгүүдийг ажлын явцад бөглөнө.
