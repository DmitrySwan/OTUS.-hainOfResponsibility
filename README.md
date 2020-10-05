# OTUS.ChainOfResponsibility
Проект в рамках обучения на платформе OTUS.

## Курс: Архитектура и шаблоны проектирования.

### Занятия: Цепочка обязанностей.

Задание: Парсер файлов в зависимости от их типа и описание применения шаблона в проекте
         Цель: Получите навыки применения шаблона "цепочка ответственности"
         Программа, реализующая алгоритм, получает на вход список файлов. И каждый попадает в обработку алгоритма.

         На вход алгоритма передаётся ряд файлов, которые имеют различный тип (Xml, JSON, CSV, txt)
         Требуется создать цепочку обработки этих файлов, где отдельный обработчик отвечает за обработку конкретного типа документа.
         Обработчик логирует получение подходящего ему файла в виде "обработчик TXT получил файл filename.txt" и копирует содержимое в выходной файл.

         требуется:
         1. создать программу, где на вход подаётся путь файла со списком обрабатываемых файлов и путь выходного файла.
         2. реализовать алгоритм обработки с помощью шаблона "Цепочка ответственности"
         3. нарисовать диаграмму классов.
         Если потребуется использовать шаблон в проектной работе, предоставить описание в текстовом файле в GitHub репозитории где конкретно и в какой роли используется этот шаблон.
         
## Запуск:
1. mvn clean test -DsuiteXmlFile=testng.xml 
    или
2. mvn clean test
3. mvn clean install (если необходимо собрать исполняемый jar файл ChainOfResponsibility-1.0-jar-with-dependencies.jar, после сборки лежит в target)

### Описание тестирования:
###### 1 Способ. Уже собранный jar-файл (ChainOfResponsibility-1.0-jar-with-dependencies.jar) расположен в корне проекта.
Пример запуска через cmd:  java -jar ChainOfResponsibility-1.0-jar-with-dependencies.jar -i inputFile.txt -o outputFile.txt

Пример формата заполнения файла input(файл, в котором прописываются пути для файлов разных форматов) можно посмотреть в src/test/resources
Примеры заполнения файлов разных форматов(txt,xml,json,csv) можно посмотреть в src/test/resources/chainOfRepositoryTestFiles

###### 2 Способ.Тест расположен в директории src/test/java.
input и expected output файлы лежат в src/test/resources.
В процессе запуска тестирования они программно копируются в папку target/test-classes/,
где в результате тестов(по одному тесту на каждый тип сортировки) генерится свой файл output, который сравнивается с expected output

### Логирование: 
Файл report.log созданиется в директории проекта/jar файла.
Содержит информацию о входном массиве, способе сортировке и выходном массиве.

##### Диаграмма классов:
Файл diagram.png находится в корне проекта (сгенерирован ресурсами Intelij IDEA)

#### Версии с которыми разрабатывалось приложение:

java version "11.0.8" 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
Apache Maven 3.3.9

##### Библиотеки:

json-simple:https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1

xstream:https://mvnrepository.com/artifact/com.thoughtworks.xstream/xstream/1.4.13

gson:https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6

opencsv:https://mvnrepository.com/artifact/com.opencsv/opencsv/5.2

log4j:https://mvnrepository.com/artifact/log4j/log4j/1.2.17

testng:https://mvnrepository.com/artifact/org.testng/testng/7.3.0

commons-cli:https://mvnrepository.com/artifact/commons-cli/commons-cli/1.3.1

commons-io:https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
