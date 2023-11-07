# Unit-tests для Stellar Burgers

Этот проект содержит unit-tests для **[Stellar Burgers](https://stellarburgers.nomoreparties.site/)**.

## Описание проекта

- Используемые технологии:

    - `Java11`
    - `Junit4`
    - `Mockito`
    - `Jacoco`
    - `Maven`

- Структура проекта:

    - `src/test/java` - тесты
    - `pom.xml` - зависимости, настройки сборки и запуска тестов
    - `target/site/jacoco` - отчёт покрытия тестами

## Запуск тестов

Для запуска всех тестов:

```bash
mvn clean test
```

Отчет Jacoco можно сформировать
```bash
mvn verify
```
