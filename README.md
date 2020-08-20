#ELS Maven DB Demo
This application is a learning process support tool.

## What does it do?
Główne cele aplikacji to stworzyć bazę pytań i odpowiedzi




##What is to be done?

0. Wykonanie schematu bazy danych.
1. Dodawanie pytań oraz odpowiedzi (tworzenie "bazy wiedzy") z możliwością dodawania, usuwania i edycji pytań i odpowiedzi. Pytania powinny posiadać kategorię, oraz jeśli to możliwe, to również inne atrybuty umożliwiające grupowanie (np. kategorię/dziedzinę).
2. Dodawanie użytkownika.
3. Podejmowanie testu przez użytkownika. W pierwszym kroku pobranie pojedynczego pytania, a następnie udzielenie odpowiedzi przez użytkownika. Po podaniu odpowiedzi wyświetlamy wynik (poprawna/błędna odpowiedź na to pytanie). Po całym teście podajemy wynik testu (ilość poprawnych odpowiedzi/całkowita ilość). W tym kroku nie śledzimy postępów.
4. Dodanie postępu uczenia - po każdym pytaniu użytkownik może podać (sam) ocenę znajomości zagadnienia. Informacja będzie zapisywana w bazie danych.
5. Usprawnienie losowania pytań - w zależności od statystyki zmodyfikować proces losowania pytania, aby pytania pojawiały się w odstępie czasu dostosowanym do znajomości zagadnienia.
6. Napisanie implementacji
7. Napisanie testów

## How tu build?
To build this application:
```
com.sda.javagda40.elx_maven_db_project
```
To run this application:
```
cd target
java -jar applicationName.jar

```

##Authors
JavaGda40 SDA
