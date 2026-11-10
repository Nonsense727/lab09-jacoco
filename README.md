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

## 3. Хэсэг A — Happy path тестүүд ба эхний хэмжилт

`src/test/java/mn/edu/must/sqat/ScholarshipCalculatorTest.java` файлд зөвхөн
хэвийн урсгалын **5 тест** бичсэн:

| № | Тест | Шалгадаг |
|---|---|---|
| A1 | `letterGrade_95_returnsA` | `letterGrade(95)` = `"A"` |
| A2 | `letterGrade_85_returnsB` | `letterGrade(85)` = `"B"` |
| A3 | `gpa_95and85_returns3point5` | `gpa([95, 85])` = `3.5` |
| A4 | `scholarship_gpa3point9_16credits_noViolation_returns100` | `scholarship(3.9, 16, false)` = `100` |
| A5 | `scholarship_gpa3point5_13credits_noViolation_returns70` | `scholarship(3.5, 13, false)` = `70` |

`mvn verify` (гаралт: `results/mvn-verify-A.txt`):

```
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

`results/jacoco-A.csv`-ийн `ScholarshipCalculator` мөр:

```
INSTRUCTION_MISSED=50  INSTRUCTION_COVERED=102
BRANCH_MISSED=21       BRANCH_COVERED=20
LINE_MISSED=10         LINE_COVERED=15
```

| Хэмжүүр | Хамрагдсан / Нийт | Хувь |
|---|---|---|
| Instruction | 102 / 152 | 67.1% |
| **Branch** | **20 / 41** | **48.8%** |
| **Line** | **15 / 25** | **60.0%** |

Энэ нь зааврын хүлээлттэй таарч байна (Line ≈ 60%, Branch ≈ 50%).

**Шар ромбо (хагас хамрагдсан салаа) бүхий мөрүүд.** `letterGrade()`-ийн
`score < 0 || score > 100` нөхцөлд зөвхөн хоёр тал нь `false` болсон — `score > 100`
үнэн болох тохиолдол шалгагдаагүй. `gpa()`-ийн `scores == null || scores.length == 0`
нөхцөлд `null` тал нь огт шалгагдаагүй. `scholarship()`-ийн `hasViolation` болон
`gpa >= 3.8 && credits >= 15` нөхцлүүдийн зөвхөн нэг тал нь ажилласан тул шар
тэмдэглэгдсэн.

**Улаан (огт хүрээгүй) мөрүүд.** Гурван функцийн `throw new IllegalArgumentException(...)`
мөрүүд, `letterGrade()`-ийн `score >= 70`, `score > 60` болон `return "F"` мөрүүд,
`gpa()`-ийн `switch`-ийн `C`, `D`, `default` салаанууд, `scholarship()`-ийн
`gpa >= 3.0` ба `return 50`, `return 0` мөрүүд улаанаар харагдана. Эдгээр нь
алдааны зам ба 80-аас доош оноо, 3.0-аас доош голч гэх мэт хараахан тестлээгүй
тохиолдлууд юм.

## 4. Хэсэг B — CFG ба branch 100%

Энэ хэсгийг дараагийн алхамд бөглөнө.

## 5. Хэсэг C — Давталтын заагийн тестүүд

Энэ хэсгийг дараагийн алхамд бөглөнө.

## 6. Хэсэг D — Хамралт 100% боловч алдаа амьд

Энэ хэсгийг дараагийн алхамд бөглөнө.

## 7. Дүгнэлт

Энэ хэсгийг эцсийн алхамд бөглөнө.

## 8. AI ашигласан тухай

Энэ хэсгийг эцсийн алхамд бөглөнө.

## 9. Ажлын явц (commit-ийн түүх)

Энэ хэсгийг эцсийн алхамд бөглөнө.
