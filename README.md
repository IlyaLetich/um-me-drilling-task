Java Enterprise Test Project 
===============================

Разработать Spring Boot/JPA Enterprise на основе технологий Java: сборка Maven либо Gradle, Spring MVC, Postgresql или H2.
Минималистичейий UI приветсвуется, но не обязателен

Разработать API для CRUD операций над отверстиями в детали 
Мебельная деталь это параллелепипед с высотой, как правило от 4 до 50мм
Отверстия могут распологаться в любую грань детали, но только по нормали к грани  (отвесртяи под углом к граням детали сиклбчаем)
У отверстия есть пармерты диаметр, глубина, скорость входа сверла, скорость выхода (скорость условна), кординаты  
Кординаты отверстия могут задваться через переменные, в том числе  через паттерны, (L/2 + B*0.5 +H/3), 
при этом должыны поддрживаться простые операци над переменными +-/*,
переменных может быть неограниченное количесво, паттерн должен поддержтвать редактирование
Результат сбросить ссылкой репозитория на https://github.com/ на upmehrandrewgl@gmail.com