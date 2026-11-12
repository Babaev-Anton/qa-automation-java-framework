# QA Automation Framework (Java)

Учебный проект по автоматизации тестирования веб-интерфейса и REST API на Java. Показывает, как я строю тестовый фреймворк: Page Object, разные UI-инструменты (Selenium и Selenide), API-тесты, моки, отчёты и логирование.

**Тестируемые приложения** (публичные учебные сайты):
- UI: [the-internet.herokuapp.com](https://the-internet.herokuapp.com)
- API: [jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

## Стек

| Область | Инструменты                  |
|---|------------------------------|
| Язык | Java                         |
| UI-автотесты | Selenium WebDriver, Selenide |
| API-автотесты | REST Assured                 |
| Моки | WireMock                     |
| Тест-раннер | TestNG (`testng.xml`)        |
| Отчёты | Allure                       |
| Логирование | Log4j2                       |
| Сборка | Maven                        |

## Что реализовано

- **Page Object** — страницы вынесены в отдельный слой (`src/main/java/pages`).
- **Управление браузером** — `BrowserFactory`, `DriverManager`, `ConfigManager` (`com.qa.config`). Настройки лежат в `config.properties`, а не в коде.
- **UI-тесты на Selenium и Selenide** — одни и те же сценарии (логин, чекбоксы, добавление/удаление элементов, динамическая загрузка) реализованы двумя способами.
- **API-тесты на REST Assured** — запросы к JSONPlaceholder, модель данных `Post`.
- **Моки на WireMock** — тесты не зависят от внешнего сервиса, включая проверку поведения при ошибках (`ApiRecoveryTest`, `WireMockDemoTest`).
- **Allure-отчёты** и логирование через Log4j2.

## Покрытые сценарии (the-internet)

Login / Secure Area, Checkboxes, Dropdown, Add/Remove Elements, Dynamic Loading, Data Tables, Hovers, Key Presses, Entry Ad.

## Структура проекта

```
src
├── main/java
│   ├── com/qa/config     # BrowserFactory, DriverManager, ConfigManager
│   ├── models            # Post (модель для API-тестов)
│   └── pages             # Page Object классы
└── test
    ├── java/com/qa
    │   ├── pageObject    # UI-тесты на Page Object (Selenium)
    │   ├── selenide      # UI-тесты на Selenide
    │   ├── restAssured   # API-тесты и WireMock
    │   └── *.java        # TestNG-тесты (логин, чекбоксы и др.)
    └── resources
        ├── config.properties
        ├── log4j2.xml
        └── testng.xml
```

## Запуск

Требования: JDK, Chrome.

```bash
# все тесты
mvn clean test

# отчёт Allure (нужен установленный Allure CLI)
allure serve allure-results
```

Параметры (браузер, URL и т.д.) задаются в `src/test/resources/config.properties`.

## Чему я здесь научился

- Проектировать тесты по Page Object и разделять слои: страницы, конфигурация, тесты.
- Сравнивать Selenium и Selenide и выбирать подходящий инструмент.
- Тестировать API и изолировать тесты от внешних сервисов через моки.
- Собирать понятную отчётность (Allure) и логи для разбора упавших тестов.

## Дальнейшие планы

- Запуск тестов в CI (GitHub Actions) с публикацией Allure-отчёта.
- Параллельный запуск и запуск в Docker/Selenium Grid.
- Расширение API-тестов: валидация схем, негативные сценарии.

